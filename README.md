# spring-quickstart-jdbc

# DB CONNECTION
* Define connection properties in a file
* Use those properties to create a bean called dataSource
* Create Spring Provided JdbcTemplate using the dataSource
* JdbcTemplate helps to execute queries against the database.

# QUICK START APP
* spring-core, spring-context, spring-jdbc (5.3.2)
* mariadb-driver depenendency

# Component
* Configuration(config from properties file), Repoistory(database), Service(logic), Controller(web)

# DEPENENCY INJECTION
=====================================================
```java
@Component
class Person
{

 @Autowired
 private Address address; // complex type
 
 public Address getAddress()
 {
   return this.address;
 }
 
}

@Component
class Address
{

}

main()
{
  Person p = new Person();
  p.getAddress(); // null
  
  AnnotationcConfigApplicationContext context = 
  
  new AnnotationConfigApplicationAContext("some valid package");
  
  
  p = context.getBean(Person.class);
  p.getAddress(); // null? 
  
}
```
