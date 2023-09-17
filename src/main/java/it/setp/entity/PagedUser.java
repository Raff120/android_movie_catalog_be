package it.setp.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PagedUser {
	
	private Integer numPag;
	private List<User> user = new ArrayList<User>();


}
