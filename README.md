# Flight Service

This is a simple flight reservation management project.

## Description

You can create and manage passengers, airline companies, airports, flights, flight routes and tickets.

## Getting Started
* You can use this Postman Collection in the repository:

```
Flight Service.postman_collection.json
```

### Java Version
* 1.8

### Dependencies

* Spring Boot
* Hibernate
* H2Database
* Lombok
* Model Mapper


### WARNING

* Before build the project, you have to install Lombok Project and Annotations of Lombok Project.


### Git Clone
```
git clone https://github.com/selimdemirci/FlightService.git
```

## Example Work Flow
* Creating a Passenger.
* Creating an Airline Company
* Creating an Airport for start point(from)
* Creating an Airport for destination
* Creating a Flight Route
* Creating a Flight
* Make Ticket Reservations

## ENUM Types

##### Plane Types
* With this ENUM you can easily manage plane passenger capacity.

###### CANADAIR
* It has 6 passanger capacity by default.

###### AIRBUS
* It has 12 passanger capacity by default.

###### BOEING
* It has 24 passanger capacity by default.


##### Ticket Status
* With this ENUM you can distinguish is ticket cancelled or still proceed.

###### PROCEED
* Ticket is still valid.

###### CANCELLED
* Ticket is cancelled.


## Rest Services

### Passenger

##### Create
* It creates a passenger with billing account.

```
/passenger/create
```

##### Find
* It finds a passenger with Passenger ID.
* If passenger does not exist, throws DataNotFoundException.

```
/passenger/find?id=1
```

##### Get All
* It finds all passengers.

```
/passenger/all
```


### Airline Company

##### Create
* It creates an airline company.
* It does not allow to create another company with same company name, throws AirlineCompanyException.

```
/company/create
```

##### Find
* It finds an airline company with company name.
* If airline company does not exist, throws DataNotFoundException.

```
/company/find?company=THY
```

##### Get All
* It finds all airline companies.

```
/company/all
```


### Airport

##### Create
* It creates an airport company.
* It does not allow to create another company with same company name, throws AirportException.

```
/airport/create
```

##### Find
* It finds an airport with airport name.
* If airport does not exist, throws DataNotFoundException.

```
/airport/find?airport=Esenboğa
```

##### Get All
* It finds all airports.

```
/airport/all
```


### Flight Route

##### Create
* It creates a flight route.
* It does not allow to create another company with same company name, throws FlightRouteException.

```
/flightRoute/create
```

##### Find
* It finds a flight route with flight route id.
* If flight route does not exist, throws DataNotFoundException.

```
/flightRoute/find?id=1
```

##### Get All
* It finds all flight routes.

```
/flightRoute/all
```


### Flight

##### Create
* It creates a flight.

```
/flight/create
```

##### Find
* It finds a flight with flight id.
* If flight does not exist, throws DataNotFoundException.

```
/flight/find?id=1
```

##### Get All
* It finds all flights.

```
/flight/all
```

##### Get All by Company Name
* It finds all flights  by company name.

```
/flight/company?companyName=THY
```

##### Get All by Airport Name
* It finds all flights by airport name.

```
/flight/airport?airportName=Esenboğa
```


### Ticket

##### Reservation
* It makes a reservation and creates a ticket. 
* While making reservation, also decreases passenger budget.
* If all seats booked, throws TicketException.
* If budget is insufficient, throws TicketException.

```
/ticket/reservation
```

##### Reservation Cancellation
* It cancels the reservation with making Ticket Status = CANCELLED with Ticket ID.
* While canceling reservation, also increases passenger budget.
* If reservation already cancelled, throws TicketException.
* If ticket does not exist, throws DataNotFoundException.

```
/ticket/cancelReservation?id=1
```

##### Delete
* If Ticket Status = CANCELLED, it deletes ticket with Ticket ID else throws TicketException.
* If ticket does not exist, throws DataNotFoundException.

```
/ticket/deleteReservation?id=1
```

##### Find
* It returns ticket informations.
* If ticket does not exist, throws DataNotFoundException.

```
/ticket/find?id=1
```