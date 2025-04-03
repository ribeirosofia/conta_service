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
