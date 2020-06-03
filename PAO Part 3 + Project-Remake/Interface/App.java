package Interface;

import SystemManagement.Services;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class App extends JFrame {
    private JButton button_msg;
    private JPanel panelMain;
    private JPanel menu;
    private JButton showAngajatTableButton;
    private JButton insertAnEmployeeButton;
    private JButton showReviewAngajatTableButton;
    private JButton showDateTableButton;
    private JButton showDomiciliuTableButton;
    private JButton showNumeTableButton;
    private JButton deleteAnEmployeeButton;
    private JFrame frame;
    private JPanel cardPanel;
    private Statement stm;
    private CardLayout cl;
    final static String FORM_ONE = "Form One";
    private static App instance;

    public static App getInstance(Services st, Statement stm) throws IOException, SQLException {
        if (instance == null)
            instance = new App(st, stm);
        return instance;
    }

     App(Services s, Statement stm) {
        setLayout(new BorderLayout());
        this.stm = stm;
        Menu menu = new Menu(s, stm);
        setContentPane(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setVisible(true);


    }

    public void showTable() {


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
