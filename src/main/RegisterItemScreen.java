package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegisterItemScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int wTF, hTF;
	private String model, brand, color;
	private Double price;
	private String stBrands[] = { "Marcas", "Dell", "Asus", "Samsung", "Lenovo", "Apple", "LG", "Sony", "Intel" };
	private String stColor[] = { "Cores", "Preto", "Branco" };
	private JTextField tfModel, tfPrice;
	private JLabel lblModel, lblBrand, lblColor, lblPrice;
	private JButton btnRegister, btnClear;
	private JComboBox cbBrand, cbColor;

	public RegisterItemScreen() {
		System.out.println("✅ - Tela de Registro de Novos Itens foi INICIADO!");
		initializeComponents();
		defineEvents();
	}
	
	public void initializeComponents() {
		setTitle("🆕 Register a New Item 🆕");
		setLocationRelativeTo(null);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		lblModel = new JLabel("◼️ Modelo");
		lblModel.setFont(new Font("Laksaman", Font.PLAIN, 15));
		lblModel.setBounds(25, 50, 100, 100);
		lblBrand = new JLabel("◼️ Marca");
		lblBrand.setFont(new Font("Laksaman", Font.PLAIN, 15));
		lblModel.setBounds(25, 75, 100, 100);
		lblColor = new JLabel("◼️ Cor ");
		lblColor.setFont(new Font("Laksaman", Font.PLAIN, 15));
		lblModel.setBounds(25, 100, 100, 100);
		lblPrice = new JLabel("🔢 Preço");
		lblPrice.setFont(new Font("Laksaman", Font.PLAIN, 15));
		lblModel.setBounds(25, 115, 100, 100);

		cbBrand = new JComboBox(stBrands);
		cbBrand.setFont(new Font("Laksaman", Font.PLAIN, 15));
		cbColor = new JComboBox(stColor);
		cbColor.setFont(new Font("Laksaman", Font.PLAIN, 15));

		tfModel = new JTextField();
		tfModel.setFont(new Font("Laksaman", Font.PLAIN, 15));
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Laksaman", Font.PLAIN, 15));

		btnRegister = new JButton("Registrar");
		btnRegister.setFocusable(false);
		btnClear = new JButton("Limpar");
		btnClear.setFocusable(false);
		
		add(lblModel);
		add(lblBrand);
		add(lblColor);
		add(lblPrice);

	}

	public void defineEvents() {
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (model != null || brand != null || color != null || price != null) {
						model = tfModel.getText();
						brand = (String) cbBrand.getSelectedItem();
						color = (String) cbColor.getSelectedItem();
						price = Double.parseDouble(tfPrice.getText());

						JOptionPane.showMessageDialog(null, "Item adicionado ao Banco de Dados", "✅ Sucesso!",
								JOptionPane.INFORMATION_MESSAGE);

					} else
						JOptionPane.showMessageDialog(null, "Preencha os Dados requisitados pelo Banco de Dados",
								" ⚠️ Preencha os Dados!", JOptionPane.ERROR_MESSAGE);

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo deu Errado, confira o console", "❌ Falha!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfModel.setText("");
				tfPrice.setText("");
			}
		});
	}
}
