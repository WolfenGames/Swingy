package za.co.julianwolf.graphics;

import static javax.swing.WindowConstants.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyGui{
	JFrame frame;

	public MyGui()
	{
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	public void Show()
	{
		frame.setVisible(true);
	}

	public void Hide()
	{
		frame.setVisible(false);
	}

	public void ShowDialog(String someVal, String title)
	{
		JOptionPane.showConfirmDialog(frame, someVal, title, 0);
	}

	public boolean YNDialog(String someVal, String title)
	{
		return ((JOptionPane.showConfirmDialog(frame, someVal, title, 1) == 1) ? false : true);
	}
}
