package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "historico")
@NamedQueries({
	@NamedQuery ( name = "Historic.findAll" , query = "SELECT h FROM Historic h"),
    @NamedQuery(name = "Historic.findByName",
            query = "SELECT h FROM Historic h WHERE h.name = :name"),
    
})
public class Historic {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name="name", nullable=false)
	private String name;
	
	@Column (name="description", nullable=false)
	private int description;
	
	@Column (name="type", nullable=false)
	private String type;
	
	@Column (name="qtd", nullable=false)
	private int qtd;
	
	@Column (name="product_id", nullable=false)
	private int product_id;
	
}
