<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title> All Bank Loans </title>
</head>
       <body>


          <div class="body">

               <form>	                    
                     <g:each var="it" in="${data}">
								 
					    <td> The Banks: ${it.BANK.encodeAsHTML()}</td> <br>
					    <td> The Loans: ${it.LOAN.encodeAsHTML()}</td> <br>	
					    	
                     </g:each>
						 
	           </form>	
        </div>
	  
  
  
    </body>
</html>