# Concurrency Limit - Spring MVC


* Build and pack
``mvn clean package && docker build -t wesleyegberto/netflix-spring-mvc .``

* Run
``docker run --rm -it -p 8080:8080 -m 500m --cpus="1.0" wesleyegberto/netflix-spring-mvc``

* Stress the limit:
``ab -n 1000000 -c 500 localhost:8080/api/simple/hello``


* Path to Metric:
``http://localhost:8080/actuator/metrics/requests.counter``


* Threads live
``http://localhost:8080/actuator/metrics/jvm.threads.live``