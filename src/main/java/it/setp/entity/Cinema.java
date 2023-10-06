package it.setp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "cinemas")
public class Cinema implements Serializable {


    private static final long serialVersionUID = 6737007273584214943L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cinema")
    private int id_cinema;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String description;
    private String photo;

}
