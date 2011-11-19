package controllers.playbird;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Http.Response;
import play.vfs.VirtualFile;

public class PlaybirdController extends Controller {

	/**
	* Index.
	*/
	public static void index() {
		
		render();
	}
	
	public static void track() throws IOException {
		
		play.modules.playbird.PlaybirdPlugin.hitStream.publish(new Integer(1));
		VirtualFile vf1 = VirtualFile.fromRelativePath("{module:playbird}/public/images/tracking.gif");
		BufferedImage image = ImageIO.read(vf1.getRealFile());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    
	    ImageIO.write(image, "gif", baos);
	    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	    Response.current().contentType = "image/png";

	    renderBinary(bais);
	}
}
