package lab6.repo;

import lab6.entity.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepo extends CrudRepository<Citizen, String> {
}
