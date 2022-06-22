package myplugin.generator.fmmodel;

public class UIClass {

	private String label;
	private boolean create;
	private boolean update;
	private boolean delete;
	private boolean read;
	
	public UIClass() {
		super();
	}

	public UIClass(String label, boolean create, boolean update, boolean delete, boolean read) {
		super();
		this.label = label;
		this.create = create;
		this.update = update;
		this.delete = delete;
		this.read = read;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	
	
	
	
}
