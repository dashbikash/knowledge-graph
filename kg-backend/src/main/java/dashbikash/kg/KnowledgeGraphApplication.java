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

            Person bikash = new Person("Bikash", "CL", "bikash@gmail.com");
            Person prakash = new Person("Prakash", "CL", "prakash@gmail.com");
            Person alice = new Person("Alice", "CL", "alice@gmail.com");
            Person bob = new Person("Bob", "CL", "bob@gmail.com");
            Person charlie = new Person("Charlie", "CL", "charlie@gmail.com");
            
            
            Person dash = new Person("Dash", "ENGINEER", "dash@gmail.com");
            Person eng1 = new Person("Eng 1", "ENGINEER", "eng1@gmail.com");
            Person eng2 = new Person("Eng 2", "ENGINEER", "eng2@gmail.com");
            Person eng3 = new Person("Eng 3", "ENGINEER", "eng3@gmail.com");
            Person eng4 = new Person("Eng 4", "ENGINEER", "eng4@gmail.com");
            Person eng5 = new Person("Eng 5", "ENGINEER", "eng5@gmail.com");
            Person eng6 = new Person("Eng 6", "ENGINEER", "eng6@gmail.com");
            Person eng7 = new Person("Eng 7", "ENGINEER", "eng7@gmail.com");
            Person eng8 = new Person("Eng 8", "ENGINEER", "eng8@gmail.com");
            Person eng9 = new Person("Eng 9", "ENGINEER", "eng9@gmail.com");
            Person eng10 = new Person("Eng 10", "ENGINEER", "eng10@gmail.com");
            Person eng11 = new Person("Eng 11", "ENGINEER", "eng11@gmail.com");
            Person eng12 = new Person("Eng 12", "ENGINEER", "eng12@gmail.com");
            Person eng13 = new Person("Eng 13", "ENGINEER", "eng13@gmail.com");

            Product kg = new Product(
                "knowledge-graph",
                "Knowledge Graph",
                "This is a knowledge graph",
                "addressibility",
                Arrays.asList("knowledge")
            );
            Product se = new Product(
                "search-engine",
                "Search Engine",
                "This is a search engine",
                "addressibility",
                Arrays.asList("search")
            );
            Product ai = new Product(
                "ai-platform",
                "AI Platform",
                "Platform for AI solutions",
                "intelligence",
                Arrays.asList("ai", "platform")
            );
            Product analytics = new Product(
                "analytics-suite",
                "Analytics Suite",
                "Comprehensive analytics tools",
                "data",
                Arrays.asList("analytics", "data")
            );
            Product crm = new Product(
                "crm-system",
                "CRM System",
                "Customer relationship management system",
                "customer",
                Arrays.asList("crm", "customer")
            );
            Product cms = new Product(
                "cms-platform",
                "CMS Platform",
                "Content management system",
                "content",
                Arrays.asList("cms", "content")
            );
            Product iot = new Product(
                "iot-hub",
                "IoT Hub",
                "Internet of Things management hub",
                "devices",
                Arrays.asList("iot", "devices")
            );

            productRepository.save(ai);
            productRepository.save(analytics);
            productRepository.save(crm);
            productRepository.save(cms);
            productRepository.save(iot);

            personRepository.save(bikash);
            personRepository.save(prakash);
            personRepository.save(dash);
            personRepository.save(eng1);
            personRepository.save(eng2);
            personRepository.save(eng3);
            personRepository.save(eng4);
            personRepository.save(eng5);
            personRepository.save(eng6);
            personRepository.save(eng7);
            personRepository.save(eng8);
            personRepository.save(eng9);
            personRepository.save(eng10);
            personRepository.save(eng11);
            personRepository.save(eng12);
            personRepository.save(eng13);
            personRepository.save(alice);
            personRepository.save(bob);
            personRepository.save(charlie);

            
            kg.setComponentLead(bikash);
            se.setComponentLead(prakash);
            ai.setComponentLead(alice);
            analytics.setComponentLead(bob);
            crm.setComponentLead(charlie);
        
            se.addEngieer(eng1);
            se.addEngieer(eng2);
            kg.addEngieer(eng3);
            kg.addEngieer(eng4);
            kg.addEngieer(eng5);
            ai.addEngieer(eng6);
            ai.addEngieer(eng7);
            analytics.addEngieer(eng8);
            analytics.addEngieer(eng9);
            crm.addEngieer(eng10);
            crm.addEngieer(eng11);
            cms.addEngieer(eng12);
            iot.addEngieer(eng13);
            
            productRepository.save(ai);
            productRepository.save(analytics);
            productRepository.save(crm);
            productRepository.save(cms);
            productRepository.save(iot);

            productRepository.save(kg);
            productRepository.save(se);
        };
    }
}
