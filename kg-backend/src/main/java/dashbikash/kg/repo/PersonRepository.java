package dashbikash.kg.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import dashbikash.kg.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long>{
	  Person findByEmail(String email);
}
