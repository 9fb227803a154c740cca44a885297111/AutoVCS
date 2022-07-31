package a.b.c.autovcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import a.b.c.autovcs.models.persistent.GHRepository;

public interface GHRepositoryRepository extends JpaRepository<GHRepository, Long> {

    public GHRepository findByRepositoryNameAndOrganisationName ( String repositoryName, String organisationName );

}
