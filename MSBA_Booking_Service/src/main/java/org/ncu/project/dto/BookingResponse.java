package org.ncu.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
	
	 	private int id;
	    private LocalDateTime fromDate;
	    private LocalDateTime toDate;
	    private String aadharNumber;
	    private String roomNumbers;
	    private int roomPrice;
	    private int transactionId;
	    private LocalDateTime bookedOn;
}
