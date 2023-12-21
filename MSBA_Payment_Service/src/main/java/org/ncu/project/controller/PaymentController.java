package org.ncu.project.controller;

import org.ncu.project.dto.PaymentRequest;
import org.ncu.project.dto.PaymentResponse;
import org.ncu.project.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	
	 	@Autowired
	    private PaymentService paymentService; // Assume you have a PaymentService to handle payment logic

	    @PostMapping("/transaction")
	    public ResponseEntity<String> performTransaction(@RequestBody PaymentRequest paymentRequest) {
	        // Logic to perform the transaction using Payment service
	        String transactionId = paymentService.performTransaction(paymentRequest);

	        // Create the confirmation message
//	        String message = "Booking confirmed for user with aadhaar number: " + paymentRequest.getAadhaarNumber()
//	                + "| Here are the booking details: " + paymentRequest.toString();
//
//	        // Log the confirmation message
//	        System.out.println(message); 

	        // Return the transactionId and an HTTP status indicating success
	        return new ResponseEntity<>(transactionId, HttpStatus.OK);
	    }
	    
	    @GetMapping("transaction/{transactionId}")
	    public ResponseEntity<?> getTransactionDetails(@PathVariable int transactionId) {
	        // Call a service method to retrieve transaction details based on transactionId
	    	PaymentResponse transactionDetails = new PaymentResponse(paymentService.getPaymentById(transactionId));

	        return ResponseEntity.ok(transactionDetails); // Return OK (200) with transaction details
	       
	    }
}
