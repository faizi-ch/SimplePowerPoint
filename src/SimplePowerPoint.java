import javafx.scene.*;
import javafx.scene.Cursor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplePowerPoint extends JFrame implements ActionListener
{
	JMenuBar menuBar, textSlideMenuBar, imageSlideMenuBar;
	JMenu newSlideMenu, textSlideMenu,setColorButton;;
	JMenuItem imageSlide, textSlide;
	JMenuItem replaceButton, countWordsButton;
	JButton b1,b2,b3;
	Icon img1,img2,img3;
	JPanel imagePanel;
	JTextArea textArea;
	JFrame textSlideFrame, imageSlideFrame;
	JRadioButtonMenuItem color1,color2,color3;
	ButtonGroup colorGroup;


	SimplePowerPoint()
	{
		super("Simple PowerPoint");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(330,180);
		setSize(600,400);

		newSlideMenu=new JMenu("New Slide");

		menuBar=new JMenuBar();
		menuBar.add(newSlideMenu);
		add(menuBar, BorderLayout.NORTH);

		imageSlide=new JMenuItem("Image Slide");
		//imageSlide.setCursor(Cursor.HAND);
		imageSlide.addActionListener(this);
		textSlide=new JMenuItem("Text Slide");
		textSlide.addActionListener(this);

		newSlideMenu.add(imageSlide);
		newSlideMenu.add(textSlide);





		imagePanel=new JPanel();
		//add(imagePanel,BorderLayout.SOUTH);
		//add(b1);

		textArea=new JTextArea();
		setVisible(true);

	}

	@Override public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==textSlide)
		{
			textSlideFrame=new JFrame("Text Slide");
			textSlideFrame.setDefaultCloseOperation(
					WindowConstants.EXIT_ON_CLOSE);
			textSlideFrame.setLocation(330, 180);
			textSlideFrame.setSize(600, 400);

			textSlideMenu=new JMenu("Actions");

			textSlideMenuBar=new JMenuBar();
			textSlideMenuBar.add(textSlideMenu);
			textSlideFrame.add(textSlideMenuBar, BorderLayout.NORTH);

			replaceButton=new JMenuItem("Replace");
			textSlideMenu.add(replaceButton);
			replaceButton.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					String s = JOptionPane.showInputDialog("Enter text with which you want to replace:");
					textArea.setText(s);
				}
			});

			countWordsButton=new JMenuItem("Count Words");
			textSlideMenu.add(countWordsButton);
			countWordsButton.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					String text=textArea.getText();
					int words = 1;
					for (int i = 0; i < text.length(); i++)
					{
						if (text.charAt(i)==' ')
							words++;
					}

					JOptionPane.showMessageDialog(null, "Number of Words: " + words,"Total Words",JOptionPane.PLAIN_MESSAGE);
				}
			});

			setColorButton=new JMenu("Set Text Color");
			textSlideMenu.add(setColorButton);
			/*setColorButton.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					textArea.setForeground(Color.BLUE);
				}
			});*/

			colorGroup=new ButtonGroup();

			color1=new JRadioButtonMenuItem("Blue");
			colorGroup.add(color1);
			setColorButton.add(color1);
			color1.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					textArea.setForeground(Color.BLUE);
				}
			});

			color2=new JRadioButtonMenuItem("Green");
			colorGroup.add(color2);
			setColorButton.add(color2);
			color2.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					textArea.setForeground(Color.GREEN);
				}
			});

			textSlideFrame.add(textArea, BorderLayout.CENTER);

			textSlideFrame.setVisible(true);

		}
		else if(e.getSource()==imageSlide)
		{
			imageSlideFrame=new JFrame("Image Slide");
			imageSlideFrame.setDefaultCloseOperation(
					WindowConstants.EXIT_ON_CLOSE);
			imageSlideFrame.setLocation(330, 180);
			imageSlideFrame.setSize(600, 400);
			imageSlideFrame.setLayout(new FlowLayout());



			JLabel label=new JLabel();
			/*textSlideMenu=new JMenu("Actions");

			imageSlideMenuBar=new JMenuBar();
			imageSlideMenuBar.add(textSlideMenu);
			imageSlideFrame.add(imageSlideMenuBar, BorderLayout.NORTH);*/

			img1=new ImageIcon(getClass().getResource("img (1).jpg"));
			img2=new ImageIcon(getClass().getResource("img (2).jpg"));
			img3=new ImageIcon(getClass().getResource("img (3).jpg"));
			imageSlideFrame.add(label);
			b1=new JButton("img1");
			imageSlideFrame.add(b1);

			b2=new JButton("img2");
			imageSlideFrame.add(b2);
			b3=new JButton("img3");
			imageSlideFrame.add(b3);
			//b1.setSize(30,20);
			//b1.setBounds(10,20,30,20);
			b1.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					label.setIcon(img1);
				}
			});
			b2.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					label.setIcon(img2);
				}
			});
			b3.addActionListener(new ActionListener()
			{
				@Override public void actionPerformed(ActionEvent e)
				{
					label.setIcon(img3);
				}
			});




			imageSlideFrame.setVisible(true);
		}
	}

	public static void main(String[] args)
	{
		SimplePowerPoint powerPoint=new SimplePowerPoint();
	}
}
