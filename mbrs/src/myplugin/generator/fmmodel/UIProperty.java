package myplugin.generator.fmmodel;

public class UIProperty {

	private String label;
	private String type;
	private boolean isReadOnly;
	
	public UIProperty() {
		super();
	}

	public UIProperty(String label, String type, boolean isReadOnly) {
		super();
		this.label = label;
		this.type = type;
		this.isReadOnly = isReadOnly;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	
	
	
}
