package a.b.c.autovcs.services;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.kohsuke.github.GHCommit.GHAuthor;
import org.kohsuke.github.GHUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import a.b.c.autovcs.AutoVCSProperties;
import a.b.c.autovcs.models.persistent.GitUser;
import a.b.c.autovcs.repositories.GitUserRepository;

@Component
@Transactional
public class GitUserService extends Service<GitUser, Long> {

    @Autowired
    private GitUserRepository repository;

    @Override
    protected JpaRepository<GitUser, Long> getRepository () {
        return repository;
    }

    public GitUser findByName ( final String name ) {
        return repository.findByName( name );
    }

    public GitUser findByNameAndEmail ( final String name, final String email ) {
        return repository.findByNameAndEmail( name, email );
    }

    public List<GitUser> findExcluded () {
        return repository.findByExcludedTrue();
    }

    public List<GitUser> findByNameContaining ( final String name ) {
        return repository.findByNameContaining( name );
    }

    public List<GitUser> findByEmailContaining ( final String email ) {
        return repository.findByEmailContaining( email );
    }

    public GitUser forUser ( final GHUser other ) {

        final String name = other.getLogin();
        String email;
        try {
            email = null == other.getEmail() ? buildEmail( other.getLogin() ) : other.getEmail();
        }
        catch ( final IOException e ) {
            email = buildEmail( other.getLogin() );
        }

        GitUser user = findByNameAndEmail( name, email );

        if ( null == user ) {
            user = new GitUser( other );
            /* Save user to force them into DB for subsequent requests */
            save( user );

        }

        return user;

    }

    static private String buildEmail ( final String username ) {
        return username + "@" + AutoVCSProperties.getEmailDomain();
    }

    public GitUser forUser ( final GHAuthor other ) {
        final String name = other.getName();
        final String email = null == other.getEmail() ? buildEmail( other.getName() ) : other.getEmail();

        GitUser user = findByNameAndEmail( name, email );

        if ( null == user ) {
            user = new GitUser( other );
            /* Save user to force them into DB for subsequent requests */
            save( user );

        }

        return user;
    }

}
