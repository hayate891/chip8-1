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
 * 2nnn - CALL addr Call subroutine at nnn.
 *
 * The interpreter increments the stack pointer, then puts the current PC on the
 * top of the stack. The PC is then set to nnn.
 *
 * @author Luis Chávez
 */
public class CallSubroutineInstruction implements Instruction {

    @Override
    public void execute(OPCode opcode, Chip8 chip8) {
        chip8.stack.push(chip8.register.getPC());

        chip8.register.setPC(opcode.getAddress());
    }
}
