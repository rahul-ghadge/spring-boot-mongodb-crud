# spring-boot-mongodb

This project explains CRUD operations using MongoTemplate and MongoRepository using spring boot and mongo DB.
In this app we are using Spring Data JPA for built-in methods to do CRUD operations and Mongo queries using MongoTemplate.     
`@EnableMongoRepositories` annotation is used on main class to Enable Mongo related configuration, which will read properties from `application.properties` file.



## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Mongo DB](https://docs.mongodb.com/guides/)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)


## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)


<br/>



### Code Snippets
1. #### Maven Dependencies
    Need to add below dependencies to enable Mongo related config in **pom.xml**. Lombok's dependency is to get rid of boiler-plate code.   
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```
   
2. #### Properties file
    Reading Mongo DB related properties from **application.application** file and configuring Mongo connection factory for mongoDB.  

    **src/main/resources/application.yml**
     ```
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=spring_boot_mongo_app
    spring.jackson.default-property-inclusion=NON_NULL
    #logging.level.ROOT=DEBUG  
     ```
   
3. #### Model class
    Below are the model classes which we will store in MongoDB and perform CRUD operations.  
    **com.spring.mongo.demo.model.SuperHero.java**  
    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document(collection = "super_hero")
    public class SuperHero implements Serializable {
    
        @Id
        private String id;
    
        private String name;
        private String superName;
        private String profession;
        private int age;
        private boolean canFly;
    
        // Constructor, Getter and Setter
    }
    ```
    **com.spring.mongo.demo.model.Employee.java**  
    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Employee implements Serializable {
   
        @Id
        private String id;
       
        private int empId;
        private String firstName;
        private String lastName;
        private float salary;
        
        // Constructor, Getter and Setter
    }
   ```