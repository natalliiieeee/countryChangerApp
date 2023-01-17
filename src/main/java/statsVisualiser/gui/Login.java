package statsVisualiser.gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.simple.JSONObject;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.json.simple.JSONArray;

import java.io.FileReader;
import org.json.simple.parser.JSONParser;

public class Login {
	private JFrame frame;
	private JTextField textUsername;
	private JTextField textPassword;
	private JSONObject obj;
	private JButton btnNewButton;
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JFrame frame2;
	
	//private static JFrame frame2;
	JSONArray jrr=new JSONArray();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(179, 30, 61, 16);
		frame.getContentPane().add(lblLogin);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(59, 85, 75, 28);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(59, 147, 75, 16);
		frame.getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(179, 86, 130, 26);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obj = new JSONObject();
				jrr= new JSONArray();
				Object ob= null;
				JSONParser Jp = new JSONParser();
				try {
					FileReader file = new FileReader("\\Workspace\\3311Assignment\\src\\main\\resources\\UserData.json");
					ob=Jp.parse(file);
					
					jrr=(JSONArray) ob;
					file.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "invalid username/password");
				}
				obj.put("Username",textUsername.getText());
				obj.put("Password",textPassword.getText());
//				JOptionPane.showMessageDialog(null,jrr);
				if(obj.equals(jrr.get(0))) {
//					JOptionPane.showMessageDialog(null,"show the next page");
					frame2 = MainUI.getInstance();
					frame2.setPreferredSize(new Dimension(1230, 700));
					frame2.pack();
					frame2.setVisible(true);
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"invalid username/password");
				}
			}
		});
		btnNewButton.setBounds(163, 213, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		textPassword = new JTextField();
		textPassword.setBounds(179, 142, 130, 26);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
	
		
		
	}
	public JTextField getTextUsername() {
		return this.textUsername;
	}
	public JTextField getTextPassword() {
		return this.textPassword;
	}
	public JSONObject getObj() {
		return this.obj;
	}
	public JSONArray getJrr() {
		return this.jrr;
	}
	public JButton getBtnNewButton() {
		return this.btnNewButton;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}
	public JFrame getLoginUI() {
		return this.frame;
	}
	public JFrame getMainUI() {
		return this.frame2;
	}

}
