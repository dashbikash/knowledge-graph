package dashbikash.kg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/graph")
public class GraphController {

	@GetMapping("")
	public String index() {
		return "Api For Graph";
	}
}
