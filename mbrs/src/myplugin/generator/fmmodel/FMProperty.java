package myplugin.generator.fmmodel;


public class FMProperty extends FMElement  {
	//Property type
	private FMType type;
	// Property visibility (public, private, protected, package)
	private String visibility;
	//Multiplicity (lower value)
	private Integer lower;
	//Multiplicity (upper value) 
	private Integer upper;
	
	private boolean association;
	
	private String aggregationType;

	
	private UIProperty uiProperty;
	/** @ToDo: Add length, precision, unique... whatever is needed for ejb class generation
	 * Also, provide these meta-attributes or tags in the modeling languange metaclass or 
	 * stereotype */
	
	
	public FMProperty(String name, FMType type, String visibility, int lower, int upper, boolean association, String aggregationType) {
		super(name);
		this.type = type;
		this.visibility = visibility;
		
		this.lower = lower;
		this.upper = upper;	
		this.association = association;
		this.aggregationType = aggregationType;
	}
	
	
	
	public FMProperty(String name, FMType type, String visibility, Integer lower, Integer upper, boolean association,
			UIProperty uiProperty, String aggregationType) {
		super(name);
		this.type = type;
		this.visibility = visibility;
		this.lower = lower;
		this.upper = upper;
		this.association = association;
		this.uiProperty = uiProperty;
		this.aggregationType = aggregationType;

	}



	public FMProperty(String name, FMType type, String visibility, Integer lower, Integer upper,String aggregationType) {
		super(name);
		this.type = type;
		this.visibility = visibility;
		this.lower = lower;
		this.upper = upper;
		this.aggregationType = aggregationType;

	}


	public UIProperty getUiProperty() {
		return uiProperty;
	}


	public void setUiProperty(UIProperty uiProperty) {
		this.uiProperty = uiProperty;
	}


	public boolean isAssociation() {
		return association;
	}

	public void setAssociation(boolean association) {
		this.association = association;
	}


	public FMType getType() {
		return type;
	}
	public void setType(FMType type) {
		this.type = type;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}



	public String getAggregationType() {
		return aggregationType;
	}



	public void setAggregationType(String aggregationType) {
		this.aggregationType = aggregationType;
	}
}
