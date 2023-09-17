package it.setp.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "movies")
public class Movie implements Serializable {



	/**
	 *
	 */
	private static final long serialVersionUID = -8530988490879787916L;


	@Id
	@Column(name="imdbid")
	private String imdbID;
	private String title;
	private String year;
	private String rated;
	private Date released;
	private String runtime;
	private String gerne;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metascore;
	private String imdbrating;
	private String imdbvotes;
	private String type;
	private Date dvd;
	private String boxoffice;
	private String production;
	private String website;
	private boolean response;
	private Integer totalseason;

	@Override
	public int hashCode() {
		return Objects.hash(imdbID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(imdbID, other.imdbID);
	}







}
