### what are filters?

1. Java has mechanism to handle request and response from server which is know as Servlet API

2. When it comes to spring boot application there is something called as *DispatcherServlet* which is basically abstraction for ServletApi so internally it is servlet api in itself but it is abstracted so we dont have any visibilty of it.

3. After coming to dispatcher servlet it goes to interceptor and after that your application's api.

4. Even before the request is going to ur spring core it will first go to filter.

### Filter chain

1. supposer there are 3 filters u created LoggingFilter, AuthenticationFilter and Filter3 

2. so after the execution of first filter it will go to next filter and till all filters are executed in chaining it will not go to spring core.

### Implementation of filter

1. create a class and implement `Filter` interface. 

2. after overriding `doFilter()` method u may either proceed to next filter in filter chain or u have to call DispatcherServlet.

3. u can do it by using filterchain object `chain.doFilter(req, res)` and it may go to next filter or it will go to DispatcherServlet.