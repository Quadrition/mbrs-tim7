package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FMClass extends FMType {	
	
	private String visibility;
	//Class properties
	private List<FMProperty> FMProperties = new ArrayList<FMProperty>();
	//list of packages (for import declarations) 
	private List<String> importedPackages = new ArrayList<String>();
	private UIClass uiClass = null;
	private String label;
	/** @ToDo: add list of methods */
	
	
	public FMClass(String name, String classPackage, String visibility) {
		super(name, classPackage);		
		this.visibility = visibility;
	}	
	
	
	
	public FMClass(String name, String typePackage, String visibility, List<FMProperty> fMProperties,
			List<String> importedPackages, UIClass uiClass) {
		super(name, typePackage);
		this.visibility = visibility;
		FMProperties = fMProperties;
		this.importedPackages = importedPackages;
		this.uiClass = uiClass;
	}

	

	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public UIClass getUiClass() {
		return uiClass;
	}


	public void setUiClass(UIClass uiClass) {
		this.uiClass = uiClass;
	}


	public List<FMProperty> getProperties(){
		return FMProperties;
	}
	
	public Iterator<FMProperty> getPropertyIterator(){
		return FMProperties.iterator();
	}
	
	public void addProperty(FMProperty property){
		FMProperties.add(property);		
	}
	
	public int getPropertyCount(){
		return FMProperties.size();
	}
	
	public List<String> getImportedPackages(){
		return importedPackages;
	}

	public Iterator<String> getImportedIterator(){
		return importedPackages.iterator();
	}
	
	public void addImportedPackage(String importedPackage){
		importedPackages.add(importedPackage);		
	}
	
	public int getImportedCount(){
		return FMProperties.size();
	}
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}	

	
	
}
