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
1. create a class `SecurityConfig` and annotate with `@EnableWebSecurity` to tell spring enable the web security support. though u have added dependancy of spring security still u haven't configured that's why u use this annotation.

2. this annotation is used with `@Configuration` annotation.

