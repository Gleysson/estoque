package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "providers")
@NamedQueries({
	@NamedQuery ( name = "Provider.findAll" , query = "SELECT pd FROM Provider pd"),
	@NamedQuery ( name = "Provider.findByName" , 
	query = "SELECT pd FROM Provider pd WHERE pd.name = :name"),
})
public class Provider {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name="name", nullable=false)
	private String name;
	
	@Column (name="phone", nullable=false)
	private String phone;
	
	@Column (name="email", nullable=true, unique=true)
	private String email;
	
	@Column (name="cnpj", nullable=false)
	private String cnpj;
	
	@Column (name="address", nullable=false)
	private String address;
	
	@Column (name="number", nullable=true)
	private String number;
	
	@Column (name="district", nullable=true)
	private String district;
	
	@Column (name="city", nullable=false)
	private String city;
	
	@Column (name="uf", nullable=false)
	private String uf;
	
	@Column (name="zipcode", nullable=false)
	private String zipcode;
	
	@Column (name="activity", nullable=false)
	private String activity;

	@Column (name="contact", nullable=false)
	private String contact;
	
	@Column (name="office", nullable=true)
	private String office;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
}
