package myplugin;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import myplugin.analyzer.AnalyzeException;
import myplugin.analyzer.ModelAnalyzer;
import myplugin.generator.AngularGenerator;
import myplugin.generator.ControllerGenerator;
import myplugin.generator.MapperGenerator;
import myplugin.generator.ModelGenerator;
import myplugin.generator.RepoGenerator;
import myplugin.generator.ServiceGenerator;
import myplugin.generator.ServiceImplGenerator;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.EnumGenerator;
import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;

/** Action that activate code generation */
@SuppressWarnings("serial")
class GenerateAction extends MDAction{

	String outputPath;
	String parsedPath; //zbog importovanja paketa
	String htmlPath;
	public GenerateAction(String name) {			
		super("", name, null, null);		
	}

	public void actionPerformed(ActionEvent evt) {

		if (Application.getInstance().getProject() == null) return;
		Package root = Application.getInstance().getProject().getModel();

		if (root == null) return;

		//ModelAnalyzer analyzer = new ModelAnalyzer(root, "ejb");
		ModelAnalyzer analyzer = null;
		GeneratorOptions generatorOptions = null;

		try {
			//			analyzer.prepareModel();	
			//			GeneratorOptions go = ProjectOptions.getProjectOptions().getGeneratorOptions().get("EJBGenerator");			
			//			EJBGenerator generator = new EJBGenerator(go);
			//			generator.generate();
			//			/**  @ToDo: Also call other generators */ 
			//			JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: " + go.getOutputPath() +
			//					                         ", package: " + go.getFilePackage());
			//			exportToXml();
			//JOptionPane.showMessageDialog( null, "CAO");
			chooseLocation();
			parsePath();
			generateDTO(analyzer, root, generatorOptions);
			generateRepo(analyzer, root, generatorOptions);
			generateModel(analyzer, root, generatorOptions);
			generateEnum(analyzer, root, generatorOptions);
			generateService(analyzer, root, generatorOptions);
			generateServiceImpl(analyzer, root, generatorOptions);
			generateMapper(analyzer, root, generatorOptions);
			generateController(analyzer, root, generatorOptions);
			generateAddEditEntity(analyzer, root, generatorOptions);
			generateAngularMain(analyzer, root, generatorOptions);
			generateEntityDisplay(analyzer, root, generatorOptions);
			generateAngularRoutes(analyzer, root, generatorOptions);
			generateEntityList(analyzer, root, generatorOptions);
			generateAngularController(analyzer, root, generatorOptions);
			generateAngularService(analyzer, root, generatorOptions);
			generateAngularIndex(analyzer, root, generatorOptions);	
			generateAngularHome(analyzer, root, generatorOptions);		
			


		} catch (AnalyzeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} 			
	}
	private void chooseLocation() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogTitle("Choose destination folder");
		int status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			if (file == null) {
				outputPath = "C:/temp";
				htmlPath = "C:/temp";
				return;
			}

