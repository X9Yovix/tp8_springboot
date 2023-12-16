<h3 align="center">Practical Exercise</h3>

## About The Project
Developing APIs with Spring Boot based on a Class Diagram.

## Tools and Technologies Used
• Java 17 • Maven • Spring Boot 3 • Spring Web • Spring Data JPA (Hibernate) • Lombok • Swagger • Validation • Tomcat • MySQL • Postman •

## Preview
- In this practical exercise, we designed three CRUD operations for Property, Owner and Rental Contract. Each operation was tested using Postman. Below are the screenshots for each CRUD operation:

### Property:

- Create Property
  ![Create Property](images/crud_property/1.png)

- Update Property
  ![Update Property](images/crud_property/2.png)

- Find Property by ID
  ![Find Property by ID](images/crud_property/3.png)

- Fetch All Properties
  ![Fetch All Properties](images/crud_property/4.png)

- Delete Property
  ![Delete Property](images/crud_property/5.png)

### Owner:

- Create Owner
  ![Create Owner](images/crud_owner/1.png)

- Update Owner
  ![Update Owner](images/crud_owner/2.png)

- Find Owner by ID
  ![Find Owner by ID](images/crud_owner/3.png)

- Fetch All Owners
  ![Fetch All Owners](images/crud_owner/4.png)

- Delete Owner
  ![Delete Owner](images/crud_owner/5.png)

### Rental Contract:

- Create Rental Contract
  ![Create Owner](images/crud_rental_contract/1.png)

- Update Rental Contract
  ![Update Rental Contract](images/crud_rental_contract/2.png)

- Find Rental Contract by ID
  ![Find Rental Contract by ID](images/crud_rental_contract/3.png)

- Fetch All Rental Contracts
  ![Fetch All Rental Contracts](images/crud_rental_contract/4.png)

- Delete Rental Contract
  ![Delete Rental Contract](images/crud_rental_contract/5.png)

### Documentation:
- We used Swagger for API documentation to facilitate navigation, exploration, and testing of the created APIs.
 ![Swagger UI](images/documentation.png)

### Validation:
- Finally, we implemented validation for each request, and here is an example:
![Validation](images/validation.png)

### Note:
- In the API response for fetching a Rental Contract, Rental Contracts, or during the creation of a Rental Contract, the complete attributes of the associated `Property` and `Owner` are included within the object. This behavior is typically caused by the use of eager fetching in the data model.
- To avoid this behavior, we should consider using the fetching strategy `LAZY`, additionally, utilize a DTO (Data Transfer Object) and a custom serializer to control the specific elements to be returned in the response.
