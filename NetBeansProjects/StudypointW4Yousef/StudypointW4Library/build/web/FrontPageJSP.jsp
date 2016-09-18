<%-- 
    Document   : FrontPageJSP
    Created on : 16-09-2016, 09:00:44
    Author     : Yousinho
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>      

        <% 
     List bookList = (List) session.getAttribute("bookList");   
     String booksToString = (String) session.getAttribute("booksToString");
        
        %>


        <title>Welcome to the Libirary of Ashurbanipal</title>
    </head>
    <body>
     
        <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#" >Page 1</a></li>
      <li><a href="#">Page 2</a></li> 
      <li><a href="#">Page 3</a></li> 
    </ul>
  </div>
</nav>

        <div id="mycarousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="item active">
            <img src="http://people.bethel.edu/~pferris/historical/hidden/HistSynopsisLinks/img/ashurbanipalslunchwhead.jpg" alt="" class="img-responsive" height="400" width="1200">
           <div class="carousel-caption">
               
           <h1>Ashurbanipal</h1>
           </div>
        </div>
    </div>
</div>        
        
        
        
        <div class="container-fluid">

                <div class="row">

                <div class="col-md-4">d</div>
                <div class="col-md-4"><h1>Ashurbanipal</h1>
                    
           <br><br>
                
                
                
                </div>
                <div class="col-md-4">f</div>

            </div> 
            
        


        </div>

  

            <div class="row">

                <form action="NewServlet" method="POST">
                 
             <input type="hidden" name="origin" value="addNewBook">
       <div class="col-md-1">
                        
                    </div>
                    <div class="col-md-2">
                        
                        <label>Title:</label> <br>
                   <input type="text" name="title" value="" />

                    </div>
                    <div class="col-md-2">
                    <label>Author:</label> <br>
                   <input type="text" name="author" value="" />


                    </div>
                    <div class="col-md-2">
         <label>Pages:</label> <br>
                   <input type="text" name="pages" value="" />

                    </div>
                    <div class="col-md-2">
         <label>Price:</label> <br>
                   <input type="text" name="price" value="" />
                    </div>
                    <div class="col-md-2">
                        <br>
                        <input type="submit" value="Add new book" name="submit" class="btn btn-default"/>
                    </div>
                  <div class="col-md-1">
                        
                    </div>
                </form>

            </div> 


        

        <br>  <br> <b> 
            
            <div class="row">

       <div class="col-md-2">
                        
       </div>
                <div class="col-md-5">
                     <label for="male"><%=booksToString %></label>
                              
       </div>
               
                   <div class="col-md-5">
                            </div>
               
    
               
                
                
        
                
                
            </div>
  
        
        </b>
       

    </body>
</html>
