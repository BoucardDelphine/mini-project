package fr.tse.applicationDistrib.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID", unique=true, nullable=false, precision=10)
	private long locationId;

	@Column(name="CITY", nullable=false, length=30)
	private String city;

	@Column(name="POSTAL_CODE", length=12)
	private String postalCode;

	@Column(name="STATE_PROVINCE", length=25)
	private String stateProvince;

	@Column(name="STREET_ADDRESS", length=40)
	private String streetAddress;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="location")
	private Set<Department> departments;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	public Location() {
	}

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setLocation(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setLocation(null);

		return department;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}