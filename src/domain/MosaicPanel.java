package domain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import logic.LogicMethods;

/**
 * Clase donde se crea el objeto necesario para el panel donde se crea el
 * Mosaico
 *
 *
 * @author DiegoVega, Melissa Ramirez, Melvin Astorga
 * @version 1.0
 */
public class MosaicPanel extends JPanel implements MouseListener {

    /**
     * Constructor de la clase
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */
    public MosaicPanel(int row, int colum, BufferedImage[][] imagePieces, BufferedImage image, BufferedImage[][] screen) throws IOException {
        addMouseListener(this);
        this.setSize(image.getHeight(), image.getHeight());
        this.setVisible(true);
        this.repaint();
        this.imagePieces2 = imagePieces;
        BufferedImage imagePieceSize = imagePieces[0][0];
        this.img = imagePieceSize;
        this.imgtotal = image;
        this.rows = row;
        this.colums = colum;
        matrix = new Rectangle2D[colum][colum];
        this.setSize(imgtotal.getWidth(), imgtotal.getHeight());
        this.temp = screen;

    }
    BufferedImage img2 = ImageIO.read(new File("piece.jpg"));
    BufferedImage img = null;
    BufferedImage imgtemp = null;
    BufferedImage imgtotal = null;
    boolean paintLines = true;
    static int rows;
    static int colums;
    int cordenatesY = 0;
    int cordenatesX = 0;
    int x_position = 0;
    int y_position = 0;
    Rectangle2D[][] matrix = new Rectangle2D[colums][colums];
    static BufferedImage[][] imagePieces2 = new BufferedImage[colums][colums];
    static BufferedImage[][] temp = new BufferedImage[colums][colums];
    static BufferedImage[][] temp2 = new BufferedImage[colums][colums];

    /**
     * Metodo PaintComponent de la clase Graphics
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */
    public void paintComponent(Graphics g) {

        int counter = 0;
        counter++;
        g.toString();
        System.out.println(g.toString());
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawMatrix(g2);

    }

    /**
     * Metodo que dibuja la matriz, segun el numero indicado crea una cuadricula
     * NxN para dividir el area del mosaico
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */
    private void drawMatrix(Graphics2D g2) {

        g2.setColor(Color.black);
        int startX = 0;
        int startY = 0;
        int calculateY = img.getWidth();
        int calculateX = img.getHeight();
        int size = img.getHeight();

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {

                matrix[i][j] = new Rectangle2D.Double(startX+1, startY+1, img.getHeight(), img.getHeight());
                g2.draw(matrix[i][j]);
                BufferedImage imt = temp[i][j];
                g2.drawImage(imt, startX+1, startY+1, img.getHeight(), img.getHeight(), this);
                startX = startX + size;

            }
            startY = startY + size;
            startX = 0;

        }

        if (temp[x_position][y_position] != null) {
            BufferedImage piece = this.temp[x_position][y_position];
            g2.drawImage(piece, cordenatesX, cordenatesY, img.getHeight(), img.getHeight(), this);

        }

