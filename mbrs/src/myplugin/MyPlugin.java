package myplugin;

import java.io.File;

import javax.swing.JOptionPane;

import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;


import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;

/** MagicDraw plugin that performes code generation */
public class MyPlugin extends com.nomagic.magicdraw.plugins.Plugin {
	
	String pluginDir = null; 
	
	public void init() {
		JOptionPane.showMessageDialog( null, "My Plugin init");
		
		pluginDir = getDescriptor().getPluginDirectory().getPath();
		
		// Creating submenu in the MagicDraw main menu 	
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();		
		manager.addMainMenuConfigurator(new MainMenuConfigurator(getSubmenuActions()));
		
		/** @Todo: load project options (@see myplugin.generator.options.ProjectOptions) from 
		 * ProjectOptions.xml and take ejb generator options */
		
		//for test purpose only:
		//test();
		
		serviceOptions();
		serviceImplOptions();
		mapperOptions();
		modelOptions();
		enumOptions();
		repoOptions();
	}
	
	private void test() {
		GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp", "ejbclass", "templates", "{0}.java", true, "ejb"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator", ejbOptions);
				
		ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); //apsolutna putanja
	}
	private void serviceOptions() {
		GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp", "serviceclass", "templates", "{0}Service.java", true, "uns.ftn.mbrs.service"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceGenerator", ejbOptions);
				
		ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); //apsolutna putanja
	}
	private void serviceImplOptions() {
		GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp", "serviceimplclass", "templates", "{0}ServiceImpl.java", true, "uns.ftn.mbrs.serviceimpl"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceImplGenerator", ejbOptions);
		ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); //apsolutna putanja
	}
	
	private void mapperOptions() {
		GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp", "mapperclass", "templates", "{0}Mapper.java", true, "uns.ftn.mbrs.mapper"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("MapperGenerator", ejbOptions);
		ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); //apsolutna putanja
	}
	
	private void modelOptions() {
		GeneratorOptions modelOptions = new GeneratorOptions("c:/temp", "modelclass", "templates", "{0}.java", true, "uns.ftn.mbrs.model"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ModelGenerator", modelOptions);
		modelOptions.setTemplateDir(pluginDir + File.separator + modelOptions.getTemplateDir()); //apsolutna putanja
	}
	private void enumOptions() {
		GeneratorOptions enumOptions = new GeneratorOptions("c:/temp", "enum", "templates", "{0}.java", true, "uns.ftn.mbrs.model"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EnumGenerator", enumOptions);
		enumOptions.setTemplateDir(pluginDir + File.separator + enumOptions.getTemplateDir());
		
	}
	
	private void repoOptions() {
		GeneratorOptions enumOptions = new GeneratorOptions("c:/temp", "repositoryclass", "templates", "{0}Repository.java", true, "uns.ftn.mbrs.repository"); 				
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RepoGenerator", enumOptions);
		enumOptions.setTemplateDir(pluginDir + File.separator + enumOptions.getTemplateDir());
		
	}
	
	private NMAction[] getSubmenuActions()
	{
	   return new NMAction[]{
			new GenerateAction("Generate"),
	   };
	}
	
	public boolean close() {
		return true;
	}
	
	public boolean isSupported() {				
		return true;
	}
}