			String path = chooser.getSelectedFile().getAbsolutePath();
			outputPath = path;
			System.err.println("Putanjaaa "+ path);
			setHtmlPath(path);
			System.err.println("HTML putanja "+ htmlPath);


		}else {
			outputPath = null; //ukoliko je 1.put izabrao putanju, prilikom 2.generisanja ona ce biti tu pa treba vrednost vratiti na null
			htmlPath = null;

		}
	}
	
	private void setHtmlPath(String path) {
		String[] splited = outputPath.split("java"); //izgenerisana spring boot app uvek u sebi ima java folder "src\main\java"
		String tempPath = splited[0];
		
		htmlPath = tempPath + "\\webapp\\static\\app\\html";
		
	}

	private void parsePath() {
		if(outputPath != null) {
			String[] splited = outputPath.split("java"); //izgenerisana spring boot app uvek u sebi ima java folder "src\main\java"
			System.err.println("splited: " + splited[0] + " " + splited[1]);
			String[] parts = splited[1].split("\\\\");
			System.err.println("PARTS: ");
			parsedPath = "";
			for(int i = 1; i < parts.length; i++) { //pocinje od 1 jer nakon splita uvek na pocetku postoji razmak
				System.err.println(parts[i]);
				parsedPath += parts[i]+".";
			}
			System.err.println("PASRED PATH: " + parsedPath);
		}else {
			parsedPath = "temp."; //default path is C:\temp
		}


	}

	private void generateService(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions)
			throws AnalyzeException {
		analyzer = new ModelAnalyzer(root,parsedPath +"service");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ServiceGenerator");
		generatorOptions.setOutputPath(outputPath);
		ServiceGenerator serviceGenerator = new ServiceGenerator(generatorOptions);
		serviceGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();
	}

	private void generateServiceImpl(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions)
			throws AnalyzeException {
		analyzer = new ModelAnalyzer(root,parsedPath +"serviceimpl");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ServiceImplGenerator");
		generatorOptions.setOutputPath(outputPath);
		ServiceImplGenerator serviceImplGenerator = new ServiceImplGenerator(generatorOptions);
		serviceImplGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();
	}
	private void generateMapper(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions)
			throws AnalyzeException {
		analyzer = new ModelAnalyzer(root,parsedPath +"mapper");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("MapperGenerator");
		generatorOptions.setOutputPath(outputPath);
		MapperGenerator mapperGenerator = new MapperGenerator(generatorOptions);
		mapperGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();
	}
	private void generateModel(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions)
			throws AnalyzeException {
		analyzer = new ModelAnalyzer(root,parsedPath +"model");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ModelGenerator");
		generatorOptions.setOutputPath(outputPath);
		ModelGenerator modelGenerator = new ModelGenerator(generatorOptions);
		modelGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();
	}
	private void generateEnum(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "com.example.demo.model");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("EnumGenerator");
		generatorOptions.setOutputPath(outputPath);
		EnumGenerator enumGenerator = new EnumGenerator(generatorOptions);
		enumGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();

	}

	private void generateRepo(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, parsedPath + "repository");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("RepoGenerator");
		generatorOptions.setOutputPath(outputPath);
		RepoGenerator repoGenerator = new RepoGenerator(generatorOptions);
		repoGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();

	}

	private void generateController(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, parsedPath +"controller");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ControllerGenerator");
		generatorOptions.setOutputPath(outputPath);
		ControllerGenerator controllerGenerator = new ControllerGenerator(generatorOptions);
		controllerGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();

	}

	private void generateDTO(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, parsedPath +"dto");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("DtoGenerator");
		generatorOptions.setOutputPath(outputPath);
		ControllerGenerator controllerGenerator = new ControllerGenerator(generatorOptions);
		controllerGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
		exportToXml();

	}


	
	
	private void generateAddEditEntity(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {

		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();

		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularAddEditEntityGenerator");			
		generatorOptions.setOutputPath(htmlPath);
		AngularGenerator angularAddEditGenerator = new AngularGenerator(generatorOptions);
		angularAddEditGenerator.generate();
	}

	private void generateAngularMain(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularMainGenerator");			
		AngularGenerator angularMainGenerator = new AngularGenerator(generatorOptions);
		angularMainGenerator.generateJSFile();
	}

	private void generateEntityDisplay(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularEntityDisplayGenerator");			
		generatorOptions.setOutputPath(htmlPath);
		AngularGenerator angularEntityDisplayGenerator = new AngularGenerator(generatorOptions);
		angularEntityDisplayGenerator.generate();
	}

	private void generateAngularRoutes(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();

		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularRoutesGenerator");			
		AngularGenerator angularRoutesGenerator = new AngularGenerator(generatorOptions);
		angularRoutesGenerator.generateJSFile();
	}

	private void generateEntityList(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();

		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularEntityListPageGenerator");			
		generatorOptions.setOutputPath(htmlPath);
		AngularGenerator angularEntityListPageGenerator = new AngularGenerator(generatorOptions);
		angularEntityListPageGenerator.generate();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());
	}

	private void generateAngularController(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();

		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularControllersGenerator");			
		AngularGenerator angularControllersGenerator = new AngularGenerator(generatorOptions);
		angularControllersGenerator.generateJSFile();
		JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: "
				+ generatorOptions.getOutputPath() + ", package: " + generatorOptions.getFilePackage());


	}

	private void generateAngularService(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularServicesGenerator");			
		AngularGenerator angularServicesGenerator = new AngularGenerator(generatorOptions);
		angularServicesGenerator.generateJSFile();
	}

	private void generateAngularIndex(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException  {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();

		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularIndexPageGenerator");			
		AngularGenerator angularIndexGenerator = new AngularGenerator(generatorOptions);
		angularIndexGenerator.generateIndexPage();
	}

	private void generateAngularHome(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException  {
		analyzer = new ModelAnalyzer(root, "templates");
		analyzer.prepareModel();

		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("AngularHomePageGenerator");			
		generatorOptions.setOutputPath(htmlPath);

		AngularGenerator angularHomeGenerator = new AngularGenerator(generatorOptions);
		angularHomeGenerator.generateHomePage();
	}

	private void exportToXml() {
		if (JOptionPane.showConfirmDialog(null, "Do you want to save FM Model?") == 
				JOptionPane.OK_OPTION)
		{	
			JFileChooser jfc = new JFileChooser();
			if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();

				XStream xstream = new XStream(new DomDriver());
				BufferedWriter out;		
				try {
					out = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(fileName), "UTF8"));					
					xstream.toXML(FMModel.getInstance().getClasses(), out);
					xstream.toXML(FMModel.getInstance().getEnumerations(), out);

				} catch (UnsupportedEncodingException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				
				}		             
			}
		}	
	}	  

}