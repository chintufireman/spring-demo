### for orders
1. create `Order` and `OrderEvent` class
2. OrderEvent is the class we are going to transfer data between producer and consumer
3. Order service will create order event which will be published on kafka.
4. Now you have to configure order service for kafka producer so that it can publish events