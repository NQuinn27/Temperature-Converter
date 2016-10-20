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

'''
curl -H "Accept:text/html" -X GET http://localhost:8080/convert/cel2far/32
'''  
Returns HTML response

### Convert Fahrenheit to Celcius  

'''
curl -H "Accept:text/html" -X GET http://localhost:8080/convert/far2cel/32
'''
Returns HTML response  
