package dashbikash.kg.service;

import org.springframework.stereotype.Service;

import dashbikash.kg.model.Feature;
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
    public GraphDTO getGraphByProductID(String id) {
		List<NodeDTO> nodes = new ArrayList<>();
		List<EdgeDTO> edges = new ArrayList<>();

		// Fetch nodes and add them to the node list
		Product product = productRepository.findByProductId(id);
		if (product != null) {
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
    public Product addProduct(Product product) {

		// Fetch nodes and add them to the node list
		
		productRepository. save(product);

		return product;
	}
    
    
    public void deleteProduct(long id) {

		// Fetch nodes and add them to the node list
    	productRepository.deleteById(id);;
    	
	}
    public void addEngineerToProduct(long id, Person engineer) {
		// Fetch nodes and add them to the node list
		productRepository.findById(id).ifPresent(p -> {
			p.addEngieer(engineer);
			productRepository.save(p);
		});
		
	}
    public void addFeatureToProduct(long id, Feature feature) {
    	// Fetch nodes and add them to the node list
		productRepository.findById(id).ifPresent(p -> {
			p.addFeature(feature);
			productRepository.save(p);
		});
		
	}
    public void setComponentLead(long id, Person componentLead) {
    	// Fetch nodes and add them to the node list
		productRepository.findById(id).ifPresent(p -> {
			p.setComponentLead(componentLead);
			productRepository.save(p);
		});
		
	}
}