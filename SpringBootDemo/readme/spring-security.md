### Authentication and Authorization 

1. authentication means who should be able to access the resources and not. example if there is api then is the user should be allowed to access that api or not.

2. authorization means example if u are authenticated to access mongo db server and if yes then do u have read and write access this means are u authorized to read and write on that resource.

### dependancy
1. add the spring security starter dependancy.

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
2. after this spring boots auto - configuration will automatically apply spring security.
 
3. by default spring security used http basic authentication

4. basic authentication means clients sends an authorization header `Authorization:Basic <encoded-string>
the server decodes the string, extracts the username and password and verifies them. if they're correct, access is granted. otherwise an unauthorized response is sent.

5. encoding credentials are combined into a string like username:password. which is then converted to base64.


### customizing authentication

1. First we will create `SecurityConfig.java` class and annotate it with `@Configuration` so that we can declare we few beans which want to use for configuring our spring security.

2. inside that create 2 beans `SecurityFilterChain` and `AuthenticationManager`.

3. when u add spring security dependency in ur project the filer `SecurityFilterChain` gets added as well. 

### Deligating filter proxy

1. As u know servlet api has separate lifecycle from ur spring application and spring beans has its own life cycle.

2. The filters will not have access of beans as the above two are separate things servlet api and spring context.

3. spring provides a filter implementation named `DelegatingFilterProxy` that allows bridging between the servlet container's lifecycle and Spring's ApplicationContext.

4. that means it will connect these two.

5. it will get added to servlet container but delegate all work to a spring bean that implements filter.

### Filter chain proxy

1. this is something which will be added inside ur delegating filter proxy which will have your `SecurityFilterChain` which will have multiple `SecurityFilter`

2. all the above concepts were only to understand what is SecurityFilterChain which we are using directly.

3. we should know what is DelegatingFilterProxy.

### Authentication provider

1. Lets say we have multiple ways to do authentication like spring generated username/password, in DATABASE/MEMORY, OAuth2, LDAP, JWT.

2. Now question is should spring all these ways of doing authentication inside ur filter? it shouldn't because it will be very tedious process.

3. in order to handle each of this type of authentication spring provides its own AuthenticationProvider. 

4. DAOAuthenticationProvider, OAuth2LoginAuthenticationProvider, LDAPAuthenticationProvider.

5. so spring will segregate all this authentication provider from ur filter.

6. if request comes to filter it will delegate the request to authentication provider which will authenticate request for u.



### Authentication Manager

1. How spring boot will know which authentication provider should we use?

2. to solve this problem we have something called as `AuthenticationManager`.

3. this bridges the gap between AuthenticationProvider and filters.

4. this is abstraction and its implementation is called as ProviderManager which is impl class.

5. `ProviderManager` will iterate through all of this AuthenticationProvider and check which one supports the incoming request.

### UserDetailsService

1. By default spring provides u some kind of password and username to login.

2. but u may have different username and password which are stored somewhere else so spring will not automatically provide that.

3. AuthenticationProvider will connect to UserDetailsService this service will have interfaces like InMemoryUserDetailsManager, JDBCUserDetailsManager which will have full connection to ur database. 

4. this service will give details back to authentication provider

### PasswordEncoder

1. you do not put password directly into ur database

2. you basically encode the password and save it.

3. and when authentication provider gets the encrypted password from db it needs some way to figure out to convert that encoded value to normal value.

4. so that's why we use PasswordEncoder which will encode and decode ur password internally withing authentication provider.

### SecurityContext

1. once the job of authentication is done by authentication provider it will return the object of authentication to Authentication manager and from there it will be returned to ur filter.

2. now this object needs to be stored somewhere so that other parts of ur spring application can access it. which can be accessed by all beans.

3. which we do it in SecurityContext which will store authentication object and principal object

### SecurityContextHolder

1. In order to access Securtiy context in ur spring boot application it has provided an abstraction which is security context holder.

2. it has methods called as `getContext()` which will give authentication or principal object


### SecurityContextHolderFilter

1. you will notice that once u authenticate any request and reload or hit the same api again it will not ask again ur user details.

2. because SecurityContextHolderFilter will store ur authentication object here or remember that this user is authenticated no need to do it again as it is inside the same session.

### ExceptionTranslationFilter

1. lets say suppose something goes wrong security context holder filter is not able to store ur authentication per session or u are not able to get userdetails from db.

2. here we use `ExceptionTranslationFilter` whose job is to catch all exceptions and errors.