/* 
 * Copyright (C) 2015 UACH <http://fing.uach.mx>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mx.uach.fing.chip8;

/**
 *
 * @author Luis Chávez
 */
public class Memory {

    // Fuente 5b en hexadecimal.
    public static final char[] FONT = new char[]{
        0x40, //  # 
        0xA0, // # #
        0xA0, // # #
        0xA0, // # #
        0xE0, // ###

        0x80, // #
        0x80, // #
        0x80, // #
        0x80, // #
        0x80, // #

        0x40, //  # 
        0xA0, // # #
        0x20, //   #
        0x40, //  # 
        0x60, //  ##

        0x40, //  # 
        0x20, //   #
        0x40, //  # 
        0x20, //   #
        0xE0, // ###

        0x20, //   #
        0x60, //  ##
        0xA0, // # #
        0xE0, // ###
        0x20, //   #

        0x60, //  ##
        0x80, // #  
        0x60, //  ##
        0x20, //   #
        0xC0, // ## 

        0x20, //   #
        0xC0, // ## 
        0xA0, // # #
        0xA0, // # #
        0xE0, // ###

        0x60, //  ##
        0xA0, // # #
        0x20, //   #
        0x40, //  # 
        0x40, //  # 

        0xE0, // ###
        0xA0, // # #
        0x40, //  # 
        0xA0, // # #
        0xE0, // ###

        0x40, //  # 
        0xA0, // # #
        0xA0, // # #
        0x60, //  ##
        0x40, //  # 

        0x20, //   # 
        0x20, //   # 
        0x50, //  # #
        0xB0, // # ##
        0x90, // #  #

        0xE0, // ### 
        0x90, // #  #
        0x70, //  ###
        0x90, // #  #
        0xF0, // ####

        0x30, //   ##
        0xC0, // ##  
        0x80, // #   
        0x80, // #   
        0x70, //  ###

        0xE0, // ###  
        0x98, // #  ##
        0x88, // #   #
        0x88, // #   #
        0xF0, // #### 

        0xF0, // ####
        0x80, // #   
        0x60, //  ## 
        0x80, // #   
        0xF0, // ####

        0xF0, // ####
        0x80, // #   
        0x60, //  ## 
        0x80, // #   
        0x80, // #   
    };

    // Fuente 10b en hexadecimal.
    public static char[] EXTENDED_FONT = new char[]{
        0x70, //  ### 
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x70, //  ### 

        0x40, //  # 
        0xC0, // ## 
        0x40, //  # 
        0x40, //  # 
        0x40, //  # 
        0x40, //  # 
        0x40, //  # 
        0x40, //  # 
        0xE0, // ###

        0x70, //  ### 
        0x88, // #   #
        0x08, //     #
        0x08, //     #
        0x10, //    # 
        0x10, //    # 
        0x20, //   #  
        0x48, //  #  #
        0xF8, // #####

        0x70, //  ### 
        0x88, // #   #
        0x08, //     #
        0x10, //    # 
        0x30, //   ## 
        0x08, //     #
        0x08, //     #
        0x08, //     #
        0xF0, // #### 

        0x08, //     # 
        0x18, //    ## 
        0x28, //   # # 
        0x28, //   # # 
        0x48, //  #  # 
        0x88, // #   # 
        0xFC, // ######
        0x08, //     # 
        0x08, //     # 

        0x38, //   ###
        0x20, //   #  
        0x60, //  ##  
        0x10, //    # 
        0x08, //     #
        0x08, //     #
        0x08, //     #
        0x10, //    # 
        0xE0, // ###  

        0x18, //    ##
        0x20, //   #  
        0x40, //  #   
        0xB0, // # ## 
        0xC8, // ##  #
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x70, //  ### 

        0xF8, // #####
        0x88, // #   #
        0x10, //    # 
        0x10, //    # 
        0x10, //    # 
        0x20, //   #  
        0x20, //   #  
        0x20, //   #  
        0x40, //  #   

        0x70, //  ### 
        0x88, // #   #
        0x88, // #   #
        0x50, //  # # 
        0x20, //   #  
        0x50, //  # # 
        0x88, // #   #
        0x88, // #   #
        0x70, //  ### 

        0x70, //  ### 
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x88, // #   #
        0x78, //  ####
        0x10, //    # 
        0x20, //   #  
        0xC0, // ##   

        0x08, //     #    
        0x08, //     #    
        0x14, //    # #   
        0x14, //    # #   
        0x22, //   #   #  
        0x3E, //   #####  
        0x41, //  #     # 
        0x41, //  #     # 
        0xE3, // ###   ###

        0xFC, // ###### 
        0x42, //  #    #
        0x42, //  #    #
        0x42, //  #    #
        0x7C, //  ##### 
        0x42, //  #    #
        0x42, //  #    #
        0x42, //  #    #
        0xFC, // ###### 

        0x3A, //   ### #
        0x46, //  #   ##
        0x82, // #     #
        0x80, // #      
        0x80, // #      
        0x80, // #      
        0x82, // #     #
        0x44, //  #   # 
        0x38, //   ###  

        0xFC, // ######  
        0x42, //  #    # 
        0x41, //  #     #
        0x41, //  #     #
        0x41, //  #     #
        0x41, //  #     #
        0x41, //  #     #
        0x42, //  #    # 
        0xFC, // ######  

        0xFC, // ###### 
        0x44, //  #   # 
        0x40, //  #     
        0x48, //  #  #  
        0x78, //  ####  
        0x48, //  #  #  
        0x40, //  #     
        0x42, //  #    #
        0xFC, // ###### 

        0xFC, // ######
        0x44, //  #   #
        0x40, //  #    
        0x48, //  #  # 
        0x78, //  #### 
        0x48, //  #  # 
        0x40, //  #    
        0x40, //  #    
        0xE0, // ###   
    };

