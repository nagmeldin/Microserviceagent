package microserviceagent

/*
 * A single single controller, single view app running at default port 9292
 */

/*
 * This is an API that exposes targeted population information(full names,ages, their cars) via XML or JSON to the outside world.
 * Clients can get such information by running 'curl' command from their remote servers:
 *     % curl -i http://localhost:9292/RestfulApp/api/folks.xml
 *     % curl -X POST --header "Content-Type: application/json" -d '{"fullName":"Anne Doe", "age":"26" }' http://localhost:9292/RestfulApp/api/folks.json
 * Note: Calling party doesn't need to know the internal names of the service when calling. This encapsulation is done using URL mapping
 */

class AgentController

 {
	 def bankService
	 def carService

    def index() 
	     {  
		    render 'API microservice world!'
	     }
		 
   def search () //not working
       { 
		  def bankId = params.id //  values: 1='Bank of America', 2='Wellsfargo', 3='Chase'
		  def data = bankService.getBank(bankId)  // not working
	       // def data = bankService.getBanks()    
	   
		   //[data:data] // render 
	 
		 // render  bankId // null?
        }	
		
	 
     def list ()
        { 
  		  def bankId = 1 //  values: 1='Bank of America', 2='Wellsfargo', 3='Chase'
  		 // def data = bankService.getBank(bankId)  // not working
  	        def data = bankService.getBanks()    
  	   // def data = ['Bank of America':3999, 'Wellsfargo':2889, 'Chase':1099] // from bank service	
	   
  		   [data:data] // render 
		  
  	    // def x = 100
  		// def y = 200
  	 	// [x:x, y:y] // render
	     
       }		 
	 
	 
	 
   
	 	 
}
