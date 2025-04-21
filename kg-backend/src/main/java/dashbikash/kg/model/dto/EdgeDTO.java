package dashbikash.kg.model.dto;

public class EdgeDTO {
	private String source;
	private String target;
	
	public EdgeDTO(String source, String target) {
		this.source = source;
		this.target = target;
	}

	public String getSource() {
		return source;
	}

	public EdgeDTO() {
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}




}
