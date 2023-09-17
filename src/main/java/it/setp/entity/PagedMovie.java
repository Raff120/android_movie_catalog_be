package it.setp.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PagedMovie {
	
	private Integer numPag;
	private List<Movie> movie = new ArrayList<Movie>();


}
