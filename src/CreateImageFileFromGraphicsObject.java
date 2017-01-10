import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

public class CreateImageFileFromGraphicsObject {

    public static void main(String[] args) throws IOException {

        int imageCount = 384;

        int width = 22500;
        int height = 14000;

        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        // create a circle with black
        g2d.setColor(Color.black);
        g2d.fillOval(0, 0, width, height);

        // create a string with yellow
        g2d.setColor(Color.RED);

        // Save as JPEG
        for(int i=0; i<imageCount; i++){

            String uuid = UUID.randomUUID().toString();
            System.out.println("UUID = "+ uuid);
            g2d.drawString("Text: " + uuid, 50, 120);

            // Disposes of this graphics context and releases any system resources that it is using.
            g2d.dispose();

            File file = new File("/Users/204071207/QA-16.0-release/images/"+"qaImage"+Integer.toString(i)+".jpg");
            ImageIO.write(bufferedImage, "jpg", file);
        }

    }

}