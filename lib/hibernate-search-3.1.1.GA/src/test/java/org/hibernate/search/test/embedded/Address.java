//$Id: Address.java 14330 2008-02-12 16:06:21Z epbernard $
package org.hibernate.search.test.embedded;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.annotations.Target;

/**
 * @author Emmanuel Bernard
 */

@Entity
@Indexed
public class Address {
	@Id
	@GeneratedValue
	@DocumentId
	private Long id;

	@Field(index= Index.TOKENIZED)
	private String street;

	@IndexedEmbedded(depth = 1, prefix = "ownedBy_", targetElement = Owner.class)
	@Target(Owner.class)
	private Person ownedBy;

	@OneToMany(mappedBy = "address")
	@ContainedIn
	private Set<Tower> towers = new HashSet<Tower>();

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@IndexedEmbedded
	private Country country;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Person getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Person ownedBy) {
		this.ownedBy = ownedBy;
	}


	public Set<Tower> getTowers() {
		return towers;
	}

	public void setTowers(Set<Tower> towers) {
		this.towers = towers;
	}
}