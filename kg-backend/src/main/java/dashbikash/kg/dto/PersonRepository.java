package dashbikash.kg.dto;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import dashbikash.kg.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long>{
	  Person findByEmail(String email);
	  List<Person> findByTeammatesEmail(String email);
}
