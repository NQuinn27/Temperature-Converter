# NCI BSc(Hons) in Computing - Year 4 - Web Services & API Development

## Assignment 4

## Contributors
  - Niall Quinn
  - Ciaran Byrne
  - Eoin Sutton
  - John O'Shea

## Contributing
Work on a branch. When item is completed submit a pull request to merge branch into master. Master is a protected branch to prevent force pushing to master.  

## Running the project  
Run the project to start the server.  

### Convert Celcius to Fahrenheit  

```bash
curl -H "Accept:text/html" -X GET http://localhost:8080/api/cel2far/32
```  
Returns HTML response  

```bash
curl -H "Accept:application/json" -X GET http://localhost:8080/api/cel2far/32
``` 
Returns JSON response  

### Convert Fahrenheit to Celcius  

```bash
curl -H "Accept:text/html" -X GET http://localhost:8080/api/far2cel/32
```  
Returns HTML response  

```bash
curl -H "Accept:application/json" -X GET http://localhost:8080/api/far2cel/32
``` 
Returns JSON response 

### Add User to the System  
To add a user to the system, send a POST request as follows, where the params 'firstName' and 'lastName' are those of the new user.  
```bash
curl -X POST http://localhost:8080/api/user/add\?firstName\=Joe\&lastName\=Bloggs
```   

To view the list of users in storage, use the following request:  
```bash
curl -X GET http://localhost:8080/api/user/list
```  

### Return a random string of length  
To recieve a random string of chosen length, send the following request, where the final pathParam is the required length, and is a positive integer
```bash
curl -X GET http://localhost:8080/api/ranString?length\=10
``` 
