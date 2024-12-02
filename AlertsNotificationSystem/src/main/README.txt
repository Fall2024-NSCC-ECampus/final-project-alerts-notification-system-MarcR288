                                    Alerts Notification System -  README

ChildAlertController
Overview
The ChildAlertController is part of the Alerts Notification System and is responsible for handling
HTTP requests related to retrieving information about children living at a specified address.
It returns a list of children under 18 years of age, along with other people residing at the same address.
The response is presented as a list of ChildAlertDTO objects.

This is a Spring Boot-based REST controller which interacts with the PersonRepository to fetch data from a
database of persons.

Endpoints
/childAlert
Method: GET

Request Parameter:

address (String) - The address to search for persons residing at that location.
Description:

This endpoint retrieves all children (persons under the age of 18) living at the given address.
The response will also contain a list of other people living at the same address, excluding the child being processed.
Response:

A JSON array of ChildAlertDTO objects, each containing:
firstName: The child's first name.
lastName: The child's last name.
age: The child's age.
otherPersons: A list of other persons living at the same address, represented as strings with their full names.
If no children are found at the given address, the response will be an empty array.

                            Alerts Notification System - CommunityEmailController
Overview
The CommunityEmailController is part of the Alerts Notification System and handles HTTP requests related to retrieving
the email addresses of people residing in a specific city. The controller interacts with the PersonService to fetch and
filter email addresses of individuals based on their city of residence.

This is a Spring Boot-based REST controller that provides an endpoint for fetching a list of email addresses from the
database.

Endpoints
/communityEmail
Method: GET

Request Parameter:

city (String) - The name of the city to filter people by.
Description:

This endpoint retrieves the email addresses of all persons living in the specified city.
It returns a list of email addresses associated with people from the given city.
Response:

If the city has associated people with emails, a JSON array of email addresses is returned with a 200 OK status.
If no people are found in the specified city, the response will return an empty response body with a 204 No Content
status.

                                Alerts Notification System - PersonInfoController
Overview
The PersonInfoController is part of the Alerts Notification System and is responsible for handling HTTP requests that
fetch detailed information about individuals. This controller retrieves person details based on their first and last
names and returns the relevant information in the form of PersonInfoDTO objects.

The controller interacts with the PersonRepository to query the database for persons matching the provided first and
last name, and processes additional details like medications, dosages, allergies, and age.

Endpoints
/personInfo
Method: GET

Request Parameters:

firstName (String) - The first name of the person to search for.
lastName (String) - The last name of the person to search for.
Description:

This endpoint retrieves detailed information about individuals whose first and last names match the provided parameters.
For each person, details such as their email, address, medications, dosages, age, and allergies are included in the response.
Response:

A JSON array of PersonInfoDTO objects, each containing:
firstName: The person's first name.
lastName: The person's last name.
email: The person's email address.
address: The address line of the person's residence (empty if no address is available).
medications: A string representing the person's medications along with dosages, or "No medications found"
if no medications are listed.
age: The person's age.
allergies: A list of the person's allergies.
If no persons match the provided first and last names, the response will be an empty array.

                            Alerts Notification System - PhoneAlertController
Overview
The PhoneAlertController is part of the Alerts Notification System and is responsible for handling HTTP requests
that retrieve phone numbers of individuals associated with a specific fire station. The controller interacts with
the PersonRepository to query the database for people linked to a given fire station number and returns their phone
numbers.

This is a Spring Boot-based REST controller designed to assist in gathering phone contact details for persons served
by a specific fire station.

Endpoints
/phoneAlert
Method: GET

Request Parameter:

stationNumber (int) - The fire station number to filter people by.
Description:

This endpoint retrieves the phone numbers of all persons associated with a specified fire station number.
It returns a list of phone numbers belonging to people linked to that fire station.
Response:

A JSON array of phone numbers as strings.
If no people are found for the given fire station number, the response will return an empty array.