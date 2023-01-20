package org.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.baseClass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotClass extends BaseClass {

	public static String takeScreenShot(String name) {

		TakesScreenshot tk = (TakesScreenshot) getDriver();
		File source = tk.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + name + dateFormat() + ".jpg";
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	public static String dateFormat() {
		Date d = new Date();
		SimpleDateFormat simple = new SimpleDateFormat();
		String format = simple.format(d);
		String replace = format.replace(":", ".");
		String date = replace.replace(" ", "");
		String replace2 = date.replace("/", ".");
		return replace2;
	}

}
