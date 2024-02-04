# API Requests Description

# Location Entity: 
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
