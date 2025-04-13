<h1 align="center">Conta Service Aplication</h1>

<p align="center">This program is being developed to test habilities in Java.</p>

<p>To initialize the project it's important to create the project clicking in the following link:</p>

<ul>
  <li><a href="https://start.spring.io/">Start Spring Link</a></li>
</ul>

<p>For sprint Boot, you can create it in 3.4.4 version, package jar, Java 17.</p>

<p>The dependencies used for the project are the following ones:</p>

<ul>
  <li><code>Lombok</code></li>
  <li><code>H2 Database</code></li>
  <li><code>Spring Data JPA</code></li>
  <li><code>Spring Web</code></li>
</ul>

<p>Generate the project, download and unzip it into your choosen folder.</p>

<p>Make sure your JDK is setted to Java 17</p>

<p>Open the Project with your choosen IDE. I am currently using Intellij IDEA Community.</p>

<p>To initally run the application, use the following command line:</p>

<ul>
  <li><code>mvn clean install</code></li>
</ul>

<p>Make sure to initialize and push your application to github.</p>

<p>Create the model package inside main > java > com.bootcamp.conta_service folder. Then, create the <code>Conta</code> class.</p>

<p>Create the repository package inside main > java > com.bootcamp.conta_service folder. Then, create the <code>ContaRepository</code> interface.</p>

<p>Create the dto package inside main > java > com.bootcamp.conta_service folder. 
  Then, create the <code>ContaDTO</code> class, <code>ContaRequeseDTO</code> class and <code>ContaResponseDTO</code> class.</p>

<p>Create the service package inside main > java > com.bootcamp.conta_service folder. 
  Then, create the <code>ContaService</code> class.</p>

<p>Create the exception package inside main > java > com.bootcamp.conta_service folder. 
  Then, create the exceptions <code>ContaExistenteException</code>, <code>ContaNaoExistenteException</code> and <code>SaldoInsuficienteException</code>.</p>
  
<p>Create the configuration package inside main > java > com.bootcamp.conta_service folder. 
  Then, create the <code>ControllerExceptionHandler</code> class.</p>

<p>Create the controller package inside main > java > com.bootcamp.conta_service folder. 
  Then, create the <code>ContaController</code> class.</p>

<p>Inside the resources package, create the <code>application.yaml</code> file</p>

<p>Test the application with H2 Database with the link <code>localhost:9000/h2-console/</code></p>

<p>Test the application with Postman interface to create the HTTP methods.</p>

<p>To do the Post method, it's necessary to use the link <code>http://localhost:9000/api/contas</code>. Change the body to raw (JSON) format and write the following attributes to be valid:</p>

<code>
{
    "nomeTitular": "exemplo",
    "numeroAgencia": "1234",
    "numeroConta": "56789",
    "chavePix": "exemplo@pix"
}  
</code>

<p>It will return status <code>201</code>, which means it was created.</p>

<p>To do the Get method, it's the same link. The JSON that will be looking similar with the post you created. It will begin with the id number, the following attributes the user typed in post, and also the wage (saldo) it was set in the code.</p>

<p>It will return status <code>200</code>, which means success.</p>

<p>To use the Get method to find by id, use this link: <code>http://localhost:9000/api/contas/:id</code>. 
In tha Path Variables table, the interface will display the id for the user to fill with an existent id in the database. 
Copy the id from H2 database, past in the value field, and click on "Send" button. It will return the main attributes used before. It's an importante method to match for equal id keys. </p>

<p>To use the Put method to update the user file, it's the same link as the last one. For the Params, it's necessary to use the id that the user wish to change the data, similar as the last one. 
Then, in the body, use raw (JSON) format, using the same properties that was used to write the post method. Then, update the data you wish to change. 
To test it, just repeat the last get method used with the same id to see if the data has changed. Also, test it on H2 Console.</p>

<p>To use the Delete method, just use the same link used for put and second get method. It's not necessary to insert body, just the value of the id to be deleted, same as in put method. It will return status <code>204 - No content</code>.</p>

<p>Inside the model package, create the class <code>Pix</code></p>

<p>Inside the DTO package, create the classes <code>PixDTO</code>, <code>PixRequestDTO</code> and <code>PixResponseDTO</code>.</p>

<p>Inside the repository package, create the interface <code>PixRepository</code></p>

<p>Inside the service package, create the class <code>PixService</code></p>

<p>Inside the controller package, create the class PixController</p>

<p>To test the API in Postman, use the following link: <code>http://localhost:9000/api/pix</code></p>

<p>To test the post method, use the following attributes:</p>

<code>
  {
    "chavePixRecebedor" : "nome1@pix.com",
    "chavePixPagador" : "nome2@pix.com",
    "valor" : "3000",
    "idempotencia" : "text"
}
</code>
