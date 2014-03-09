package PropertyFile;


//http://selftechy.com/2011/06/20/creating-configuration-properties-for-selenium-test-suite///

import java.io.*;
import java.util.*;

public class pro_1 {
	String str, key;
	private String filepath;

	public pro_1(String filepath) {
		this.filepath = filepath;
	}

	public String ReadProperty(String propkey) {
		String propval = "";
		try {
			int check = 0;
			while (check == 0) {
				check = 1;
				File cfgfile = new File(filepath);
				if (cfgfile.exists()) {
					Properties props = new Properties();
					FileInputStream propin = new FileInputStream(cfgfile);
					props.load(propin);
					propval = props.getProperty(propkey);
				} else {
					check = 0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propval;
	}
}
