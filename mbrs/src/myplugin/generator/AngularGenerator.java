package myplugin.generator;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;



public class AngularGenerator extends BasicGenerator {	
	
	public AngularGenerator(GeneratorOptions generatorOptions) {			
		super(generatorOptions);			
	}
	
	
	public Writer getWriter(String fileNamePart, String packageName) throws IOException {
		if (packageName != filePackage) {
			packageName.replace(".", File.separator);		
			filePackage = packageName;
		}
		
		String generatedFileName = "";

		String fileNamePartFirstLower = Character.toLowerCase(fileNamePart.charAt(0)) + fileNamePart.substring(1);
		
	    if(templateName.startsWith("addeditentity")) {
			generatedFileName = "addEdit" + fileNamePart;
		}
		else if(templateName.startsWith("angularmain")) {
			generatedFileName = "main";
		}
		else if(templateName.startsWith("entitydisplay")) {
			generatedFileName = "view" + fileNamePart;
		}
		else if(templateName.startsWith("angularroutes")) {
			generatedFileName = "main.routes";
		}
		String fullPath = outputPath
				+ File.separator
				+ (filePackage.isEmpty() ? "" : packageToPath(filePackage)
						+ File.separator)
				+ outputFileName.replace("{0}", generatedFileName);

		File of = new File(fullPath);
		if (!of.getParentFile().exists())
			if (!of.getParentFile().mkdirs()) {
				throw new IOException("An error occurred during output folder creation "
						+ outputPath);
			}

		System.out.println(of.getPath());
		System.out.println(of.getName());

		if (!isOverwrite() && of.exists())
			return null;

		return new OutputStreamWriter(new FileOutputStream(of));

	}
	

	public void generate() {
		
		try {
			super.generate();
		} catch (IOException e) {		
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		List<FMClass> classes = FMModel.getInstance().getClasses();
	//	List<FMRepositoryClass> repositoryClasses = FMModel.getInstance().getRepositoryClasses();
		for (int i = 0; i < classes.size(); i++) {
			FMClass cl = classes.get(i);			
			Writer out;
			Map<String, Object> context = new HashMap<String, Object>();
			try {
				out = getWriter(cl.getName(), getFilePackage());
				if (out != null) {
					context.clear();
					context.put("class", cl);
					context.put("properties", cl.getProperties());					
					context.put("importedPackages", cl.getImportedPackages());		
	//				context.put("repositoryClass", repositoryClasses.get(i));
					getTemplate().process(context, out);
					System.err.println("-----> getTemplate().process(context, out)" + "\n context" + context + "\n out" +out.toString() );

					out.flush();
				}
			} catch (TemplateException e) {	
				JOptionPane.showMessageDialog(null, e.getMessage());
			}	
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}	
		}			
	}

	public void generateJSFile() {
		// Test skup
		try {
			super.generate();
		} catch (IOException e) {		
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		List<FMClass> classes = FMModel.getInstance().getClasses();
		
		Writer out;
		Map<String, Object> context = new HashMap<String, Object>();
		try {
			out = getWriter("js", getFilePackage());
			if (out != null) {
				context.clear();
				context.put("classes", classes);
				System.err.println("---JS--> getTemplate().process(context, out)" + "\n context" + context + "\n out" +out.toString() );

				getTemplate().process(context, out);
				out.flush();
			}
		} catch (TemplateException e) {	
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
			
	}



}


