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
	@Id @GeneratedValue private Long id;

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
	@Relationship(type = "CL")
	public Person componentLead;
	@Relationship(type = "PM")
	public Person prodManager;
	@Relationship(type = "TPM")
	public Person progManager;
	@Relationship(type = "ENGINEERS")
	public Set<Person> engineers;
	@Relationship(type = "ProdSupport")
	public Set<Person> prodSupport;
	
	
	
	public void associatedEngineer(Person person) {
		if (engineers == null) {
			engineers = new HashSet<>();
		}
		engineers.add(person);
	}
	
	public void associatedProdSupport(Person person) {
		if (engineers == null) {
			engineers = new HashSet<>();
		}
		engineers.add(person);
	}
	
	public void associatedCL(Person person) {
		componentLead=person;
	}
	public void assiciatedPM(Person person) {
		prodManager=person;
	}
	public void assiciatedTPM(Person person) {
		progManager=person;
	}
	

}
