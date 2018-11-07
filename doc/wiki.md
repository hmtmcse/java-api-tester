#### Assertion
Assertion basically use for check the response specially, if we want to use assertion then we have to ensure that
our API response must be JSON, currently there is no implementation for other response, the assertion technique has some
lacking that is, we not able to us the **and** and **or** condition in same response, by default all condition is consider as
or, if we add multiple condition then it will match by **or**, once we use any **and** condition then any other condition will not
work.

**OR Example**
``` 
  "response": {
    "contextType": "application/json",
    "equal": {
      "isActive": true
    },
    "notEqual": {
      "isDeleted": true
    },
    "httpCode": 200,
    "content": {
      "isDeleted": true,
      "isActive": true
    }
  }
``` 


<br>

**AND Example**
``` 
  "response": {
    "contextType": "application/json",
    "and":{
      "equal": {
        "isActive": true
      },
      "notEqual": {
        "isDeleted": true
      },
    },
    "httpCode": 200,
    "content": {
      "isDeleted": true,
      "isActive": true
    }
  }
``` 

**Note:** If we added any condition outside of and then those will not consider as condition



**All Assertion**

* equal
* notEqual
* lessThan
* lessThanEqual
* greaterThan
* and