package it.setp.entity;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -455918067021369874L;
	
	@Id
	@Column(name="role")
	private String role;


}
