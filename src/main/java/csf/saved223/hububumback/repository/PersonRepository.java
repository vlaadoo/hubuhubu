package csf.saved223.hububumback.repository;

import csf.saved223.hububumback.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
}