package dashbikash.kg.dto;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import dashbikash.kg.model.Product;

public interface ProductRepository extends Neo4jRepository<Product,Long>{
	Product findByProductId(String productId);

}
