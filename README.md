# Inventory Service #

The inventory service manages information about the inventory

## Building
```./gradlew build```

## API ##  

| METHOD | PATH | Accept | Body | DESCRIPTION |
| ------ |----- | ------ |----- | ----------- |
| **GET**    | products |        |      | List all products |
| **GET**    | products/*{productId}* |        |      | Retrieve a product |
| **POST**   | products  | application/json | [<br>&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id: '123-foo',<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;quantity: 12<br>&nbsp;&nbsp;&nbsp;}<br>] | Add products |
| **PUT**    | products  | application/json | [<br>&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id: '123-foo',<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;quantity: 11<br>&nbsp;&nbsp;&nbsp;}<br>] | Update products |
