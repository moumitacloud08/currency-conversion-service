# currency-conversion-service

GIT commands after creating repo in git
echo "# currency-conversion-service" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/moumitacloud08/currency-conversion-service.git
git push -u origin main


----------------

Feign makes it easy to call other microservices
It provides integration with Ribbon which is client site load balancing framework

In older version Ribbon balancer was used, in recent version spring-cloud-loadbalancer is used
In older version Zuul API Gateway was used, in recent version spring-cloud-gateway is used

--------
currency-exchange API URL:-
http://localhost:8000/currency-exchange/from/EUR/to/INR

currency-conversion API URL:-
http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000

currency-conversion Feign LoadBalancing URI:- 
http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000

------------------EUREKA---------------------------
http://localhost:8761/

--------------------APIGATEWAY------------------------

APIGateway URIs:-

- http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/EUR/to/INR

- http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-converter/from/USD/to/INR/quantity/1000

- http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-converter-feign/from/USD/to/INR/quantity/1000

----APIGateway URIs lowercase-----

- http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR

- http://localhost:8765/currency-conversion-service/currency-converter/from/USD/to/INR/quantity/1000

- http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/1000

------APIGateway URIs CUSTOM ROUTE--------

http://localhost:8765/currency-exchange/from/EUR/to/INR
http://localhost:8765/currency-converter/from/USD/to/INR/quantity/1000
http://localhost:8765/currency-converter-feign/from/USD/to/INR/quantity/1000
http://localhost:8765/currency-converter-new/from/USD/to/INR/quantity/1000

----------Zipkin--------------
http://localhost:9411/zipkin

---------------Build Docker image with maven build------------
spring-boot:build-image -DskipTests