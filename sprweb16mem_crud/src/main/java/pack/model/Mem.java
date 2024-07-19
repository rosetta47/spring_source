package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mem")
public class Mem {
	@Id
	private int num;
	
	private String name; // ,하는 것보다 아래로 나열하는게 좋아
	private String addr;
	
}
