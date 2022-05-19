package myplugin.generator.options;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import myplugin.generator.BasicGenerator;
import myplugin.generator.fmmodel.FMEnumeration;
import myplugin.generator.fmmodel.FMModel;

public class EnumGenerator extends BasicGenerator{

	public EnumGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}
	
	public void generate() {
		try {
			super.generate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		List<FMEnumeration> enums = FMModel.getInstance().getEnumerations();
	
		for (int i = 0; i < enums.size(); i++) {
			FMEnumeration en = enums.get(i);
			Writer out;		
			Map<String, Object> context = new HashMap<String, Object>();
			context.clear();
			
			try {
				out = getWriter(en.getName(), en.getTypePackage());
				if (out != null) {
					context.put("enum", en);
					context.put("values", en.getValues());
					getTemplate().process(context, out);
					out.flush();
				}
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
	}

}