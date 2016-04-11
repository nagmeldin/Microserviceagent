package microserviceagent

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import groovy.json.JsonBuilder

@Transactional
class BankService {

				   	 String bankQueryUrl = 'http://localhost:9290/Microservicebanks/banx' // Bean property in Config.groovy
					 String bankQueryUrl1 = 'http://localhost:9290/Microservicebanks/banx/1' // Bank of America
					 String bankQueryUrl2 = 'http://localhost:9290/Microservicebanks/banx/2' // Wellsfargo
					 String bankQueryUrl3 = 'http://localhost:9290/Microservicebanks/banx/3' // Chase
	
				   	// @Cacheable("bankData")
				   	    def getBank(def bankId)  // not working
				   		    {	   
				   			 // log.info "Retrieve bank with id" 
				   			  def rest = new RestBuilder()  // This facilitates request calls & requires 'REST Client Builder' plugin
	   				          def response = rest.get("${bankQueryUrl}/${bankId}"){                
                                                                                     accept "application/xml"
                                                                                     contentType "application/xml"	
                                                                                  } 
							 def data = [] 		 
							     data = response.xml.collect{ bank -> 
				   			                                ['BANK':response.xml.bank.name,'LOAN':response.xml.bank.maxLoanAmount]				 
														   }
							 return data
				   		    }
		                     
		  
				   		// def getBanks(def bankId)
						def getBanks()
				   			   {
				   				 // log.info "Retrieve banks"
				   				    def rest  = new RestBuilder()  // This facilitates request calls & requires 'REST Client Builder' plugin
			   				        def response = rest.get(bankQueryUrl){
                                                                           accept "application/xml"
                                                                           contentType "application/xml"	
                                                                         } 
									 
								    def status = response.status                   // internal parameter OK=200
								    def banks = response.xml.bank.name            // [ 'Chase', 'Bank of America', 'Wellsfargo']
								    def loans = response.xml.bank.maxLoanAmount  // [ 3999, 2889,1099]
									def ids  = response.xml.bank.id              // internal 1,2,3 
 
								    def data = []
									
								   if (status.equals(200))
								     {
									  
  				   				         data = response.xml.collect{ bank ->  	
										 									               			 																	 
										                             ['BANK':response.xml.bank.name,'LOAN':response.xml.bank.maxLoanAmount]  
																																 																  
  				   											         } 
																	   	
							 	    }						
										

								      	
									// def data = ['Bank of America':3999, 'Wellsfargo':2889, 'Chase':1099] // from bank api	  							  
				   				    return data   //List which maps banks and price 
				   			    }


}

 