    // Tamano de la memoria en bytes.
    public static final int MEMORY_SIZE = 4096;

    // Tamano maximo de los programas.
    public static final int MAX_PROGRAM_SIZE = 3584;

    // Inicio de la memoria.
    public static final int MEMORY_INIT = 0x0;

    // Inicio de la fuente, 0x50 (80).
    public static final int FONT_INIT = 0x50;

    // Inicio de la fuente extendida, 0x9C (156).
    public static final int EXTENDED_FONT_INIT = 0x9C;

    // Reservada para el interprete, 0x1FF (511).
    public static final int INTERPRETER_END = 0x1FF;

    // Inicio de los programas en memoria, 0x200 (512).
    public static final int PROGRAM_INIT = 0x200;

    // Fin de los programas en memoria, 0xFFF (4095).
    public static final int PROGRAM_END = 0xFFF;

    // Arreglo que representa la memoria en bytes.
    private final int[] ram;

    // Indice de la primera instruccion del programa.
    private int programIndex;

    public Memory() {
        this.ram = new int[MEMORY_SIZE];

        this.loadFont();
    }

    /**
     * Carga la fuente en memoria.
     */
    private void loadFont() {
        // Copia la fuente en memoria.
        for (int i = 0; i < FONT.length; i++) {
            this.ram[FONT_INIT + i] = FONT[i] & 0xFF;
        }
        for (int i = 0; i < EXTENDED_FONT.length; i++) {
            this.ram[EXTENDED_FONT_INIT + i] = EXTENDED_FONT[i] & 0xFFFF;
        }
    }

    /**
     * Obtiene el indice de la primera instruccion del programa.
     *
     * @return indice de la primera instruccion.
     */
    public int getProgramIndex() {
        return this.programIndex;
    }

    /**
     * Carga una ROM en memoria.
     *
     * @param data bytes a cargar.
     * @throws MemoryLoadException si el tamano de la ROM es demasiado grande.
     */
    public void load(byte[] data) throws MemoryLoadException {
        // Verifica que el tamano de la ROM no sea mayor al tamano maximo de los programas.
        if (MAX_PROGRAM_SIZE < data.length) {
            throw new MemoryLoadException(String.format("El tamano de la ROM es demasiado grande, el tamano maximo es: %d", MAX_PROGRAM_SIZE));
        }

        // Establece el indice del programa.
        this.programIndex = PROGRAM_INIT;

        // Almacena la ROM en memoria.
        int currentIndex = this.programIndex;
        for (int i = 0; i < data.length; i++) {
            this.ram[currentIndex++] = data[i];
        }
    }

    /**
     * Lee un byte de memoria almacenado en la direccion especificada.
     *
     * @param address direccion de la cual leer.
     * @return byte almacenado.
     */
    public int read(int address) throws InvalidMemoryAddressException {
        // Verifica si la direccion es valida.
        if (MEMORY_INIT > address || PROGRAM_END < address) {
            throw new InvalidMemoryAddressException(String.format("La direccion 0x%x no es valida", address));
        }

        return this.ram[address];
    }

    /**
     * Almacena un valor en memoria.
     *
     * @param address direccion donde almacenar el valor.
     * @param b valor a almacenar.
     * @throws InvalidMemoryAddressException si la direccion de memoria no es
     * valida.
     */
    public void set(int address, int b) throws InvalidMemoryAddressException {
        // Verifica si la direccion es valida.
        if (MEMORY_INIT > address || PROGRAM_END < address) {
            throw new InvalidMemoryAddressException(String.format("La direccion 0x%x no es valida", address));
        }

        this.ram[address] = b & 0xFF;
    }

    /**
     * Lee una instruccion de la memoria, cada instruccion tiene un tamano de 2
     * bytes.
     *
     * @param address direccion de la cual leer.
     * @return instruccion almacenada.
     * @throws InvalidMemoryAddressException si la direccion de memoria no es
     * valida.
     */
    public OPCode readInstruction(int address) throws InvalidMemoryAddressException {
        // Verifica si la direccion es valida.
        if (this.programIndex > address || PROGRAM_END < address) {
            throw new InvalidMemoryAddressException(String.format("La direccion 0x%x no es valida", address));
        }

        int b1 = this.read(address);
        int b2 = this.read(address + 1);

        // Se combinan los dos bytes en uno solo, formando una instruccion de 2 bytes.
        int instr = (b1 << 0x8) | (b2 & 0xFF);

        return new OPCode(instr);
    }
}
