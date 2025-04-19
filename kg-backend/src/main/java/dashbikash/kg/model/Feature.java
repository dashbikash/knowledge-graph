package dashbikash.kg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Feature {
	@Id @GeneratedValue private Long id;

	private String title;
	private String description;

}
