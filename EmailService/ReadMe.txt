use valid username and password in properties file.

request URI:
POST : localhost:9090/email/
request json :
{
    "emails": [
        "meetmunjal@gmail.com"
    ],
    "subject": "sub",
    "text": "text to send"
}




Readings :
https://www.baeldung.com/spring-response-status
https://www.baeldung.com/exception-handling-for-rest-with-spring
