package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
	
	private int id;
	private String name;
	private String address;
	private String city;
	private String postalCode;
	private String country;
	private String phone;
	
}
