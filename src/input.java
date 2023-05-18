package GUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class input implements KeyListener{

	private boolean keys[];
	private boolean any;
	
	public input(JFrame frame) {
		frame.addKeyListener(this);
		keys = new boolean [200];
		
		for(int i = 0; i < keys.length; i++)
			keys[i] = false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		any = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		any = false;
	}
	public boolean KeyIsDown(int keycode) {
		return keys[keycode];
	}
	public boolean KeyIsUp(int keycode) {
		return !keys[keycode];
	}
	public boolean anykeypressed() {
		return any;
	}
}
