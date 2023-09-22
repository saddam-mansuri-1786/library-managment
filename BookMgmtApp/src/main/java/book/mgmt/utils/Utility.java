package book.mgmt.utils;
 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Base64;
 
 public class Utility {
	//InputStream ---> Base64 (String)
	
	public static String displayImage(InputStream is) throws IOException{
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		 
		byte [] buffer = new byte[4096];
		
		int bytesRead = 1;
		
		while((bytesRead = is.read(buffer))!=-1) {
			
			outputStream.write(buffer,0,bytesRead);
		}
		byte [] imageByte =  outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageByte);
		
	return base64Image;
	}
}
