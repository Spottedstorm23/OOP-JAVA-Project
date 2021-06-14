package Movement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
            Variables.moveUp = true;
        } else if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S) {
            Variables.moveDown = true;
        }  else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
            Variables.moveLeft = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
            Variables.moveRight = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
            Variables.moveUp = false;
        } else if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S) {
            Variables.moveDown = false;
        }  else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
            Variables.moveLeft = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
            Variables.moveRight = false;

        }
    }
}

