package net.mechgear.geekscraft.geekscraft.Window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cpw.mods.fml.common.FMLCommonHandler;

public class Prompt extends JDialog {

	JLabel jl = null;
	
	public Prompt(String info){
		super((Frame)null,"Wrong",true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Container container = getContentPane();
		jl = new JLabel(info+",详情请联系管理员");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		setBounds(screenSize.width/2-(info.length()*8+20)/2, screenSize.height/2-150/2, info.length()*8+20, 150);
		container.add(jl);
		setVisible(true);
		setAlwaysOnTop(true);
		new FMLCommonHandler().exitJava(0, false);
	}
	
}
