package dashbikash.kg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dashbikash.kg.service.GraphService;

@RestController
@RequestMapping("/api/graph")
@CrossOrigin(maxAge = 3600)
public class GraphController {
	private GraphService graphService;
	public GraphController(GraphService graphService) {
		this.graphService = graphService;
	}

	@GetMapping()
	public ResponseEntity<Object> fullProductGraph() {
		return ResponseEntity.ok(graphService.getFullGraph());
	}
	
	
	
	
	
}
