package dictionary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Dic {
    private JFrame frame = null;
    private JPanel panel = null;
    private JRadioButton eng = null;
    private JRadioButton mon = null;
    private JTextField text = null;
    private JButton button = null;
    private JTextArea area = null;
    private JLabel lbl = null;
    private JButton nemeh = null;

    public Dic(){
        getframe();
        ButtonGroup group = new ButtonGroup();
		eng = new JRadioButton("English - Mongolia");
		eng.setBounds(10, 10, 190, 20);
		eng.setSelected(true);
                eng.setFont(new Font("Calibri", Font.BOLD, 15));
                eng.setBackground(new Color(0xe2dfdf));
		group.add(eng);
		panel.add(eng);
                mon = new JRadioButton("Монгол - Англи");
		mon.setBounds(200, 10, 200, 20);
		mon.setFont(new Font("Calibri", Font.BOLD , 15));
                mon.setBackground(new Color(0xe2dfdf));
		group.add(mon);
		panel.add(mon);

        area = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(area);
		area.setFont(new Font("Tahoma",  Font.ITALIC, 15));
                area.setBackground(new Color(0xe6e4ea));
		scrollPane.setBounds(10, 70, 320, 170);
		panel.add(scrollPane);
                lbl = new JLabel();
                lbl.setText("Хайх үг :");
                lbl.setFont(new Font("Calibri", Font.BOLD , 15));
                lbl.setBounds(10, 40, 60, 20);
                panel.add(lbl);
    }
    
    private JFrame getframe(){
        if(frame == null){
            frame = new JFrame("Үг хайх талбар");
            frame.setSize(new Dimension(355, 330));
	    frame.setContentPane(getpanel());
	    frame.setLocation(300, 300);
            frame.setVisible(true);
            frame.setResizable(false);
        }
        return frame;
    }
    
    private JPanel getpanel(){
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
                        panel.setBackground(new Color(0xe2dfdf));
			panel.add(getText(), null);
                        panel.add(getButton(), null);
                        panel.add(getNemeh(), null);
		}
		return panel;
    }
    
    private JTextField getText(){
        if(text == null){
            text = new JTextField();
            text.setBounds(new Rectangle(68, 40, 150, 20));
        }
        return text;
    }
    
    private JButton getButton(){
        if(button == null){
            button = new JButton();
            button.setText("Хайх");
            button.setFont(new Font("Calibri", Font.BOLD , 15));
            button.setBounds(new Rectangle(230, 40, 100, 20));
            button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String words = text.getText();
				area.setText("");
				ResultSet resultSet = null;
				Db.runQuery("SELECT * FROM dictionary order by words");
				if(mon.isSelected()) {
					resultSet = Db.runQuery("SELECT words AS area FROM engmon WHERE monwords LIKE '%" + words + "%'");
				} else if(eng.isSelected()){
					resultSet = Db.runQuery("SELECT monwords AS area FROM engmon WHERE words LIKE '%" + words + "%'");
				}
				try {
					while(resultSet.next()) {
						area.setText(area.getText()+resultSet.getString("area")+"\n");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
			}
		});
        }
        return button;
    }
    
    private JButton getNemeh(){
         if(nemeh == null){
            nemeh = new JButton();
            nemeh.setFont(new Font("Calibri", Font.BOLD , 15));
            nemeh.setText("Шинэ үг нэмэх");
            nemeh.setBounds(new Rectangle(60, 250, 200, 20)); 
            nemeh.addActionListener(new ActionListener() 
      {
        public void actionPerformed(ActionEvent e) {
            new plus();
        }
            });
         }
         return nemeh;
     }
      public static void main(String[] args) {
        new Dic();
    }
}
