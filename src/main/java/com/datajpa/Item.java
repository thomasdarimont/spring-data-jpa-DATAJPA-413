package com.datajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// TODO: Auto-generated Javadoc
@Entity
@Table(name = "items")
@IdClass(com.datajpa.ItemId.class)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Item {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT")
	private Integer id;


	/** The sales device id. */
	@Id
	@Column(name = "sales_device_id", columnDefinition = "INT")
	@ManyToOne
	private SalesDevice salesDevice;

	/**
	 * Instantiates a new item.
	 */
	public Item() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SalesDevice getSalesDevice() {
		return salesDevice;
	}

	public void setSalesDevice(SalesDevice salesDevice) {
		this.salesDevice = salesDevice;
	}

}