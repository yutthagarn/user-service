# user-service
## Run Service
mvn spring-boot:run

## Register
URL: http://localhost:8080/api/user/register

Http Method: POST

Header: Content-Type:application/json

Body: {
	"username":"cyberpunkz",
	"password":"abc123",
	"firstName":"Yutthagarn",
	"lastName":"Intajug",
	"mobileNo":"0812345678",
	"salary":"14000"
}

## Login
URL: http://localhost:8080/login

Http Method: POST

Header: Content-Type:application/json

Body: {
	"username":"cyberpunkz",
	"password":"abc123"
}

## Get All User
URL: http://localhost:8080/api/user

Http Method: GET

Header: Authorization: Bearer {Token}
