### what are interceptors

1. as soon as request comes to dispatcherservlet it will be first redirected to this interceptor and the controller
2. it sits between dispatcher servlet and application controller

3. create class and implement the `HandlerInterceptor`.

4. after coming to dispatcher servlet first it will transfer the request to `preHandle()` function after that it is sent to controller.

5. after controller sends back response it will first come to `postHandle()` of interceptor so u can modify ur response here also. and after that ur request will go to client.

6. After that `AfterCompletion` will be triggered and cleanup every resource if u have.

7. After creation of ur interceptor u will have to configure ur interceptor in webconfig class by implementing `WebMvcConfigurer` this will actually help to register ur interceptor.

8. register interceptor by implementing method add interceptor mention path pattern for which url interceptor should be invoked and exclude for which u dont want to

9. difference between interceptor and filters

| interceptors | filters |
|-|-|
| this is part of ur spring application | this is part of ur servlet api |
| it will be part of spring | it will be outside of ur spring mvc application |
| this will be work after reaching spring application | this will modify ur request even before reaching ur spring application |
| this will have access to all beans inside spring | this wont have that |
