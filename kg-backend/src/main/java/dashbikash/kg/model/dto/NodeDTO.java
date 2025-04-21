package dashbikash.kg.model.dto;

public class NodeDTO {
	private String id;
	private String name;
	private String type;
	public NodeDTO(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public NodeDTO() {
		
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
