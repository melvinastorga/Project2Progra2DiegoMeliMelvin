package InterfaceMosaic;

import file.loadAndSaveData;
import domain.SaveData;
import java.awt.AWTException;
import logic.LogicMethods;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.UnsupportedLookAndFeelException;
import domain.MosaicPanel;
import domain.ImagePanel;
import java.awt.Color;
import java.awt.FontFormatException;

/**
 * Clase donde se crean los metodos necesarios para la creacion de la interfaz
 * grafica
 *
 *
 * @author DiegoVega, Melissa Ramirez, Melvin Astorga
 * @version 1.0
 */


public class InterfacePaintingMosaic extends javax.swing.JFrame {

    boolean cambiaPosicion;
    int size;
    int counter = 0;
    ImagePanel m;
    static MosaicPanel c;
    int Cells;

    /**
     * Constructor de la clase para instanciar nuevas ventanas.
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    public InterfacePaintingMosaic() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        initComponents();

        LogicMethods sv = new LogicMethods();
        setLocationRelativeTo(null);
        loadAndSaveData load = new loadAndSaveData();
        if ((SaveData) load.load("saveData.obj") != null) {

            SaveData data = (SaveData) load.load("saveData.obj");
            int cellsSaved = data.getCellsQuantity();

            BufferedImage loadImage = ImageIO.read(new File("saveImage.png"));
            BufferedImage newimage = sv.resize(580, 580, loadImage);
            BufferedImage[][] insertMatriz = sv.ImagePieces(newimage, cellsSaved, cellsSaved);
            m = new ImagePanel(cellsSaved, cellsSaved, insertMatriz, newimage);

            BufferedImage loadIProyect = ImageIO.read(new File("savedProyect.png"));
            BufferedImage proyect = sv.resize(585,585, loadIProyect);
            BufferedImage[][] insertMatriz2 = sv.ImagePieces(proyect, cellsSaved, cellsSaved);
            c = new MosaicPanel(cellsSaved, cellsSaved, insertMatriz, newimage, insertMatriz2);
            c.quitLines(true);
            tfd_QuantityCells.setEnabled(true);
            pnl_Image.add(m);
            m.repaint();
            pbl_Mosaic.add(c);
            c.repaint();
        } else {
            System.out.println("no hay archivo");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        btn_LoadImage = new javax.swing.JButton();
        btn_SaveMosaic = new javax.swing.JButton();
        tfd_QuantityCells = new javax.swing.JTextField();
        lbl_LoadImage = new javax.swing.JLabel();
        lbl_QuantityCells = new javax.swing.JLabel();
        lbl_Image = new javax.swing.JLabel();
        lbl_Mosaic = new javax.swing.JLabel();
        pnl_Image = new javax.swing.JPanel();
        pbl_Mosaic = new javax.swing.JPanel();
        tfd_newImageSize = new javax.swing.JTextField();
        lbl_newImageSize = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mni_cabeza = new javax.swing.JMenuBar();
        mni_NewProject = new javax.swing.JMenu();
        mni_TurnLeft = new javax.swing.JMenu();
        mni_TurnRight = new javax.swing.JMenu();
        mni_Flip = new javax.swing.JMenu();
        mni_TurnHead = new javax.swing.JMenu();
        mni_BlackWhite = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        mni_SaveProject = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Mongolian Baiti", 3, 18)); // NOI18N
        setForeground(new java.awt.Color(0, 153, 153));
        setLocation(new java.awt.Point(10, 10));
        setName("window"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        btn_LoadImage.setBackground(new java.awt.Color(153, 0, 0));
        btn_LoadImage.setFont(new java.awt.Font("Mongolian Baiti", 1, 14)); // NOI18N
        btn_LoadImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-búsqueda-30.png"))); // NOI18N
        btn_LoadImage.setText("Load ");
        btn_LoadImage.setPreferredSize(new java.awt.Dimension(85, 32));
        btn_LoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoadImageActionPerformed(evt);
            }
        });

        btn_SaveMosaic.setBackground(new java.awt.Color(153, 0, 0));
        btn_SaveMosaic.setFont(new java.awt.Font("Mongolian Baiti", 1, 14)); // NOI18N
        btn_SaveMosaic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-abrir-carpeta-26.png"))); // NOI18N
        btn_SaveMosaic.setText("Save");
        btn_SaveMosaic.setPreferredSize(new java.awt.Dimension(91, 35));
        btn_SaveMosaic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveMosaicActionPerformed(evt);
            }
        });

        tfd_QuantityCells.setBackground(new java.awt.Color(153, 0, 0));

        lbl_LoadImage.setFont(new java.awt.Font("Mongolian Baiti", 1, 16)); // NOI18N
        lbl_LoadImage.setForeground(new java.awt.Color(255, 255, 255));
        lbl_LoadImage.setText("Load image");

        lbl_QuantityCells.setFont(new java.awt.Font("Mongolian Baiti", 1, 16)); // NOI18N
        lbl_QuantityCells.setForeground(new java.awt.Color(255, 255, 255));
        lbl_QuantityCells.setText("Quantity of cells ");

        lbl_Image.setFont(new java.awt.Font("Mongolian Baiti", 1, 22)); // NOI18N
        lbl_Image.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Image.setText("Image");

        lbl_Mosaic.setFont(new java.awt.Font("Mongolian Baiti", 1, 22)); // NOI18N
        lbl_Mosaic.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Mosaic.setText("Mosaic");

        pnl_Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        pnl_Image.setPreferredSize(new java.awt.Dimension(576, 576));

        javax.swing.GroupLayout pnl_ImageLayout = new javax.swing.GroupLayout(pnl_Image);
        pnl_Image.setLayout(pnl_ImageLayout);
        pnl_ImageLayout.setHorizontalGroup(
            pnl_ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        pnl_ImageLayout.setVerticalGroup(
            pnl_ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        pbl_Mosaic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        pbl_Mosaic.setPreferredSize(new java.awt.Dimension(576, 576));

        javax.swing.GroupLayout pbl_MosaicLayout = new javax.swing.GroupLayout(pbl_Mosaic);
        pbl_Mosaic.setLayout(pbl_MosaicLayout);
        pbl_MosaicLayout.setHorizontalGroup(
            pbl_MosaicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        pbl_MosaicLayout.setVerticalGroup(
            pbl_MosaicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        tfd_newImageSize.setBackground(new java.awt.Color(153, 0, 0));
        tfd_newImageSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfd_newImageSizeActionPerformed(evt);
            }
        });

        lbl_newImageSize.setFont(new java.awt.Font("Mongolian Baiti", 1, 16)); // NOI18N
        lbl_newImageSize.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newImageSize.setText("Insert your new image size");

        jLabel6.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 204));
        jLabel6.setText(":");

        mni_cabeza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        mni_NewProject.setBackground(new java.awt.Color(204, 0, 0));
        mni_NewProject.setForeground(new java.awt.Color(255, 255, 255));
        mni_NewProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-automático-48.png"))); // NOI18N
        mni_NewProject.setText("New Project");
        mni_NewProject.setFont(new java.awt.Font("Mongolian Baiti", 1, 16)); // NOI18N
        mni_NewProject.setPreferredSize(new java.awt.Dimension(159, 42));
        mni_NewProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_NewProjectMouseClicked(evt);
            }
        });
        mni_NewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_NewProjectActionPerformed(evt);
            }
        });
        mni_cabeza.add(mni_NewProject);

        mni_TurnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1167966-24.png"))); // NOI18N
        mni_TurnLeft.setText("  ");
        mni_TurnLeft.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        mni_TurnLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_TurnLeftMouseClicked(evt);
            }
        });
        mni_TurnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_TurnLeftActionPerformed(evt);
            }
        });
        mni_cabeza.add(mni_TurnLeft);

        mni_TurnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1167967-24.png"))); // NOI18N
        mni_TurnRight.setText("  ");
        mni_TurnRight.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        mni_TurnRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_TurnRightMouseClicked(evt);
            }
        });
        mni_TurnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_TurnRightActionPerformed(evt);
            }
        });
        mni_cabeza.add(mni_TurnRight);

        mni_Flip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/216090-24.png"))); // NOI18N
        mni_Flip.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        mni_Flip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_FlipMouseClicked(evt);
            }
        });
        mni_Flip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_FlipActionPerformed(evt);
            }
        });
        mni_cabeza.add(mni_Flip);

        mni_TurnHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1167964-24.png"))); // NOI18N
        mni_TurnHead.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        mni_TurnHead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_TurnHeadMouseClicked(evt);
            }
        });
        mni_cabeza.add(mni_TurnHead);

        mni_BlackWhite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/326660-24.png"))); // NOI18N
        mni_BlackWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_BlackWhiteMouseClicked(evt);
            }
        });
        mni_cabeza.add(mni_BlackWhite);

        jMenu4.setText("                                                                                                                                                                                                                                                 ");
        mni_cabeza.add(jMenu4);

        mni_SaveProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2639912-24.png"))); // NOI18N
        mni_SaveProject.setText("Save Project");
        mni_SaveProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mni_SaveProjectMouseClicked(evt);
            }
        });
        mni_cabeza.add(mni_SaveProject);

        setJMenuBar(mni_cabeza);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lbl_QuantityCells)
                                .addGap(18, 18, 18)
                                .addComponent(tfd_QuantityCells, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_LoadImage)
                                .addGap(39, 39, 39)
                                .addComponent(btn_LoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(615, 615, 615)
                                .addComponent(lbl_newImageSize)))
                        .addGap(49, 49, 49)
                        .addComponent(tfd_newImageSize, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btn_SaveMosaic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(lbl_Image)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lbl_Mosaic, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pbl_Mosaic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Image)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Mosaic))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbl_Mosaic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_QuantityCells)
                        .addComponent(tfd_QuantityCells, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_LoadImage)
                        .addComponent(btn_LoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_SaveMosaic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newImageSize)
                    .addComponent(tfd_newImageSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Boton donde se inicia un filechooser para seleccinoar una imagen a cargar
     * el mismo genera a la vez la cuadricula del panel de imagen y del panel
     * del mosaico
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void btn_LoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoadImageActionPerformed
        // TODO add your handling code here:
         
        LogicMethods sv = new LogicMethods();
        try {
            BufferedImage newimage = sv.resize(580, 580, sv.ImageChooser());

            Cells = Integer.parseInt(tfd_QuantityCells.getText());
            BufferedImage[][] insertMatriz = sv.ImagePieces(newimage, Cells, Cells);
            ImageIO.write(newimage, "png", new File("saveImage.png"));
            m = new ImagePanel(Cells, Cells, insertMatriz, newimage);
            SaveData save = new SaveData(Cells);
            loadAndSaveData.save(save, "saveData.obj");

            if (counter == 2) {
                c = new MosaicPanel(Cells, Cells, insertMatriz, newimage, sv.ImagePieces(ImageIO.read(new File("blanco.jpg")), Cells, Cells));
                pbl_Mosaic.add(c);
                c.repaint();

            }
            pnl_Image.removeAll();
            pnl_Image.add(m);
            m.repaint();
            tfd_QuantityCells.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (NumberFormatException num) {
             jLabel6.setText("Insert just numbers!!!");
        }


    }//GEN-LAST:event_btn_LoadImageActionPerformed

    private void mni_NewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_NewProjectActionPerformed

    }//GEN-LAST:event_mni_NewProjectActionPerformed

    /**
     * Boton de menu con el cual se inicializa la interfaz para un nuevo
     * proyecto.
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_NewProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_NewProjectMouseClicked
        // TODO add your handling code here:
        LogicMethods sv = new LogicMethods();
        tfd_QuantityCells.setEnabled(true);
        pnl_Image.removeAll();
        pbl_Mosaic.removeAll();
        repaint();
        counter = 2;
        tfd_QuantityCells.setText("");
        tfd_QuantityCells.setEnabled(true);
        try {
            BufferedImage newProyect = ImageIO.read(new File("blanco.jpg"));
            ImageIO.write(newProyect, "png", new File("savedProyect.png"));
        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mni_NewProjectMouseClicked

    /**
     * Boton con el cual se puede guardar desde un filechooser el mosaico creado
     * con la aplicacion
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void btn_SaveMosaicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveMosaicActionPerformed
        // TODO add your handling code here:
        
        
        
          if(tfd_newImageSize.getText().length()==0){
            jLabel6.setText("Please fill all spaces!!!");
        }else{
        try{
            c.quitLines(false);
          size= Integer.parseInt(tfd_newImageSize.getText());
        LogicMethods sv = new LogicMethods();
        BufferedImage bufImage = new BufferedImage(c.getSize().width, c.getSize().height, BufferedImage.TYPE_INT_RGB);
        c.paint(bufImage.createGraphics());
       sv.saveMosaic(sv.resize(size, size, bufImage));
        }catch(NumberFormatException fne){
            jLabel6.setText("Insert just numbers!!!");
        }catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
    }//GEN-LAST:event_btn_SaveMosaicActionPerformed

    private void mni_FlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_FlipActionPerformed

    }//GEN-LAST:event_mni_FlipActionPerformed

    private void mni_TurnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_TurnLeftActionPerformed

    }//GEN-LAST:event_mni_TurnLeftActionPerformed

    private void mni_TurnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_TurnRightActionPerformed

    }//GEN-LAST:event_mni_TurnRightActionPerformed

    /**
     * Boton de menu, con el cual se puede girar a la izquierda una imagen
     * seleccionada con click derecho del mosaico
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_TurnLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_TurnLeftMouseClicked
        // TODO add your handling code here:
        try {
            cambiaPosicion = true;
            String posicion = "Rotar Derecha";
            c.flipImage(cambiaPosicion, posicion);
            c.ImagePosition();
        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mni_TurnLeftMouseClicked

    /**
     * Boton de menu, con el cual se puede girar a la derecha una imagen
     * seleccionada con click derecho del mosaico
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_TurnRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_TurnRightMouseClicked
        try {
            mni_cabeza.setVisible(true);
            cambiaPosicion = true;
            String posicion = "Rotar Izquierda";
            c.flipImage(cambiaPosicion, posicion);
            c.ImagePosition();
        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mni_TurnRightMouseClicked

    /**
     * Boton de menu, con el cual se puede girar con un flip una imagen
     * seleccionada con click derecho del mosaico
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_FlipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_FlipMouseClicked
        try {
            cambiaPosicion = true;
            String posicion = "Flip";
            c.flipImage(cambiaPosicion, posicion);
            c.ImagePosition();
        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);

        }    }//GEN-LAST:event_mni_FlipMouseClicked

    /**
     * Boton de menu, con el cual se puede girar de cabeza una imagen
     * seleccionada con click derecho del mosaico
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_TurnHeadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_TurnHeadMouseClicked
        try {
            cambiaPosicion = true;
            String posicion = "Rotar Cabeza";
            c.flipImage(cambiaPosicion, posicion);
            c.ImagePosition();
        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mni_TurnHeadMouseClicked

        /**
     * Boton de menu, con el cual se puede guardar un proyecto antes de
     * cerrarlo, para continuarlo posteriormente
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_SaveProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_SaveProjectMouseClicked
        // TODO add your handling code here:
        LogicMethods sv = new LogicMethods();
        c.quitLines(false);
        BufferedImage bufImage = new BufferedImage(c.getSize().width-10, c.getSize().height-10, BufferedImage.TYPE_INT_RGB);
        c.paint(bufImage.createGraphics());
        try {
            BufferedImage newimage = sv.resize(1000, 1000, bufImage);
            ImageIO.write(newimage, "png", new File("savedProyect.png"));

        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mni_SaveProjectMouseClicked

    /**
     * Boton de menu, con el cual se puede cambiar a color Blanco y Negro una
     * imagen seleccionada con click derecho del mosaico
     *
     *
     * @author DiegoVega, Melissa Ramirez, Melvin Astorga
     * @version 1.0
     */

    
    private void mni_BlackWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mni_BlackWhiteMouseClicked
        // TODO add your handling code here:
         try {

            cambiaPosicion=true;
            String posicion = "blackAndWhite";
            c.flipImage(cambiaPosicion, posicion);
            c.ImagePosition();
          

        } catch (IOException ex) {
            Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mni_BlackWhiteMouseClicked

    private void tfd_newImageSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfd_newImageSizeActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tfd_newImageSizeActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfacePaintingMosaic().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(InterfacePaintingMosaic.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LoadImage;
    private javax.swing.JButton btn_SaveMosaic;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JLabel lbl_LoadImage;
    private javax.swing.JLabel lbl_Mosaic;
    private javax.swing.JLabel lbl_QuantityCells;
    private javax.swing.JLabel lbl_newImageSize;
    private javax.swing.JMenu mni_BlackWhite;
    private javax.swing.JMenu mni_Flip;
    private javax.swing.JMenu mni_NewProject;
    private javax.swing.JMenu mni_SaveProject;
    private javax.swing.JMenu mni_TurnHead;
    private javax.swing.JMenu mni_TurnLeft;
    private javax.swing.JMenu mni_TurnRight;
    private javax.swing.JMenuBar mni_cabeza;
    private javax.swing.JPanel pbl_Mosaic;
    private javax.swing.JPanel pnl_Image;
    private javax.swing.JTextField tfd_QuantityCells;
    private javax.swing.JTextField tfd_newImageSize;
    // End of variables declaration//GEN-END:variables

}
