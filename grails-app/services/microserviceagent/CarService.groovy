package microserviceagent

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class CarService {

				   	String carsUnderPriceQueryUrl = 'http://localhost:9291/Microservice-cars/automobiles/under' // Bean property in Config.groovy
				   	def bankService
 
				      def carCompatibleWithBank(def bankId)
				   	     {
				   		   //log.info "Retrieve cars compatible with bank id [ ${bankId }]"
				   		   def bank = bankService.getBank(bankId) //call bank service
				   		   def maxLoanAmount = bank.maxLoanAmount
						   
						   
			 			   def rest  = new RestBuilder()  // This facilitates request calls & requires 'REST Client Builder' plugin
				   		   def response = rest.get("${carsUnderPriceQueryUrl}/${maxLoanAmount}"){
	                                                                                              accept "application/xml"
	                                                                                              contentType "application/xml"	
	                                                                                             }    
						   
						   def data = [] 
				   		       data =   response.xml.collect { car ->
				   							           ['MAKE': response.xml.car.make, 'MODEL': response.xml.car.model, 'PRICE': response.xml.car.price]
				   						          }
						  return data				 
				   	    }
						
							
}
