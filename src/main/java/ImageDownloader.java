import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloader {

    public static BufferedImage urlToImage (String site) {
        BufferedImage img = null;
        try {
            URL url = new URL(site);
            img = ImageIO.read(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static File bufferedImageToFile (BufferedImage img) {
        File file = new File("imagem.png");
        try {
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static InputStream bufferedImageToInputStream (BufferedImage img) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "png", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

    public static BufferedImage resizeImage (BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();

        Image tmp = img.getScaledInstance(w/2, h/2, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(w/2, h/2, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}
