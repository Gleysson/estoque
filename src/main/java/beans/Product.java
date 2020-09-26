package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "products")
@NamedQueries({
	@NamedQuery ( name = "Product.findAll" , query = "SELECT pd FROM Product pd"),
	@NamedQuery ( name = "Product.findByName" , 
	query = "SELECT pd FROM Product pd WHERE pd.name = :name"),
})
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name="name", nullable=false, unique=true)
	private String name;
	
	@Column (name="description", nullable=false)
	private String description;
	
	@Column (name="unit_cost", nullable=false)
	private float unit_cost;
	
	@Column (name="sale_price", nullable=false)
	private float sale_price;
	
	@Column (name="provider_id", nullable=false)
	private int provider_id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(float unit_cost) {
		this.unit_cost = unit_cost;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public int getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}


}
