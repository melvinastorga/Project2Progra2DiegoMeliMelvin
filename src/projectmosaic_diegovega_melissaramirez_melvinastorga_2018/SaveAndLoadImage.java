package projectmosaic_diegovega_melissaramirez_melvinastorga_2018;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;


 /**
     * Clase donde se carga o guarda
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */


public class SaveAndLoadImage {

    /**
     * Corta una imagen en varias imagenes dependiendo del tamaÃ±o de la matriz o cuadricula
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    // Corta la imagen segun la cantidad de celdas que requiera el usuario
    public BufferedImage[][] ImagePieces(BufferedImage imgFile, int rows, int columns) throws IOException {

        int smallWidth = (int) imgFile.getWidth() / rows;
        int smallHeight = (int) imgFile.getHeight() / columns;

        BufferedImage[][] smallImages = new BufferedImage[rows][columns];

        int count = 0;
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                smallImages[x][y] = imgFile.getSubimage(x * smallWidth, y
                        * smallHeight, smallWidth, smallHeight);

            }

        }
        return smallImages;
    }

    /**
     * Metodo que selecciona una imagen mediante un filechooser
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    //Seleciona la imagen en la imagen desde el escritorio para convertirla en un bufferedimage
    //y asi  realizar los cambios nesesarios
    public BufferedImage ImageChooser() throws IOException {

        BufferedImage bfimg = null;
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "PNG", "png", "jpeg", "JPEG", "pgn");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            File selected = file.getSelectedFile();
            String path = selected.getAbsolutePath();

            bfimg = ImageIO.read(selected);
           
            return bfimg;
        } else if (result == JFileChooser.CANCEL_OPTION) {

            System.out.println("No file selected");
        }

        return bfimg;
    }

    /**
     * Metodo que guarda el mosaico creado mediante un filechooser
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public void saveMosaic(BufferedImage mosaic) throws IOException, AWTException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        BufferedImage bf_img;

        JFileChooser fl_chooser = new JFileChooser();
        if (fl_chooser.showSaveDialog(null) == fl_chooser.APPROVE_OPTION) {

            File fl = fl_chooser.getSelectedFile();

            try {
                ImageIO.write(mosaic, "jpg", new File(fl.getPath() + ".jpg"));

            } catch (IOException ioe) {

                ioe.printStackTrace();

            }

        }

    }

    /**
     * Metodo que redefine la dimensiÃ³n de una imagen para poder trabajarla
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public BufferedImage resize(int newW, int newH, BufferedImage ImageToConverse) throws IOException {
        BufferedImage imageSlected = ImageToConverse;

        int w = imageSlected.getWidth();
        int h = imageSlected.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, imageSlected.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(imageSlected, 0, 0, newW, newH, 0, 0, w, h, null);
        
//        g.dispose();
        return bufim;
    }

    /**
     * Metodo que indica cual parte de imagen se va a trabajar
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public static void pieceTOtranfer(BufferedImage piece, BufferedImage[][] tempint, int positionX, int positionY) {
        
        tempint[positionX][positionY] = piece;
        
    }

    /**
     * Metodo que cmabia el color de una imagen a blanco y negro
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public BufferedImage blackAndWhite(BufferedImage img_invertColor) {
        int color = 0;
       BufferedImage imgblackandWhite = img_invertColor;

        for (int i = 0; i < imgblackandWhite.getHeight(); i++) {
            for (int j = 0; j < imgblackandWhite.getWidth(); j++) {

                color = img_invertColor.getRGB(i, j);
                int a = (color >> 24) & 0xff;
                int r = (color >> 16) & 0xff;
                int g = (color >> 8) & 0xff;
                int b = color & 0xff;
                int avg = (r+g+b)/3;
                color = (a<<24) | (avg<<16) | (avg<<8) | avg;
                img_invertColor.setRGB(i, j, color);
            }
        }


        return imgblackandWhite;
    }

}
