<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Editare produs</title>
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}


/* Style inputs with type="text", select elements and textareas */
input[type=text], select, textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */  
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

/* Style the submit button with a specific background color etc */
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type=submit]:hover {
  background-color: #45a049;
}

/* Add a background color and some padding around the form */
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<div class="header">
  <a href="./index.htm" class="logo">Magazin Online</a>
  <div class="header-right">
    <a href="./index.htm">Acasa</a>
    <a href="./branduri.htm">Branduri</a>
    <a class="active" href="./produse.htm">Produse</a>
    <a href="./magazine.htm">Magazine</a>
    <a href="./clienti.htm">Clienti</a>
    <a href="./finantare.htm">Finantare</a>
  </div>
</div>
<div class="w3-bar w3-red">
<div class="w3-bar-item">Aduagati:</div>
  <div class="w3-bar-item"><a href="./branduriAdd.htm"><font color="FFFFFF">Brand</font></a></div>
  <div class="w3-bar-item"><a href="./produseAdd.htm"><font color="FFFFFF">Produs</font></a></div>
  <div class="w3-bar-item"><a href="./clientiAdd.htm"><font color="FFFFFF">Client</font></a></div>
  <div class="w3-bar-item"><a href="./magazineAdd.htm"><font color="FFFFFF">Magazin</font></a></div>
  <div class="w3-bar-item"><a href="./finantareAdd.htm"><font color="FFFFFF">Finantare</font></a></div>
</div>
<br>
<br>
<div style="padding-left:100px; padding-right:100px">
<form:form action="${pageContext.request.contextPath}/editProduse.htm" commandName="produseForm" 
			method="post">
			
			
<!-- 	<label for="fname">Id</label> -->
    <form:input type="hidden" path="id" name="id"/>
   
  
       <label for="fname">Cod produs </label>  <a href="#" data-toggle="tooltip" title="Codul introdus trebuie sa fie unic">&#9432;</a>
    <form:input type="text" path="codProduse" name="id"/>
    
    
       <label for="fname">Nume</label>
    <form:input type="text" path="nume" name="id"/>
    
<label for="brand">Brand</label> <a href="#" data-toggle="tooltip" title="Daca nu regasiti brandul in lista, adaugati un brand nou.">&#9432;</a>    
    <%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost/magazinonline?user=root&password=fasttrackit");

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from branduri") ;
%>


        <select id="brand" name="brand">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(2)%></option>
        <% } %>
        </select>


<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("Nu exista branduri"+e);
        }
%>
    
    <label for="categorie">Categorie</label>
    <select id="categorie" name="categorie">
      <option value="It/C">It/C</option>
      <option value="Jocuri">Jocuri</option>
      <option value="Fashion">Fashion</option>
      <option value="Ingrijire Personala si Cosmetice">Ingrijire Personala si Cosmetice</option>
      <option value="Carti, Birotica si Cadouri">Carti, Birotica si Cadouri</option>
      <option value="Casa si Bricolaj">Casa si Bricolaj</option>
      <option value="Echipamente Sportive">Echipamente Sportive</option>
      <option value="Auto-Moto">Auto-Moto</option>
      <option value="Jucarii">Jucarii</option>
      <option value="Alimente">Alimente</option>
    </select>
     
    
    <label for="fname">Stoc</label>
    <form:input type="text" path="stoc" name="id"/>

	<label for="fname">Pret</label>
    <form:input type="text" path="pret" name="id"/>

    <input type="submit" value="Trimite">
</form:form>
</div>

<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</body>
</html>