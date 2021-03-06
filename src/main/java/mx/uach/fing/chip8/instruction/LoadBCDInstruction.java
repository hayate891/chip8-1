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
 * Fx33 - LD B, Vx Store BCD representation of Vx in memory locations I, I+1,
 * and I+2.
 *
 * The interpreter takes the decimal value of Vx, and places the hundreds digit
 * in memory at location in I, the tens digit at location I+1, and the ones
 * digit at location I+2.
 *
 * @author Luis Chávez
 */
public class LoadBCDInstruction implements Instruction {

    @Override
    public void execute(OPCode opcode, Chip8 chip8) {
        int x = opcode.getX();

        int i = chip8.register.getRegisterI();

        int vx = chip8.register.get(x);

        chip8.memory.set(i, vx / 100);
        chip8.memory.set(i + 1, (vx / 10) % 10);
        chip8.memory.set(i + 2, vx % 10);
    }
}
