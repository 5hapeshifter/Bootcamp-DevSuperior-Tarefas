package com.devsuperior.movieflix.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String subtitle;
	private Integer year;
	
	@Column(columnDefinition = "TEXT")
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	
	@OneToMany(mappedBy = "movie")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	public Movie() {
		
	}
	
	

	public Movie(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		this.id = id;
		this.title = title;
		this.subtitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subTitle) {
		this.subtitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	

	public List<Review> getReviews() {
		return reviews;
	}
	

	public Genre getGenre() {
		return genre;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
