package dashbikash.kg.service;

import org.springframework.stereotype.Service;

import dashbikash.kg.model.Person;
import dashbikash.kg.model.Product;
import dashbikash.kg.model.dto.EdgeDTO;
import dashbikash.kg.model.dto.GraphDTO;
import dashbikash.kg.model.dto.NodeDTO;
import dashbikash.kg.repo.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraphService {
    private final ProductRepository productRepository;

    public GraphService(ProductRepository productRepository) {
		this.productRepository = productRepository;
    }

    public GraphDTO getFullGraph() {
        List<NodeDTO> nodes = new ArrayList<>();
        List<EdgeDTO> edges = new ArrayList<>();

        // Fetch nodes and add them to the node list
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            nodes.add(new NodeDTO(product.getId().toString(), product.getName(), GraphDTO.Types.PRODUCT));	
            for (Person engineer : product.getEngineers()) {
				nodes.add(new NodeDTO(engineer.getId().toString(), engineer.getName(), GraphDTO.Types.ENGINEER));
				edges.add(new EdgeDTO(product.getId().toString(), engineer.getId().toString()));
			}
            nodes.add(new NodeDTO(product.getComponentLead().getId().toString(), product.getComponentLead().getName().toString(), GraphDTO.Types.COMPONENT_LEAD));
            edges.add(new EdgeDTO(product.getId().toString(), product.getComponentLead().getId().toString()));
        }

        return new GraphDTO(nodes, edges);
    }
}