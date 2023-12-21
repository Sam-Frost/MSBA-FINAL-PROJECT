package org.ncu.project.dto;

import org.ncu.project.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
	
	private int transactionId;
    private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;
    
    public PaymentResponse(Payment payment) {
    	
    	this.transactionId = payment.getTransactionId();
    	this.paymentMode = payment.getPaymentMode();
    	this.bookingId = payment.getBookingId();
    	this.upiId = payment.getUpiId();
    	this.cardNumber = payment.getCardNumber();	
    }
}

