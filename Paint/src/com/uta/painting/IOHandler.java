package com.uta.painting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/** 
* @author Team
* @version 1.10
* @Description : This class mainly handles the actions to be performed when importing the file
* or saving the file or any other action pertaining a file
*/
public class IOHandler {

	public static String fileCopyTo(String Source, String Dest) {
		try {
			File df = new File(Dest);

			if (df.exists()) {
				int PositionOfSuffix = 1;
				String NameOfFile = getFileName(df.getName());
				String ExtOfFile = getFileExtension(df.getName());
				String Path_File = df.getParentFile().getAbsolutePath() + '/';

				String newFileName = Path_File + NameOfFile + '_' + PositionOfSuffix + '.'
						+ ExtOfFile;
				while (new File(newFileName).exists()) {
					newFileName = Path_File + NameOfFile + '_' + PositionOfSuffix + '.'
							+ ExtOfFile;
					PositionOfSuffix++;
				}
				Dest = newFileName;
			}

			FileInputStream original = new FileInputStream(Source);
			FileOutputStream destination = new FileOutputStream(Dest);

			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = original.read(buffer)) > 0) {
				destination.write(buffer, 0, bytesRead);
			}

			original.close();
			destination.flush();
			destination.close();
		} catch (Exception e) {
			return null;
		}
		return Dest;
	}

	/** Get file extension of the image file */
	public static String getFileExtension(String filename) {
		int dotposition = filename.lastIndexOf('.');
		return filename.substring(dotposition + 1, filename.length());
	}

	/** Get the name of the image file */
	public static String getFileName(String filename) {
		int dotposition = filename.lastIndexOf('.');
		return filename.substring(0, dotposition);
	}
}