package com.example.image.saveimage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "imagedata")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	@Lob
	@Column(name = "imagedata", length = 1000)
	private byte[] imageData;
}
