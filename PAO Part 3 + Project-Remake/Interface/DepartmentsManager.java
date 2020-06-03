package Interface;

import SystemManagement.Services;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.border.LineBorder;

public class DepartmentsManager extends JFrame implements ActionListener {

    //@SuppressWarnings("unused")
    //private Statement stm=null;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    static Services s;
    JButton insertDepButton;
    JButton deleteDepButton;
    JButton updateDepButton;
    JScrollPane scrollPane;

    /**
     * Create the frame.
     */
    JTextArea subDepartment;
    JTextArea idDelete;
    JButton dataDep;
    JButton insertDep;
    JButton deleteDep;
    JButton updateDep;
    JPanel deletePanel;
    JPanel updatePanel;
    JPanel insertPanel;
    JPanel dataPanel;
    JTextArea idUpdate;
    private JTextField typeDepInsert;
    private JTable table;
    private JTable table_1;
    private JPanel cardPanel;
    FileWriter fw;
    private JLabel lblNewLabel_6;
    private Statement stm;
    private JTextField typeSubDepInsert;
    private static DepartmentsManager instance;

    public static DepartmentsManager getInstance(Services st, Statement stm) throws IOException, SQLException {
        if (instance == null)
            instance = new DepartmentsManager(st, stm);
        return instance;
    }

    private DepartmentsManager(Services st, Statement stm) throws IOException, SQLException {
        fw = new FileWriter("./src/FileResources/File");
        this.stm = stm;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(this, popupMenu);
        JButton btnNewButton = new JButton("New button");
        popupMenu.add(btnNewButton);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(Color.GRAY);
        toolBar.setForeground(Color.BLACK);
        toolBar.setBounds(0, 0, 596, 38);
        contentPane.add(toolBar);
        Border b = BorderFactory.createLineBorder(Color.black);
        insertDep = new JButton("Insert Department");
        toolBar.add(insertDep);
        insertDep.setBackground(Color.WHITE);
        insertDep.addActionListener(this);

        deleteDep = new JButton("Delete Department");
        toolBar.add(deleteDep);
        deleteDep.setBackground(Color.WHITE);
        deleteDep.addActionListener(this);
        updateDep = new JButton("Update Department");
        updateDep.setBackground(Color.WHITE);
        toolBar.add(updateDep);
        updateDep.addActionListener(this);
        dataDep = new JButton("Data Departments");
        dataDep.addActionListener(this);
        dataDep.setBackground(Color.WHITE);
        toolBar.add(dataDep);

        cardPanel = new JPanel();
        cardPanel.setBounds(10, 48, 576, 305);
        contentPane.add(cardPanel);
        cardPanel.setLayout(new CardLayout(0, 0));

        insertPanel = new JPanel();
        cardPanel.add(insertPanel, "name_40189397865800");
        insertPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Insert a Dep");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(221, 68, 134, 48);
        insertPanel.add(lblNewLabel);

        typeDepInsert = new JTextField();
        typeDepInsert.setBounds(221, 158, 96, 19);
        insertPanel.add(typeDepInsert);
        typeDepInsert.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Type Dep (IT/ADMIN/HR/SHIPPING)");
        lblNewLabel_1.setBounds(26, 161, 186, 13);
        insertPanel.add(lblNewLabel_1);

        insertDepButton = new JButton("Insert Dep");
        insertDepButton.addActionListener(this);
        insertDepButton.setBounds(240, 263, 85, 21);
        insertPanel.add(insertDepButton);

        lblNewLabel_6 = new JLabel("Subdepartment Name(Ex: IT_helpdesk)");
        lblNewLabel_6.setBounds(26, 186, 197, 13);
        insertPanel.add(lblNewLabel_6);

        typeSubDepInsert = new JTextField();
        typeSubDepInsert.setColumns(10);
        typeSubDepInsert.setBounds(221, 183, 96, 19);
        insertPanel.add(typeSubDepInsert);

        updatePanel = new JPanel();
        updatePanel.setLayout(null);
        cardPanel.add(updatePanel, "name_40189412089400");

        JLabel lblNewLabel_2 = new JLabel("Update a Dep");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(236, 79, 102, 32);
        updatePanel.add(lblNewLabel_2);

        idUpdate = new JTextArea();
        idUpdate.setBounds(108, 152, 114, 22);
        updatePanel.add(idUpdate);

        subDepartment = new JTextArea();
        subDepartment.setBounds(108, 225, 114, 22);
        updatePanel.add(subDepartment);

        JLabel lblNewLabel_3 = new JLabel("ID");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(53, 158, 45, 13);
        updatePanel.add(lblNewLabel_3);

        JLabel lblWorkcond = new JLabel("Subdepartment");
        lblWorkcond.setBounds(10, 231, 88, 13);
        updatePanel.add(lblWorkcond);

        updateDepButton = new JButton("Update Dep");
        updateDepButton.setBounds(235, 274, 85, 21);
        updateDepButton.addActionListener(this);
        updatePanel.add(updateDepButton);

        deletePanel = new JPanel();
        cardPanel.add(deletePanel, "name_40189426321000");
        deletePanel.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Delete a Dep");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(149, 88, 276, 30);
        deletePanel.add(lblNewLabel_4);

        deleteDepButton = new JButton("Delete Dep");
        deleteDepButton.addActionListener(this);
        deleteDepButton.setBounds(258, 220, 85, 21);
        deletePanel.add(deleteDepButton);

        JLabel lblNewLabel_5 = new JLabel("ID");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_5.setBounds(166, 178, 59, 13);
        deletePanel.add(lblNewLabel_5);

        idDelete = new JTextArea();
        idDelete.setBounds(235, 172, 123, 22);
        deletePanel.add(idDelete);

        dataPanel = new JPanel();
        cardPanel.add(dataPanel, "name_41104845133400");
        dataPanel.setLayout(null);
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 5, 576, 300);
        dataPanel.add(scrollPane);
        ResultSet length = stm.executeQuery("select count(*) from departments");
        length.next();
        Object[][] data = new Object[length.getInt(1)][];
        ResultSet resultSetDep = stm.executeQuery("select * from departments");


