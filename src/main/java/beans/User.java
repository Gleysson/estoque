package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "users")
@NamedQueries({
	@NamedQuery ( name = "User.findAll" , query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.login",
    query = "SELECT u FROM User u WHERE u.login = :login and u.password = :password"),
})
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name="name", nullable=false)
	private String name;
	
	@Column (name="login", nullable=false, unique=true)
	private String login;
	
	@Column (name="password", nullable=false, length=30)
	private String password;
	
	@Column (name="level", nullable=false)
	private String level;
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
