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
 * 6xkk - LD Vx, byte Set Vx = kk.
 *
 * The interpreter puts the value kk into register Vx.
 *
 * @author Luis Chávez
 */
public class LoadVxKKInstruction implements Instruction {

    @Override
    public void execute(OPCode opcode, Chip8 chip8) {
        int x = opcode.getX();
        int b = opcode.getByte();

        chip8.register.set(x, b);
    }
}
