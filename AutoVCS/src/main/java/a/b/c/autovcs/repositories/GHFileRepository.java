package a.b.c.autovcs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import a.b.c.autovcs.models.persistent.GHCommit;
import a.b.c.autovcs.models.persistent.GHFile;

public interface GHFileRepository extends JpaRepository<GHFile, Long> {

    public List<GHFile> findByAssociatedCommit ( GHCommit commit );

}
