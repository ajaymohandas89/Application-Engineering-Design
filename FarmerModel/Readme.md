PROJECT TITLE: UNITED STATES FARMER'S MARKET

PROJECT DESCRIPTION:

The project is about impmenting a a farmer's market model using push/pull model of supply chain. This project will help you get a basic understanding of how to implement singleton design framework in a project, array list ,abstraction and it's application.
The project also helps in understanding the nitty gritty of how to design an application with respect to a ecosystem. An ecosystem includes list of networks, each network has list of organisations and each organisation has their respective users.
As and when a customer demands for a product or farmer demands for raw materials that request is met with proper response via proper channel.

PRE-REQUISITE:

1) Java 6 or higher version
2) NetBeans IDE 8.0.2

ADD LIBRARIES TO YOUR PROJECT:

1) The necessary libraries to run the project is present in \dist\lib.
2) Our project uses three main libraries gson-2.6.2, db4o-8.0.184.15484-all-java5, jfreechart-1.0.19
2) To add more libraries right click on Libraries --> Add Library or Add Jar files

HOW TO USE OUR PROJECT:

1) After importing our project make sure the libraries are added to your project. If not please go through section "ADD LIBRARIES TO YOUR PROJECT".
2) Clean and build the project.
3) Run the project
4) First login credentials are as follows:
	a) Useraname: sysadmin
	b) Password: sysadmin
4) Create Network as Boston, Miami and add to the list.
5) Create Employee for each network and they will the admin for accessing each network.
6) Manager User will create credentials for the admin with respect to network.
7) Login using the admin credentials and create organisation by using the combo box in the frame.
8) Create credentials for each organisation and you can login using that credentials.
9) To use the weather api go to FarmerWorkAreaJPanel and click on "Weather Updates". Please select a city and enter two characters of country (example: US).
10) To access the JFreeChart, go to StaffWorkAreaJPanel and click on "Bar Chart" or "Line Chart" to view customer demands.

KNOWS ISSUES:
1) Once the porject is loaded and network or organisation are added then you won't be able to create a new network. It will lead to Null Pointer Exception due to singeton design patter.
2) Delete the db40 file generated inside the prject folder and the start again.

AUTHORS:
1) Gurjot Kaur
2) Harsh Shah
3) Ajay Mohandas

REFERENCES:
1) https://openweatherapi.org/api
2) http://www.jfree.org/jfreechart/download.html
3) https://www.mass.gov/guides/how-to-run-a-farmers-market#what-is-a-farmers-market-
4) https://www.agweb.com/mobile/article/farmers-reveal-their-10-favorite-apps/
5) https://medium.com/homeland-security/americas-fragile-food-supply-chain-e387e86a355a