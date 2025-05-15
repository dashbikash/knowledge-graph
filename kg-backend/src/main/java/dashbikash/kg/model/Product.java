package dashbikash.kg.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Product {
	@Id @GeneratedValue 
	private Long id;
	
	private String productId;
	private String name;
	private String description;
	private String category;
	private List<String> tags;
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Product() {
	}

	public Product(String productId, String name, String description, String category, List<String> tags) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.category = category;
		this.tags = tags;
	}


	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Relationship(type = "COMPONENT_LEAD")
	private Person componentLead;
	@Relationship(type = "ENGINEER")
	private Set<Person> engineers;
	@Relationship(type = "FEATURE")
	private Set<Feature> features;
	
	public Person getComponentLead() {
		return componentLead;
	}

	public Set<Person> getEngineers() {
		return engineers;
	}

	public void addEngieer(Person person) {
		if (engineers == null) {
			engineers = new HashSet<>();
		}
		engineers.add(person);
	}
	public void deleteEngieer(Person person) {
		if (engineers == null) {
			engineers.remove(person);
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setComponentLead(Person person) {
		componentLead=person;
	}
	public void addFeature(Feature feature) {
		if (features == null) {
			features = new HashSet<>();
		}
		features.add(feature);
	}
	public void deleteFeature(Feature feature) {
		if (features == null) {
			features.remove(feature);
		}
	}
	

}