        int i = -1;
        while (resultSetDep.next()) {
            int id = resultSetDep.getInt(1);
            String subDep = resultSetDep.getString(2);
            String depCateg = resultSetDep.getString(3);
            String thread = resultSetDep.getString(4);
            i += 1;
            data[i] = new Object[]{id, subDep, depCateg, thread};

            //dataDep.add(Arrays.asList(String.valueOf(id),DepType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),DepName,resultSetDep.getString(7)));
        }

        String[] column = {"DepID", "Sub-department", "Department category", "thread"};
        table = new JTable(data, column);
        scrollPane.setViewportView(table);
        dataDep.addActionListener(this);

        this.s = st;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setVisible(true);
    }

    public void switchPanels(JPanel panel) {
        cardPanel.removeAll();
        cardPanel.add(panel);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == deleteDep) {
            switchPanels(deletePanel);

        } else if (clicked == insertDep) {
            switchPanels(insertPanel);
        } else if (clicked == updateDep) {
            switchPanels(updatePanel);
        } else if (clicked == dataDep) {
            switchPanels(dataPanel);
            ResultSet length = null;
            System.out.println("TABEL LOADED");
            try {
                length = stm.executeQuery("select count(*) from departments");

                length.next();
                Object[][] data = new Object[length.getInt(1)][];
                ResultSet resultSetDep = stm.executeQuery("select * from departments");


                int i = -1;
                while (resultSetDep.next()) {
                    int id = resultSetDep.getInt(1);
                    String subDep = resultSetDep.getString(2);
                    String depCateg = resultSetDep.getString(3);
                    String thread = resultSetDep.getString(4);

                    i += 1;
                    data[i] = new Object[]{id, subDep, depCateg, thread};

                    //dataDep.add(Arrays.asList(String.valueOf(id),DepType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),DepName,resultSetDep.getString(7)));
                }

                String[] column = {"DepID", "Sub-department", "Department category", "thread"};
                table = new JTable(data, column);

                scrollPane.setViewportView(table);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (clicked == deleteDepButton) {
            int val = Integer.parseInt(idDelete.getText());
            try {
                fw.append(" 9 departments " + idDelete.getText() + " 0 ");
                System.out.println(fw.toString());
                fw.flush();
                s.application();
                idDelete.setText("");
                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }

        } else if (clicked == updateDepButton) {
            try {
                fw.append("8 departments " + idUpdate.getText());
                if (subDepartment.equals("") == false) {
                    fw.append(" " + subDepartment.getText() + " 0 ");
                    fw.flush();
                    s.application();
                }


                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }
        } else if (clicked == insertDepButton) {
            try {
                fw.append(" 7 2 " + typeDepInsert.getText() + " ");
                {
                    fw.append(typeSubDepInsert.getText() + " 0 " + " 5 " + " -1 " + " 0 " + " 0 ");//+s.getLastId()+" 0 "+" 0 ");
                    fw.flush();

                    s.application();
                }
                typeDepInsert.setText("");
                typeSubDepInsert.setText("");
                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }
        }
		/*else if(clicked==dataDep){
			try {
				fw.append("7 3 "+typeDepInsert.getText()+" ");
				if(typeDepInsert.getText().equals("special"))
				{fw.append(DepNameInsert.getText()+" "+bonusWorkcondInsert.getText()+" "+bonusDisabInsert.getText()+" 6 "+" -1 "+" 0 "+" 0 ");//+s.getLastId()+" 0 "+" 0 ");
					fw.flush();
					System.out.println("INTRUUUUUUUUUUUUUUUUUUUU");
					s.application();
				}
				else if(typeDepInsert.getText().equals("normal"))
				{	System.out.println("INTRUUUUUUUUUUUUUUUUUUUU");
					fw.append(DepNameInsert.getText()+" 6 "+" -1 "+" 0 "+" 0 ");
					System.out.println("SERVICESSSS="+Services.getLastId());
					fw.flush();
					s.application();
				}
				DepNameInsert.setText("");
				bonusWorkcondInsert.setText("0");
				bonusDisabInsert.setText("0");
				typeDepInsert.setText("");

				JOptionPane.showMessageDialog(this,"Succesful");
			} catch (FileNotFoundException ef){
				ef.printStackTrace();
			}
			catch (IOException eio){
				eio.printStackTrace();
			}
		}*/

    }
}
