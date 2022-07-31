package a.b.c.autovcs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import a.b.c.autovcs.models.persistent.GHCommit;
import a.b.c.autovcs.models.persistent.GHRepository;
import a.b.c.autovcs.models.persistent.GitUser;

public interface GHCommitRepository extends JpaRepository<GHCommit, Long> {

    public List<GHCommit> findByAuthor ( GitUser user );

    public List<GHCommit> findByRepository ( GHRepository repository );

    public GHCommit findFirstByRepositoryOrderByCommitDateDesc ( GHRepository repository );

}
