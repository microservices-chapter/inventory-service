# Inventory Service #

The inventory service manages information about the inventory

## Building
```./gradlew build```

## API ##  

| METHOD | PATH | Accept | Body | DESCRIPTION |
| ------ |----- | ------ |----- | ----------- |
| **GET**    | inventory |        |      | List all products |
| **GET**    | inventory/*{productId}* |        |      | Retrieve a product |
| **POST**   | inventory  | application/json | [<br>&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id: '123-foo',<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;quantity: 12<br>&nbsp;&nbsp;&nbsp;}<br>] | Update a list of products |
