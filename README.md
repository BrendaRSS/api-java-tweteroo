# Team Drawer
This repository contains an api of a tweeting application using Java Spring. To persist the data I used the postgreSQL database.

## Installation

1. Clone the repository:

```bash
git clone git@github.com:BrendaRSS/teamDrawerApi.git
```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown

POST /users - Register a new user.
Body: {"avatar": "URL", "username" : "name"}

POST /tweets - Posts a tweet from a user
Body: {"text": "write your text here", "authorId" : id of an existing user}

GET /tweets - Retrieve a list of tweets
GET /tweets/user/{authotId} - Retrieve a lista of a user's tweets
DELETE /tweets/{id} - Delete data.
```
