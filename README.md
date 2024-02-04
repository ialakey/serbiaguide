# [Mobile App](https://github.com/ialakey/srbguide)

# [Frontend Admin Panel](https://github.com/ialakey/serbiaguide-front-admin)

# API Requests Description

# Location Entity
## 1) Fetch Locations
```bash
curl http://localhost:8080/locations
```
This command retrieves a list of locations from the specified endpoint.

## 2) Create Location
```bash
curl -X POST -H "Content-Type: application/json" -d '{"property1":"value1","property2":"value2"}' http://localhost:8080/locations
```
Creates a new location by sending a POST request with JSON data containing the properties and values.

## 3) Update Location
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"property1":"newvalue1","property2":"newvalue2"}' http://localhost:8080/locations/{selectedLocation.id}
```
Updates an existing location by sending a PUT request with JSON data containing the updated properties and values. Replace {selectedLocation.id} with the actual ID of the location.

## 4) Delete Location
```bash
curl -X DELETE http://localhost:8080/locations/{selectedLocation.id}
```
Deletes a location by sending a DELETE request to the specified endpoint. Replace {selectedLocation.id} with the actual ID of the location.

# TgChat Entity

## 1) Fetch TgChats
```bash
curl http://localhost:8080/tgchats
```
This command retrieves a list of TgChats from the specified endpoint.

## 2) Create TgChat
```bash
curl -X POST -H "Content-Type: application/json" -d '{"property1":"value1","property2":"value2"}' http://localhost:8080/tgchats
```
Creates a new TgChat by sending a POST request with JSON data containing the properties and values.

## 3) Update TgChat
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"property1":"newvalue1","property2":"newvalue2"}' http://localhost:8080/tgchats/{id}
```
Updates an existing TgChat by sending a PUT request with JSON data containing the updated properties and values. Replace {id} with the actual ID of the TgChat.

## 4) Delete TgChat
```bash
curl -X DELETE http://localhost:8080/tgchats/{id}
```
Deletes a TgChat by sending a DELETE request to the specified endpoint. Replace {id} with the actual ID of the TgChat.

# GuideItem Entity

## 1) Fetch GuideItems
```bash
curl http://localhost:8080/guideitems
```
This command retrieves a list of GuideItems from the specified endpoint.

## 2) Fetch GuideItem by ID
```bash
curl http://localhost:8080/guideitems/{id}
```
Retrieves a specific GuideItem by sending a GET request with the ID as a path variable. Replace {id} with the actual ID of the GuideItem.

## 3) Create GuideItem
```bash
curl -X POST -H "Content-Type: application/json" -d '{"property1":"value1","property2":"value2"}' http://localhost:8080/guideitems
```
Creates a new GuideItem by sending a POST request with JSON data containing the properties and values.

## 4) Update GuideItem
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"property1":"newvalue1","property2":"newvalue2"}' http://localhost:8080/guideitems/{id}
```
Updates an existing GuideItem by sending a PUT request with JSON data containing the updated properties and values. Replace {id} with the actual ID of the GuideItem.

## 5) Delete GuideItem
```bash
curl -X DELETE http://localhost:8080/guideitems/{id}
```
Deletes a GuideItem by sending a DELETE request to the specified endpoint. Replace {id} with the actual ID of the GuideItem.

# Guide Entity

## 1) Fetch Guides
```bash
curl http://localhost:8080/guides
```
This command retrieves a list of Guides from the specified endpoint.

## 2) Fetch Guide by ID
```bash
curl http://localhost:8080/guides/{id}
```
Retrieves a specific Guide by sending a GET request with the ID as a path variable. Replace {id} with the actual ID of the Guide.

## 3) Create Guide
```bash
curl -X POST -H "Content-Type: application/json" -d '{"property1":"value1","property2":"value2","items":[{"itemProperty1":"itemValue1","itemProperty2":"itemValue2"}]}' http://localhost:8080/guides
```
Creates a new Guide by sending a POST request with JSON data containing the properties and values. Include items if needed.

## 4) Update Guide
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"property1":"newvalue1","property2":"newvalue2","items":[{"itemProperty1":"itemNewValue1","itemProperty2":"itemNewValue2"}]}' http://localhost:8080/guides/{id}
```
Updates an existing Guide by sending a PUT request with JSON data containing the updated properties and values. Include items if needed. Replace {id} with the actual ID of the Guide.

## 5) Delete Guide
```bash
curl -X DELETE http://localhost:8080/guides/{id}
```
Deletes a Guide by sending a DELETE request to the specified endpoint. Replace {id} with the actual ID of the Guide.
