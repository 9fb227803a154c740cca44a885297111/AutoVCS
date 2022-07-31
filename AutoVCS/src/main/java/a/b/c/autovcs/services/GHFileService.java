package a.b.c.autovcs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import a.b.c.autovcs.models.persistent.GHCommit;
import a.b.c.autovcs.models.persistent.GHFile;
import a.b.c.autovcs.repositories.GHFileRepository;

@Component
@Transactional
public class GHFileService extends Service<GHFile, Long> {

    @Autowired
    private GHFileRepository repository;

    @Override
    protected JpaRepository<GHFile, Long> getRepository () {
        return repository;
    }

    public List<GHFile> findByCommit ( final GHCommit commit ) {
        return repository.findByAssociatedCommit( commit );
    }

}
