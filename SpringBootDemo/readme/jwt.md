### what is jwt?

1. jwt json web token is a way to securely transmit information between parties as a json object.

2. jwt is a compact, url safe token that can carry information between parties. 

3. jwt has 3 parts header, payload and signature.

### jwt header
1. header consists of 2 parts the type of token(jwt) and the signing algorithm being used, such as HMAC SHA256 or RSA.

### jwt payload
1. the payload contains claims. claims are statements about an entity(typically, the user ) and additional metadata.

### jwt signature
1. the signature is used to verify that the sender of the jwt is who it says it is and to ensure that the message wasn't changed along the way.

2. to create signature part u have to take the encoded header, encoded payload, a secret, the algorithm specified in the header and sign that.

### import dependencies

1. you will need 3 dependencies jjwt-api, jjwt-impl, jjwt-jackson.

```
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.12.3</version>
		</dependency>
		
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.12.3</version>
			<scope>runtime</scope>
		</dependency>
		
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.12.3</version>
			<scope>runtime</scope>
		</dependency>
```
### implementing jwt

1. create `JwtUtil` class in utils package.
2. create class `PublicController` inside that create `signup` and `login` method.
3. now inside this interface `AuthenticationManager` declare and autowire this.

4. with the help of AuthenticationManager u will authenticate the user 