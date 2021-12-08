package org.zerock.controller.p05controller.bean;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Bean13 {
	private Integer employeeId;
	private String lastName;
	private String firstName;
	private String photo;
	private String notes;
	private LocalDate birthDate;
}
