# gml-clients
proyecto de clientes
se realizaron 3 servicios
1. post
   url: clients
   recibe un JSON
   {
    "name":"Nora",
    "lastName":"Martinez",
    "phone":"3123652023",
    "email":"nora.martinezsierra@gmail.com",
    "startDate":"2023-06-09",
    "endDate":"2023-06-09"
}
2. un metodo GET
   url: clients/list
que me lista todo los usuarios
4. y otro metodo GET
   url: clients?id=1
   que consulta por id de cliente,
   recibe el parametro en un requestparam 
