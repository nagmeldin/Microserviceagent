<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title> Search Bank </title>
</head>
       <body>

     	      <div class="body">	
				  	 
				     <g:form controller="agent"  method="GET">
					 
				             <label> Bank ID: </label>
				             <g:textField name="bankId"/>   <br/>
				              				 
				             <g:actionSubmit  action="search"  value="Search Bank"/>
				      </g:form>
     	 				
     	     </div>	
	  
  
    </body>
</html>