package a.b.c.autovcs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import a.b.c.autovcs.models.persistent.GHPullRequest;
import a.b.c.autovcs.models.persistent.GHRepository;
import a.b.c.autovcs.models.persistent.GitUser;

public interface GHPullRequestRepository extends JpaRepository<GHPullRequest, Long> {

    public List<GHPullRequest> findByRepository ( GHRepository repository );

    public List<GHPullRequest> findByOpenedBy ( GitUser user );

    public List<GHPullRequest> findByMergedBy ( GitUser user );

}
