package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Screen extends JFrame {
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu optionsMenu, adminMenu;
	private JMenuItem  exitItem, registerItem;
	
	private String cbOptions[] = {"Model", "Brand", "Color", "Size", "Price"};
	
//	Model  -> Modelo
//	Brand  -> Marca
//	Color   -> Cor
//	Size      -> Tamanho
//	Price    -> Preco
	
	private JPanel bodyPanel, footerPanel;
	private JButton btnRefresh, btnNext, btnPrevious;
	private JLabel lbl1;
	private JComboBox cbFilter;
	
	public Screen() {
		initializeComponents();
		defineEvents();
		titleChanger();
	}
	
	private void titleChanger()  {
		System.out.println("✅ - Title Changer Iniciado na TELA INICIAL!");
		while (0 != 1) {		
			try {
				setTitle("🖥️ Pc Store 🖥️");
				Thread.sleep(6000);
				setTitle("🪙 Best place to buy your PC 🪙");
				Thread.sleep(4000);
				setTitle("💽 Now with Database Connection! 💽");
				Thread.sleep(4000);
				setTitle("👤 Made By: Felipe Rodrigues 👤");
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}

	public void initializeComponents() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setJMenuBar(menuBar);
		setVisible(true);
		
		optionsMenu = new JMenu("Opções");
		adminMenu = new JMenu("Admin");
		
		exitItem = new JMenuItem("Sair");
		registerItem = new JMenuItem("Registrar Novo Produto");
		
		optionsMenu.add(adminMenu);
		adminMenu.add(registerItem);
		optionsMenu.addSeparator();
		optionsMenu.add(exitItem);
		
		menuBar.add(optionsMenu);
	}
	
	public void defineEvents() {
		registerItem.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterItemScreen();
			}
		});
		
		exitItem.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
