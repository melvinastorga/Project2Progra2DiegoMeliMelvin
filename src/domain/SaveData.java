package domain;

import java.io.Serializable;

/**
 * Clase que se utiliza para guardar datos
 *
 *
 * @author DiegoVega, Melissa Ramirez, Melvin Astorga
 * @version 1.0
 */


public class SaveData implements Serializable{
    
    int cellsQuantity;

    /**
 * Constructor de la clase
 *
 *
 * @author DiegoVega, Melissa Ramirez, Melvin Astorga
 * @version 1.0
 */

    
    public SaveData(int cellsQuantity) {
        this.cellsQuantity = cellsQuantity;
        
    }

    /**
 * Metodos accesores
 *
 *
 * @author DiegoVega, Melissa Ramirez, Melvin Astorga
 * @version 1.0
 */

    
    public int getCellsQuantity() {
        return cellsQuantity;
    }

    public void setCellsQuantity(int cellsQuantity) {
        this.cellsQuantity = cellsQuantity;
    }



    
   
}
