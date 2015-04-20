package dictionary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class plus {
    
    private JFrame wordsplus = null;
    private JPanel Panel1 = null;
    private JLabel Angli = null;
    private JLabel Mongol  = null;
    private JTextField Angli_text =null;
    private JTextField Mongol_text =null;
    private JButton Nemeh = null;
    private JButton Back = null;
    
    public plus(){
        getwordsplus();
    }// plus() contructor end
    private JFrame getwordsplus(){
        if(wordsplus == null){
            wordsplus = new JFrame("Шинэ үг нэмэх талбар");
            wordsplus.setSize(new Dimension(355, 330));
	    wordsplus.setContentPane(getPanel1());
	    wordsplus.setLocation(300, 300);
            wordsplus.setResizable(false);
            wordsplus.setVisible(true);
        }
        return wordsplus;
    }// getwordsplus() end
    
    private JPanel getPanel1() {
		if (Panel1 == null) {
			Angli = new JLabel();
			Angli.setText("Англи үг :");
                        Angli.setFont(new Font("Calibri", Font.BOLD , 15));
			Angli.setBounds(new Rectangle(20, 20, 100, 20));
			Mongol = new JLabel();
			Mongol.setText("Монгол үг :");
                        Mongol.setFont(new Font("Calibri", Font.BOLD , 15));
			Mongol.setBounds(new Rectangle(20, 50, 100, 20));
			Panel1 = new JPanel();
			Panel1.setLayout(null);
			Panel1.setBackground(new Color(0xe2dfdf));
			Panel1.setToolTipText("Та шинэ үг нэмэх бол энэ цонхыг бөглөн үү");
			Panel1.add(getAngli_text(), null);
			Panel1.add(getMongol_text(),null);
			Panel1.add(getNemeh(), null);
                        Panel1.add(getBack(), null);
                        Panel1.add(Angli, null);
                        Panel1.add(Mongol, null);
		}//if end
		return Panel1;
	}//getPanel1() end
    private JTextField getAngli_text(){
        if(Angli_text == null){
            Angli_text = new JTextField();
            Angli_text.setBounds(new Rectangle(110, 20, 200, 20));
        }
        return Angli_text;
    }//getAngli_text() end
    private JTextField getMongol_text(){
        if(Mongol_text == null){
            Mongol_text = new JTextField();
            Mongol_text.setBounds(new Rectangle(110, 50, 200, 20));
        }
        return Mongol_text;
    }//getMongol_text() end
    private JButton getBack(){
        if(Back == null){
            Back = new JButton();
            Back.setText("Буцах");
            Back.setFont(new Font("Calibri", Font.BOLD, 15));
            Back.setBounds(new Rectangle(20, 80, 120, 20));
            Back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
//                   wordsplus.setVisible(false);
                   wordsplus.dispose();
                   new Dic();
                }});
        }return Back;
    }//getBack() end
    private JButton getNemeh(){
        if(Nemeh == null){
            Nemeh = new JButton();
            Nemeh.setText("Нэмэх");
            Nemeh.setFont(new Font("Calibri", Font.BOLD , 15));
            Nemeh.setBounds(new Rectangle (190, 80, 120,20));
            Nemeh.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                String eng = getAngli_text().getText();
                String mn = getMongol_text().getText();
                String query = "INSERT INTO engmon(words, monwords) VALUES ('"+eng+"', '"+mn+"')";
                Db.runQuery(query);
                JOptionPane.showMessageDialog(null, "Амжилттай бүртгэгдлээ");
                getwordsplus().setVisible(false);
                }
            });
        }
        return Nemeh;
    }
    }//class plus end