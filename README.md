# CRM

Customer relationship management system.

Technologies used in this project:
  - Spring framework (Spring Boot)
  - MySQL database
  - Spring MVC
  - Spring Data
  - Spring Security

Functionalities:
1. Create and manage customers
  - form used for creating/editing customers
  - possibility to create customer based on the other
2. Searching for customers
  - custom searches based on various parameters
3. Creating roles and access rights
  - structure of rights: user, manager, owner, admin
  - based on access rights chosen elements of application are shown
  - special admin's section to edit access rights
  - used spring security to achieve this
4. Contracts generation
  - create contracts
5. Exporting data
  - export files types: pdf, csv, xls
  - possibility to add custom name to exported file
6. API
  - ability to get customers list through eg postman or curl
