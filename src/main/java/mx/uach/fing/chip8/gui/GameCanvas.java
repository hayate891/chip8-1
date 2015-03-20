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
package mx.uach.fing.chip8.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import mx.uach.fing.chip8.VRAM;

/**
 *
 * @author Luis Chávez
 */
public class GameCanvas extends JComponent {

    /**
     * Buffer donde almacenar la informacion de video actual.
     */
    private final BufferedImage screen = new BufferedImage(VRAM.SCREEN_WIDTH * 10, VRAM.SCREEN_HEIGHT * 10, BufferedImage.TYPE_USHORT_GRAY);
    /**
     * Instancia de la memoria de vidoe del chip actual.
     */
    private VRAM vram;

    public GameCanvas() {
    }

    public GameCanvas(VRAM vram) {
        this.vram = vram;
    }

    /**
     * Establece la instancia de la memoria de video actual.
     *
     * @param vram memoria de video.
     */
    public void setVram(VRAM vram) {
        this.vram = vram;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (null == this.vram) {
            return;
        }

        int[] buffer = this.vram.getBuffer();
        for (int i = 0; i < buffer.length; i++) {
            int x = VRAM.toPointX(i);
            int y = VRAM.toPointY(i);
            int pixel = buffer[i];

            Graphics2D graphics = this.screen.createGraphics();
            graphics.setColor(0 == pixel ? Color.BLACK : Color.WHITE);
            graphics.fillRect(x * 10, y * 10, 10, 10);
        }

        g.drawImage(this.screen, 0, 0, null);
    }
}
