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
