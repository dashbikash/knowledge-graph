package dashbikash.kg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dashbikash.kg.dto.ProductRepository;
import dashbikash.kg.model.Product;

@RestController
@RequestMapping("/api/graph")
public class GraphController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("")
	public String index() {
		return "Api For Graph";
	}
	
	@GetMapping("/test")
	public ResponseEntity<Object> getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		
		return ResponseEntity.ok(products);
	}
}
