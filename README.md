# RestService
Simple rest service using h2 database. Curl command, which creates new item:
curl -X POST -i -H "Content-Type: application/json" -d '{"name": "Wartość", "createdAt": "2019-09-06"}' http://localhost:8080/item;
