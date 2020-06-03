package SystemManagement;


import CsvFiles.ReadWrite;
import Interface.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ReadWrite<List<String>> readWrite = ReadWrite.getInstance();
        App app = null;
        Scanner scanner = null;
        File fl = new File("./src/FileResources/File");
        Statement connectDB = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "adrianros");
            connectDB = connection.createStatement();
            System.out.println("Console or UI (1-console 0-UI");
            Scanner scanner1 = new Scanner(System.in);
            int isConsole = scanner1.nextInt();


            if (isConsole == 1) {
                scanner = new Scanner(System.in);
                Services s = Services.getInstance(scanner,connectDB);
                s.application();
            } else {
                scanner = new Scanner(fl);
                Services s = Services.getInstance(scanner,connectDB);

                app = App.getInstance(s, connectDB);
            }


        } catch (NullPointerException e) {
            System.out.println("ehy");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
