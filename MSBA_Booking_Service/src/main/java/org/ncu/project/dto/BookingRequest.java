package org.ncu.project.dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
	private LocalDate fromDate;
    private LocalDate toDate;
    private String aadharNumber;
    private int numOfRooms;
}
