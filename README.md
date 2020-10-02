# microservices
Capstone microservices project on Spring boot

## Startup

To run the application, simply start 3 Spring boot modules(product, catalong, inventory) 

Product module is used both as REST API and a Eureka Server, so it needs to be started before the other two modules.

To attach zipkin, start the docker-compose.
```
❯ docker-compose up
```

## API

#### Product endpoint

Retrieve available products data by unique id
```
Get http://localhost:8761/api/product/{id}
```
Retrieve available products data by skuNumber (multiple products are returned)
```
Get http://localhost:8761/api/product?skuNumber={skuNumber}
```