        if (paintLines == true) {
            for (int i = 0; i < imgtotal.getWidth(); i++) {
                for (int j = 0; j < imgtotal.getHeight(); j++) {

                    if (calculateX <= j) {

                        g2.drawLine(j, 0, j, getHeight());
                        calculateX = calculateX + img.getHeight();
                    }
                }

                if (calculateY <= i) {

                    g2.drawLine(0, i, getWidth(), i);
                    calculateY = calculateY + img.getWidth();
                }
            }
        }
    }

    boolean flip = false, turnRight = false, turnLeft = false, turnDown = false, black = false;

    ;

     /**
 * Metodo que indica en que posicion girar una imagen 
 * 
 *
 * @author DiegoVega, Melissa Ramirez, Melvin Astorga
 * @version 1.0
 */

    
    public void flipImage(boolean flip, String position) throws IOException {
        if (flip != false && position.equals("Rotar Derecha")) {
            turnRight = true;
        } else if (flip != false && position.equals("Rotar Izquierda")) {
            turnLeft = true;

        } else if (flip != false && position.equals("Rotar Cabeza")) {
            turnDown = true;
        } else if (flip != false && position.equals("Flip")) {
            this.flip = true;
        } else if (flip != false && position.equals("blackAndWhite")) {
            black = true;
        } else {
            this.flip = false;
        }
    }

    public BufferedImage turnRight(BufferedImage sprite) {

        BufferedImage img = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int xx = sprite.getHeight() - 1; xx > 0; xx--) {
            for (int yy = 0; yy < sprite.getWidth(); yy++) {

                img.setRGB(sprite.getWidth() - xx, yy, sprite.getRGB(yy, xx));
            }
        }

        return img;
    }

    public BufferedImage turnLeft(BufferedImage sprite) {

        BufferedImage img = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int xx = sprite.getHeight() - 1; xx > 0; xx--) {
            for (int yy = 0; yy < sprite.getWidth(); yy++) {

                img.setRGB(yy, sprite.getHeight() - xx, sprite.getRGB(xx, yy));
            }
        }

        return img;
    }

    public BufferedImage turnHead(BufferedImage sprite) {

        BufferedImage img = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int xx = sprite.getHeight() - 1; xx > 0; xx--) {
            for (int yy = 0; yy < sprite.getWidth(); yy++) {

                img.setRGB(yy, sprite.getHeight() - xx, sprite.getRGB(yy, xx));
            }
        }

        return img;
    }

    public BufferedImage flip2(BufferedImage sprite) {
        BufferedImage img = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int xx = sprite.getWidth() - 1; xx > 0; xx--) {
            for (int yy = 0; yy < sprite.getHeight(); yy++) {

                img.setRGB(sprite.getWidth() - xx, yy, sprite.getRGB(xx, yy));
            }
        }
        return img;
    }

    LogicMethods sv = new LogicMethods();

    public void ImagePosition() throws IOException {
        BufferedImage img2;

        //imagen que se guardó al dar click derecho en el canvas
        img2 = ImageIO.read(new File("imagenRotate.jpg"));

        if (black != false) {
            img2 = sv.blackAndWhite(img2);
            ImageIO.write(img2, "jpg", new File("imagenRotate.jpg"));
        }
        //estas variables cambian al ser llamadas en el botón, por lo que si se solicita cambiar de posicion reescribe la imagen
        //guardada en memoria por el click izquierdo con la transformación realizada.
        if (flip != false) {
            // metodo que hace "flip" a la imagen
            img2 = flip2(img2);
            // se reescribe la imagen
            ImageIO.write(img2, "jpg", new File("2.jpg"));
        } else if (turnDown != false) {
            //metodo que le da la vuelta hacia abajo a la imagen
            img2 = turnHead(img2);
            //se reescribe la imagen
            ImageIO.write(img2, "jpg", new File("2.jpg"));
        } else if (turnLeft != false) {
            //metodo que gira la imagen a la izquierda
            img2 = turnLeft(img2);
            // se reescribe la imagen
            ImageIO.write(img2, "jpg", new File("2.jpg"));
        } else if (turnRight != false) {
            // metodo que gira a la derecha la imagen
            img2 = turnRight(img2);
            // resscribe la imagen
            ImageIO.write(img2, "jpg", new File("2.jpg"));
        }
        if (black != false) {

            sv.blackAndWhite(img2);

            ImageIO.write(img2, "jpg", new File("2.jpg"));
        }

        // se vuelven a poner todas las variables en falso, para que la próxima vez, al tocar el boton con alguna 
        //transformación, solo ingrese en el if de la acción indicada
        flip = false;
        turnLeft = false;
        turnDown = false;
        turnRight = false;
        black = false;
        // recorre la matriz del canvas
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].contains(x, y)) {
                    // aqui pinta la imagen con la transformacion realizada
                    sv.pieceTOtranfer(img2, temp, i, j);
                    x_position = i;
                    y_position = j;
                    cordenatesX = (int) matrix[i][j].getMinX();
                    cordenatesY = (int) matrix[i][j].getMinY();
                    img2 = null;
                } else {
                    BufferedImage img3 = ImageIO.read(new File("blanco.jpg"));
                    if (temp[i][j] == null) {
                        sv.pieceTOtranfer(img3, temp, i, j);
                    }
                }
            }
            // repinta el canvas para que se pueda ver el nuevo cambio
            repaint();
        }

    }

    public void quitLines(boolean quit) {

        paintLines = quit;

    }

    int x = 0;
    int y = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (SwingUtilities.isLeftMouseButton(e)) {

            System.out.println(x + "x" + y + "y");

            try {
                BufferedImage img2 = ImageIO.read(new File("piece.jpg"));

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[i][j].contains(x, y)) {

                            sv.pieceTOtranfer(img2, temp, i, j);
                            x_position = i;
                            y_position = j;
                            cordenatesX = (int) matrix[i][j].getMinX();
                            cordenatesY = (int) matrix[i][j].getMinY();
                            x = 0;
                            y = 0;
                            img2 = null;
                            BufferedImage img3 = ImageIO.read(new File("blanco.jpg"));
                            ImageIO.write(img3, "jpg", new File("imagenRotate.jpg"));
                        } else {
                            BufferedImage img3 = ImageIO.read(new File("blanco.jpg"));

                            if (temp[i][j] == null) {
                                sv.pieceTOtranfer(img3, temp, i, j);
                            }
                        }
                    }
                    repaint();
                }
            } catch (IOException ex) {
                Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (SwingUtilities.isRightMouseButton(e)) {

            int x1 = e.getX();
            int y1 = e.getY();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j].contains(x1, y1)) {
                        BufferedImage rotate = null;
                        rotate = temp[i][j];
                        try {

                            ImageIO.write(rotate, "jpg", new File("imagenRotate.jpg"));
                        } catch (IOException ex) {
                            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        x1 = 0;
                        y1 = 0;
                        img2 = null;

                    }
                }

                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
