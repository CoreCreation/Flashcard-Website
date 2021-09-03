# Flashcard Website
This is an ongoing project. It is a full stack flashcard system using Spring Boot and React. I plan on learning and using both as I go along. It also will, hopefully, be a useful project. I used flashcard services with students while I was a teacher and I was not always happy with the offerings. My goal is to make a system simple enough for young students to use, but powerful enough for teachers to create the content they want. 

# Currently Completed:
* Connection of server to database
* Creation of endpoints for creating, updating, and deleting flashcards

## Current API:
### GET
```
/api/v1/flashcard
```
Needs more work, get one card for example

### POST
```
/api/v1/flashcard
```
Needs the information in the body:
```
{"front":"Hello","back":"你好"}
```
Content-Type: application/json

### DELETE
```
/api/v1/?id=
```

### PUT
```
/api/v1/flashcard?id=
front=
&back=
```
Front and back are optional