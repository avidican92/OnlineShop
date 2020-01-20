<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produse</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://kit.fontawesome.com/69b143f616.js" crossorigin="anonymous"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Branduri</title>
<style>


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

#myInput {
  background-image: url('css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 100%; /* Full-width */
  font-size: 20px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 1px; /* Add some space below the input */
}

#myTable {
  border-collapse: collapse; /* Collapse borders */
  width: 100%; /* Full-width */
  border: 1px solid #ddd; /* Add a grey border */
  font-size: 18px; /* Increase font-size */
}

#myTable th, #myTable td {
  text-align: center; /* Left-align text */
  padding: 12px; /* Add padding */
}

#myTable tr {
  /* Add a bottom border to all table rows */
  border-bottom: 1px solid #ddd; 
}

#myTable tr.header, #myTable tr:hover {
  /* Add a grey background color to the table header and on hover */
  background-color: #f1f1f1;
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
<br><br>
<div style="padding-left:100px; padding-right:100px">
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Cautati dupa nume ...">
<table id="myTable" border=1>
<tr class="header">
    <th >Id</th>
    <th>Cod produs</th>
    <th>Nume</th>
    <th>Brand</th>
    <th>Categorie</th>
    <th>Stoc</th>
    <th>Pret</th>
    <th>Optiuni</th>
  </tr>
<c:forEach items="${model.produse}" var="p">
<tr>
 <td><c:out value="${p.id}"/></td>
 <td><c:out value="${p.codProduse}"/></td>
 <td><c:out value= "${p.nume}"/></td>
 <td><c:out value= "${p.brand}"/></td>
 <td><c:out value= "${p.categorie}"/></td>
 <td><c:out value= "${p.stoc}"/></td>
 <td><c:out value= "${p.pret}"/></td>
 <td><a href="./produseEdit/${p.id}" class="far fa-edit"></a>
      |     <a href="deleteProduse/${p.id}" onclick="return confirm('Sunteti sigur ca doriti sa stergeti aceasta intrare?');"  class="fa fa-trash-o"></a></td>
 </tr>
 <br/>
</c:forEach>
</table>
<script>
function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>
</div>
<br><br>
</body>
</html>