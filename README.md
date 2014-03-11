DomainRegistration
==================
Project Description:
 
To Design a console application that allows the consumer to load a list of the domains they want to register and for how many years, displaying the total cost of their domain registration request as the result. There are two categories of domains: Domains based on zones and the other type is Premium domains. Users can request domains available and the respective cost of domain per year will be displayed. User then enters the number of years he needs to host the domain and the domain will be registered based on availability.

Design:

The domain parameters are kept in a bean called DomainBean.  The domain details are stored two separate  simple text files each for the two different types of domains. There is a Formatter class which displays the output in a formatted way. A reader class which reads the domain details from the files based the selected domains type. The read domain details are saved in a list. There is a calculator class which iterates through the domain list and calculates the cost of each domain entered by the user and sends the total cost back to the caller.

A class diagram representing the coordination among different classes will be updated soon.
