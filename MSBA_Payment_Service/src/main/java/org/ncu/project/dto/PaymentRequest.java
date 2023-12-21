package org.ncu.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
	private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;
}
