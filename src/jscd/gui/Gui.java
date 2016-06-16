package jscd.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import jscd.treegen.ReadFile;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import java.awt.Scrollbar;

public class Gui {

	public JFrame frame;
	private JTextField folderPath;
	/**
	 * @wbp.nonvisual location=504,59
	 */
	private final JFileChooser fileChooser = new JFileChooser();
	private JLabel lblAbstractSyntaxTree;
	private JTextArea astPath;


	
	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fileChooser.setCurrentDirectory(new java.io.File("user.home"));
				fileChooser.setDialogTitle("This is a JFileChooser");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					folderPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
					
					
					
					try {
						ReadFile readfile = new ReadFile();
						astPath.setText(readfile.reading(fileChooser.getSelectedFile()));
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
				});
	
		btnBrowse.setBounds(10, 31, 89, 23);
		frame.getContentPane().add(btnBrowse);
		
		folderPath = new JTextField();
		folderPath.setBounds(109, 32, 315, 20);
		frame.getContentPane().add(folderPath);
		folderPath.setColumns(10);
		
		JLabel lblFolder = new JLabel("Folder");
		lblFolder.setBounds(107, 11, 46, 14);
		frame.getContentPane().add(lblFolder);
		
		lblAbstractSyntaxTree = new JLabel("Abstract Syntax Tree");
		lblAbstractSyntaxTree.setBounds(109, 65, 139, 14);
		frame.getContentPane().add(lblAbstractSyntaxTree);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 94, 315, 229);
		frame.getContentPane().add(scrollPane);
		
		astPath = new JTextArea();
		scrollPane.setViewportView(astPath);
		astPath.setColumns(10);
		
		
		
	}
}
