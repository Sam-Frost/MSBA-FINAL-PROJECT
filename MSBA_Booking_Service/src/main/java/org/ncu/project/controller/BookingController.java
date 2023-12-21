package org.ncu.project.controller;

import org.ncu.project.dto.BookingRequest;
import org.ncu.project.dto.PaymentRequest;
import org.ncu.project.entity.Booking;
import org.ncu.project.error.ErrorResponse;
import org.ncu.project.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {
        
    	System.out.println("Booking controller got a POST request!!!");
    	
    	Booking booking = bookingService.createBooking(request);
      
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
    
    
    @PostMapping("/{bookingId}/transaction")
    public ResponseEntity<?> processPayment(@PathVariable int bookingId, @RequestBody PaymentRequest request) {
        
    	// Check if booking exists
    	if(!bookingService.doesBookingExist(bookingId)){
        	ErrorResponse errorResponse = new ErrorResponse("Invalid booking ID", HttpStatus.BAD_REQUEST.value());
        	return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    	
    	// Validate payment mode
        if (!isValidPaymentMode(request.getPaymentMode())) {
        	ErrorResponse errorResponse = new ErrorResponse("Invalid mode of payment", HttpStatus.BAD_REQUEST.value());
        	return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
 
        
        Booking booking = bookingService.performPayment(bookingId, request);

        //Create the confirmation message
        String message = "Booking confirmed for user with aadhaar number: " + booking.getAadharNumber()
                + "| Here are the booking details: " + booking.toString();

        // Log the confirmation message
        System.out.println(message); 

        
        return new ResponseEntity<>(booking, HttpStatus.CREATED);

    }

    // Method to validate payment mode
    private boolean isValidPaymentMode(String paymentMode) {
        return "UPI".equalsIgnoreCase(paymentMode) || "CARD".equalsIgnoreCase(paymentMode);
    }
    
}
