package dao;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageHelper {
    public static Image resize(Image oriImage, int targetWidth, int targetHeight){
        Image resultImg = oriImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultImg;
    }
    
    public static byte[] toByteArr(Image img, String type)throws  IOException{
      BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimg.createGraphics();
        g.drawImage(img,0,0,null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimg, type, baos);
        byte[] imageInByte = baos.toByteArray();
        return imageInByte;
                
    }
    
    public static Image createImgFromByArray(byte[] data, String type) throws IOException{
        ByteArrayInputStream bis= new ByteArrayInputStream(data);
        BufferedImage bimage2 = ImageIO.read(bis);
        Image img = bimage2.getScaledInstance(bimage2.getWidth(), bimage2.getHeight(), Image.SCALE_SMOOTH);
        return img;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}