/* 
 * Copyright (C) 2015 UACH
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

import mx.uach.fing.chip8.Keyboard;
import mx.uach.fing.chip8.Memory;
import mx.uach.fing.chip8.OPCode;
import mx.uach.fing.chip8.Register;
import mx.uach.fing.chip8.Stack;
import mx.uach.fing.chip8.VRAM;

/**
 * Fx29 - LD F, Vx Set I = location of sprite for digit Vx.
 *
 * The value of I is set to the location for the hexadecimal sprite
 * corresponding to the value of Vx.
 *
 * Programs may also refer to a group of sprites representing the hexadecimal
 * digits 0 through F. These sprites are 5 bytes long, or 8x5 pixels. The data
 * should be stored in the interpreter area of Chip-8 memory (0x000 to 0x1FF).
 * Below is a listing of each character's bytes, in binary and hexadecimal:
 *
 * @author UACH <http://fing.uach.mx>
 */
public class LoadFontVxInstruction implements Instruction {

    @Override
    public void execute(OPCode opcode, Memory memory, VRAM vram, Stack stack, Register register, Keyboard keyboard) {
        int x = opcode.getX();

        int vx = register.get(x);

        vx = Memory.FONT_INIT + vx * 5;

        register.setRegisterI(vx);
    }
}
