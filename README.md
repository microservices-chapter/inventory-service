# Inventory Service #

The inventory service manages information about the inventory

## Building
```./gradlew build```

## API ##  

| METHOD | PATH | Accept | Body | DESCRIPTION |
| ------ |----- | ------ |----- | ----------- |
| **GET**    | inventory |        |      | List all products |
| **GET**    | inventory/*{productId}* |        |      | Retrieve a product |
| **PUT**   | inventory  | application/json | {<br>&nbsp;&nbsp;&nbsp;id: '123-foo',<br>&nbsp;&nbsp;&nbsp;quantity: 12,<br>&nbsp;&nbsp;&nbsp;type: 'increase or decrease'<br>} | Update a product |
| **DELETE**   | inventory  | application/json | {<br>&nbsp;&nbsp;&nbsp;id: '123-foo'<br>} | Delete a product |
