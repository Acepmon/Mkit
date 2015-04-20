import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.mysql.jdbc.Statement;

public class Core extends JFrame {
    TableModel tm;
    final static DefaultTableModel model = new DefaultTableModel();
    JTextArea a;
    int rowIndex = -1;
    JButton login;
    boolean jdialog = true;
    public Core() {
        setTitle("DBP");
        setBounds(100, 100, 420, 500);
        //		setLayout(new GridLayout(2, 2, 10, 10));
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        addButton.setBounds(10, 10, 100, 20);
        editButton.setBounds(120, 10, 100, 20);
        deleteButton.setBounds(230, 10, 100, 20);

        final JTable table = new JTable(model);

        table.setRowSelectionAllowed(true);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                System.out.println(row );

                rowIndex = row;

            }
        });
        JScrollPane jsp = new JScrollPane(table);
		
        jsp.setBounds(10, 60, 400, 400);
        ActionListener addListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                if (jdialog == true) {
                    jdialog = false;
                    final JDialog dialog = new JDialog();
                    JLabel nlabel = new JLabel("Stock No");
                    JLabel glabel = new JLabel("Maker");
                    JLabel alabel = new JLabel("Model");
                    JLabel elabel = new JLabel("Year");
                    JButton ab = new JButton("ADD");
                    JButton cb = new JButton("Cancel");

                    ab.setBounds(10, 170, 100, 30);
                    cb.setBounds(160, 170, 100, 30);
                    final JTextField stock_noTf = new JTextField();
                    final JTextField makerTf = new JTextField();
                    final JTextField modelTf = new JTextField();
                    final JTextField yearTf = new JTextField();
                    stock_noTf.setBounds(140, 10, 120, 20);
                    makerTf.setBounds(140, 50, 120, 20);
                    modelTf.setBounds(140, 90, 120, 20);
                    yearTf.setBounds(140, 130, 120, 20);



                    nlabel.setBounds(10, 10, 100, 20);
                    glabel.setBounds(10, 50, 100, 20);
                    alabel.setBounds(10, 90, 100, 20);
                    elabel.setBounds(10, 130, 100, 20);
                    dialog.setLayout(null);

                    dialog.setTitle("Add item");
                    dialog.add(alabel);
                    dialog.add(glabel);
                    dialog.add(nlabel);
                    dialog.add(elabel);
                    dialog.add(stock_noTf);
                    dialog.add(makerTf);
                    dialog.add(modelTf);
                    dialog.add(yearTf);
                    dialog.add(ab);
                    dialog.add(cb);
                    dialog.pack();
                    dialog.setBounds(400, 10, 280, 210);
                    dialog.setVisible(true); // show the dialog on the screen
                    dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

                    ActionListener aListener = new ActionListener() {
                        public void actionPerformed(ActionEvent actionEvent) {
                        	int stocknoL = Integer.parseInt(stock_noTf.getText());
                        	String makerL =makerTf.getText();
                        	String modelL =modelTf.getText();
                        	int yearL = Integer.parseInt(yearTf.getText());
                            model.addRow(new Object[] {
                                stocknoL,makerL,modelL,yearL
                            });
                            dialog.dispose();
                            jdialog = true;
                            try {
                                add(stocknoL, makerL, modelL, yearL);
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    };
                    ActionListener cListener = new ActionListener() {
                        public void actionPerformed(ActionEvent actionEvent) {
                            dialog.dispose();
                            jdialog = true;
                        }
                    };
                    ab.addActionListener(aListener);
                    cb.addActionListener(cListener);
                }

            }
        };
        ActionListener editListener = new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {
        		System.out.println(rowIndex);
        		if(rowIndex!=-1&model.getRowCount()>=rowIndex){
        			if (jdialog == true) {
                        jdialog = false;
                        final int currentIndex = rowIndex;
                        final JDialog dialog = new JDialog();
                        JLabel nlabel = new JLabel("Stock No");
                        JLabel glabel = new JLabel("Maker");
                        JLabel alabel = new JLabel("Model");
                        JLabel elabel = new JLabel("Year");
                        JButton ab = new JButton("Edit");
                        JButton cb = new JButton("Cancel");

                        ab.setBounds(10, 170, 100, 30);
                        cb.setBounds(160, 170, 100, 30);
                        
                        final int stocknoO = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
                        String makerO = model.getValueAt(rowIndex, 1).toString();
                        String modelO = model.getValueAt(rowIndex, 2).toString();
                        int yearO = Integer.parseInt(model.getValueAt(rowIndex, 3).toString().substring(0,4));
                        
                        final JTextField stock_noTf = new JTextField(stocknoO+"");
                        final JTextField makerTf = new JTextField(makerO);
                        final JTextField modelTf = new JTextField(modelO);
                        final JTextField yearTf = new JTextField(yearO+"");
                        stock_noTf.setBounds(140, 10, 120, 20);
                        makerTf.setBounds(140, 50, 120, 20);
                        modelTf.setBounds(140, 90, 120, 20);
                        yearTf.setBounds(140, 130, 120, 20);

                        nlabel.setBounds(10, 10, 100, 20);
                        glabel.setBounds(10, 50, 100, 20);
                        alabel.setBounds(10, 90, 100, 20);
                        elabel.setBounds(10, 130, 100, 20);
                        dialog.setLayout(null);

                        dialog.setTitle("Edit car id:" + stocknoO);
                        dialog.add(alabel);
                        dialog.add(glabel);
                        dialog.add(nlabel);
                        dialog.add(elabel);
                        dialog.add(stock_noTf);
                        dialog.add(makerTf);
                        dialog.add(modelTf);
                        dialog.add(yearTf);
                        dialog.add(ab);
                        dialog.add(cb);
                        dialog.pack();
                        dialog.setBounds(400, 10, 280, 210);
                        dialog.setVisible(true); // show the dialog on the screen
                        dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

                        ActionListener aListener = new ActionListener() {
                            public void actionPerformed(ActionEvent actionEvent) {
                            	int stocknoL = Integer.parseInt(stock_noTf.getText());
                            	String makerL =makerTf.getText();
                            	String modelL =modelTf.getText();
                            	int yearL = Integer.parseInt(yearTf.getText());
                                model.setValueAt(stocknoL, currentIndex, 0);
                                model.setValueAt(makerL, currentIndex, 1);
                                model.setValueAt(modelL, currentIndex, 2);
                                model.setValueAt(yearL, currentIndex, 3);
                                
                                dialog.dispose();
                                jdialog = true;
                                try {
                                    edit(stocknoO,stocknoL, makerL, modelL, yearL);
                                } catch (SQLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        };
                        ActionListener cListener = new ActionListener() {
                            public void actionPerformed(ActionEvent actionEvent) {
                                dialog.dispose();
                                jdialog = true;
                            }
                        };
                        ab.addActionListener(aListener);
                        cb.addActionListener(cListener);
                    }
        		}
        		
                

            }
        };
        ActionListener deleteListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (rowIndex >= 0&&rowIndex<=model.getRowCount()) {
                	int stock_no = Integer.parseInt(model.getValueAt(rowIndex,0).toString());
                	try {
						delete(stock_no);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    model.removeRow(rowIndex);
                    rowIndex = -1;
                }
            }
        };
        addButton.addActionListener(addListener);
        editButton.addActionListener(editListener);
        deleteButton.addActionListener(deleteListener);
        setLayout(null);
        setVisible(true);
        add(jsp);
        add(addButton);
        add(editButton);
        add(deleteButton);
    }
    public static void add(int stock_no, String maker, String model, int year) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String connection = "jdbc:mysql://localhost:3306/car";
        String user = "root";
        String password = "mysql";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final Connection conn = DriverManager.getConnection(connection, user, password);
        Statement stmt = (Statement) conn.createStatement();
        //	    int val = stmt.executeUpdate("insert into list (stock_id,maker,model,year) VALUES ("+stock_no+",'"+maker+"','"+model+"',"+year+");");
        String query = "insert into list (stock_id,maker,model,year) VALUES (" + stock_no + ",'" + maker + "','" + model + "'," + year + ");";
        System.out.println(query);
        int val = stmt.executeUpdate(query);
        System.out.println("1 row affected");
    }
    public static void edit(int stock_noO,int stock_no, String maker, String model, int year) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String connection = "jdbc:mysql://localhost:3306/car";
        String user = "root";
        String password = "mysql";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final Connection conn = DriverManager.getConnection(connection, user, password);
        Statement stmt = (Statement) conn.createStatement();
        //	    int val = stmt.executeUpdate("insert into list (stock_id,maker,model,year) VALUES ("+stock_no+",'"+maker+"','"+model+"',"+year+");");
        String query	 = "update list set maker='"+maker+"', model='"+model+"', stock_id="+stock_no+", year="+year+" where stock_id="+stock_noO+";";
        System.out.println(query);
        int val = stmt.executeUpdate(query);
        System.out.println("1 row affected");
    }
    public static void delete(int stock_no) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String connection = "jdbc:mysql://localhost:3306/car";
        String user = "root";
        String password = "mysql";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final Connection conn = DriverManager.getConnection(connection, user, password);
        Statement stmt = (Statement) conn.createStatement();
        //	    int val = stmt.executeUpdate("insert into list (stock_id,maker,model,year) VALUES ("+stock_no+",'"+maker+"','"+model+"',"+year+");");
        String query = "delete from list where stock_id="+stock_no+";";
        System.out.println(query);
        int val = stmt.executeUpdate(query);
        System.out.println("1 row deleted");
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String connection = "jdbc:mysql://localhost:3306/car";
        String user = "root";
        String password = "mysql";
        Class.forName(driver);
        final Connection conn = DriverManager.getConnection(connection, user, password);
        Statement stmt = (Statement) conn.createStatement();



        Core c = new Core();
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.addColumn("Stock no");
        model.addColumn("Maker");
        model.addColumn("Model");
        model.addColumn("Year");
        ResultSet rs = stmt.executeQuery("SELECT stock_id, maker,model,year FROM list");
        while (rs.next()) {
            model.addRow(new Object[] {
                rs.getString("stock_id"), rs.getString("maker"), rs.getString("model"), rs.getString("year").substring(0, 4)
            });
            System.out.println(rs.getString("stock_id"));
            System.out.println(rs.getString("maker"));
            System.out.println(rs.getString("model"));
        }
        conn.close();

    }
//l.odkhuu@gmail.com
}