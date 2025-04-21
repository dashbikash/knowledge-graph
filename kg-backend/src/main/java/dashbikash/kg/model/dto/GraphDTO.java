package dashbikash.kg.model.dto;

import java.util.List;

public class GraphDTO {
	private List<NodeDTO> nodes;
	private List<EdgeDTO> edges;

	public GraphDTO() {
	}
	public GraphDTO(List<NodeDTO> nodes, List<EdgeDTO> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	public List<NodeDTO> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeDTO> nodes) {
		this.nodes = nodes;
	}

	

	public List<EdgeDTO> getEdges() {
		return edges;
	}

	public void setEdges(List<EdgeDTO> edges) {
		this.edges = edges;
	}
	public static class Types{
		public static final String PRODUCT = "Product";
		public static final String ENGINEER = "Engineer";
		public static final String COMPONENT_LEAD = "ComponentLead";
	}

}
