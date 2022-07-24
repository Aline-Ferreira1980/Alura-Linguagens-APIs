package br.com.alura;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pricipaisLinguagens")
public class Linguagem {
	
	@Id
	private String id;
	private String title;
	private String image;
	private int ranking;
		
	public Linguagem() {}
	public Linguagem(String title, String image, int ranking) {
		super();
		
		this.title = title;
		this.image = image;
		this.ranking = ranking;
	}
	
	public int getRanking() {
		return ranking;
	}
	public String getTitle() {
		return title;
	}
	public String getImage() {
		return image;
	}
	public String getId() {
		return id;
	}

}
