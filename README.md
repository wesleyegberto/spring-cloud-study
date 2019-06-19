# Spring Cloud + Netflix Stack

## Projects
* Karyon
* Spring Cloud Gateway
* Eureka Server and Clients
* Hystrix and Dashboard

## Complete Scenario

#### Infra Components
* RabbitMQ
  * Will store the events from API's hystrix.
* Eureka Server
  * Registry server to our service register themselves;
  * Will be used by Zuul to proxy ingoing request.
* Zuul Server
  * Our API Gateway;
  * Query the Eureka server to get the registered services and create proxies for each one.
* Turbine Streamer
  * The Turbine server to aggregate the metrics from state of hystrix commands.
* Monitor Dashboard
  * The dashboard to visualize metrics.

#### Business Components
* Stock Service
  * Our Stock API.
* Store Service
  * Our Store API that consumes Stock API.



## Usage

### RabbitMQ
* Access: `http://localhost:15672/#/queues`
  * User: guest
  * Password: guest

### Turbine Stream
* Access: `http://localhost:8989/turbine.stream`

### Dashboard Monitor
* Access: `http://localhost:7979/hystrix`
  * Usar URL do Turbine Stream que é exibida no dashboard do Eureka

### Eureka
* Access: `http://localhost:8761/`
* Request: GET `http://localhost:8761/eureka/apps`

### Zuul
* Request some api: `http://localhost:8080/<service_name>/<path>`
* Access page with links: `http://localhost:8080/`
* Hystrix stream: GET `http://localhost:8080/actuator/hystrix.stream`


### Stock Service:
* Direct request: GET `http://localhost:8090/stocks/products/123/available`
* Gateway request: GET `http://localhost:8080/stock-service/stocks/products/123/available`

### Store Service:
* Direct request: GET `http://localhost:8095/store/order/item/123`
* Gateway request: GET `http://localhost:9090/store-service/store/order/item/123`
* Hystrix stream: GET `http://localhost:8095/actuator/hystrix.stream`



## Generating Métrics

* `ab -n 1000 -c 20 http://localhost:8080/stock-service/stocks/products/123/available`
* `ab -n 1000 -c 20 http://localhost:8080/store-service/store/order/item/123`
