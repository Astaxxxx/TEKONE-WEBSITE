# Team-26

The current website is not hosted due to issues with vitualmin's capability to host java applications
This website is a java application whch encoparates the Thymeleaf framework and runs on jdk 17 can run on newer versions
To run the web application you must first pull the repository from the repository or download the zip file
then open the database folder, in that folder will be 11 csv files and 11 sql.text files which you can import on any database mangment system you are using after creating a ddatabase called Tekone
If using SQLWorkbench the connection is already done for you in the application.properties file you will just need to simply indert your username and password and have the dtabases impored to then acess the website.
If using anyother database mangement system such as phpmyadmin you will ahve to configure the applications.properties file yourself in accordance to the imported database to have a stable connection.
Then navigate your self to the tekone folder -> src -> main -> java -> com -> tekone -> tekone -> controller this brings up java files which if using vs code you can simply run as a spring boot project by clicking the play button in the top right
Now that you have ran as a spring boot project you can simply type localhost:8080 in the browser to ascess the website 

Admin account :

USERNAME- admin  
PASSWORD- admin

User account :
Can be made or can use a temp account

USERNAME- hello 
PASSWORD- hello
Demonstration of making a product and it going into the database


https://user-images.githubusercontent.com/94316672/229475054-3745b5e7-2474-48ba-8524-0043cd76dddf.mp4



# TekoneJavaApplication Inventory
README File for Inventory System

Overview:
The inventory system is a Java-based application designed to manage the inventory and orders for an e-commerce website. The system offers various features, including chart-based reports, product management, order management, customer management, and admin management.

System Requirements:
To run this application, the user must have the following:

Java Development Kit (JDK) 11 or higher
MySQL Server 5.7 or higher
Apache Tomcat 8.5 or higher
Internet Browser
Installation:
To install and run the application, follow these steps:

Clone the repository to your local machine using git clone.
Install the JDK, MySQL Server, and Apache Tomcat on your system.
Import the database schema provided in the "database" folder using MySQL Workbench or any other MySQL management tool.
Configure the database connection in the "db.properties" file located in the "src" folder.
Build the application using Apache Maven by executing the command "mvn clean install".
Deploy the application to the Tomcat server.
Open a web browser and navigate to "http://localhost:{tomcat_port}/inventory-system".
Usage:
After installation, users can access the inventory system by logging in using their credentials. The system offers various functionalities, including:

Product Management: Users can add, modify, or delete products, including product name, description, price, and quantity.
Order Management: Users can view and modify order details, including order number, customer information, and product information.
Customer Management: Users can add, modify, or delete customer details, including name, email, phone, and address.
Admin Management: Users can add, modify, or delete admin credentials.
Reports: Users can view chart-based reports that display the quantity of stock available for each product, the most ordered products, and the customers' orders.
Contributing:
We welcome contributions from the community. Please fork the repository and create a pull request for any feature enhancements, bug fixes, or documentation improvements.



