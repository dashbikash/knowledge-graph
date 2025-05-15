package dashbikash.kg;

import dashbikash.kg.model.Feature;
import dashbikash.kg.model.Person;
import dashbikash.kg.model.Product;
import dashbikash.kg.repo.PersonRepository;
import dashbikash.kg.repo.ProductRepository;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KnowledgeGraphApplication {

    private static final Logger log = LoggerFactory.getLogger(
        KnowledgeGraphApplication.class
    );

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeGraphApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(
        PersonRepository personRepository,
        ProductRepository productRepository
    ) {
        Feature feature = new Feature();
        return args -> {
            personRepository.deleteAll();
            productRepository.deleteAll();

            Person bikash = new Person("Bikash", "PM", "bikash@gmail.com");
            Person prakash = new Person("Prakash", "CL", "prakash@gmail.com");
            Person dash = new Person("Dash", "ENGINEER", "dash@gmail.com");

            Person eng1 = new Person("Eng 1", "ENGINEER", "eng1@gmail.com");
            Person eng2 = new Person("Eng 2", "ENGINEER", "eng2@gmail.com");
            Person eng3 = new Person("Eng 3", "ENGINEER", "eng3@gmail.com");

            Product kg = new Product(
                "knowledge-graph",
                "Knowledge Graph",
                "Prod Desc",
                "addressibility",
                Arrays.asList("knowledge")
            );
            Product se = new Product(
                "search-engine",
                "Search Engine",
                "Prod Desc",
                "addressibility",
                Arrays.asList("search")
            );

            personRepository.save(bikash);
            personRepository.save(prakash);
            personRepository.save(dash);
            personRepository.save(eng1);
            personRepository.save(eng2);
            personRepository.save(eng3);

            kg.setComponentLead(bikash);
            se.setComponentLead(prakash);
            se.addEngieer(eng1);
            se.addEngieer(eng2);
            kg.addEngieer(eng3);

            productRepository.save(kg);
            productRepository.save(se);
        };
    }
}
