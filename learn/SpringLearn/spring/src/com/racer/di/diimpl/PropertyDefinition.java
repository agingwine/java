package com.racer.di.diimpl;

public class PropertyDefinition {
	private String name;
	private String ref;
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public PropertyDefinition(String name, String ref) {
		this.name = name;
		this.ref = ref;
	}
	public PropertyDefinition(String name, String ref, String value) {
		this.name = name;
		this.ref = ref;
		this.value = value;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
}
