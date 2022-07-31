package a.b.c.autovcs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import a.b.c.autovcs.models.persistent.GHComment;
import a.b.c.autovcs.models.persistent.GitUser;

public interface GHCommentRepository extends JpaRepository<GHComment, Long> {

    public List<GHComment> findByCommenter ( GitUser user );

}
