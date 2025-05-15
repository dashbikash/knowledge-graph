package dashbikash.kg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dashbikash.kg.model.Feature;
import dashbikash.kg.model.Person;
import dashbikash.kg.model.Product;
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
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> fullProductGraphByID(@PathVariable() String id) {
		return ResponseEntity.ok(graphService.getGraphByProductID(id));
	}
	@PostMapping("/product")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		return ResponseEntity.ok(graphService.addProduct(product));
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable() long id) {
		graphService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted successfully");
	}
	
	@PutMapping("/product/{id}/engineer")
	public ResponseEntity<Object> addEngineerToProduct(@PathVariable() long id, @RequestBody Person engineer) {
		graphService.addEngineerToProduct(id, engineer);
		return ResponseEntity.ok("Engineer added to product successfully");
	}
	@PutMapping("/product/{id}/componentlead")
	public ResponseEntity<Object> addComponentLeadToProduct(@PathVariable() long id, @RequestBody Person componentLead) {
		graphService.setComponentLead(id, componentLead);
		return ResponseEntity.ok("Component Lead set to product successfully");
	}
	@PutMapping("/product/{id}/feature")
	public ResponseEntity<Object> addFeatureToProduct(@PathVariable() long id, @RequestBody Feature feature) {
		graphService.addFeatureToProduct(id, feature);
		return ResponseEntity.ok("Feature added to product successfully");
	}
	
	
	
}
