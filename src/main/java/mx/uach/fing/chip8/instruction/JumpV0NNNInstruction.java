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
 * Bnnn - JP V0, addr Jump to location nnn + V0.
 *
 * The program counter is set to nnn plus the value of V0.
 *
 * @author Luis Chávez
 */
public class JumpV0NNNInstruction implements Instruction {

    @Override
    public void execute(OPCode opcode, Chip8 chip8) {
        int address = opcode.getAddress();
        int v0 = chip8.register.get(0);

        chip8.register.setPC(v0 + address);
    }
}
