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
package mx.uach.fing.chip8.instruction;

import mx.uach.fing.chip8.Chip8;
import mx.uach.fing.chip8.OPCode;

/**
 * 9xy0 - SNE Vx, Vy Skip next instruction if Vx != Vy.
 *
 * The values of Vx and Vy are compared, and if they are not equal, the program
 * counter is increased by 2.
 *
 * @author Luis Chávez
 */
public class SkipNotEqualVxVyInstruction implements Instruction {

    @Override
    public void execute(OPCode opcode, Chip8 chip8) {
        int x = opcode.getX();
        int y = opcode.getY();

        int vx = chip8.register.get(x);
        int vy = chip8.register.get(y);

        if (vx != vy) {
            chip8.register.incrementPC();
        }
    }
}
