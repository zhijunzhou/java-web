package net.msyy.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Joe
 *
 */
public class FileUpload {

	public static void upload(String path, String filename,MultipartFile partFile) throws Exception {
		File imgFile = new File(path,filename);
		if(!imgFile.exists()) {
			imgFile.mkdirs();
		}
		try {
			partFile.transferTo(imgFile);
		} catch (Exception e) {
			throw new Exception("transform file failed!");
		}
	}
	
}
