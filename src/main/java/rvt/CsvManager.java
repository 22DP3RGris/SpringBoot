package rvt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvManager {

    private String userFilePath;
    private String directoryPath;

    public CsvManager(String userFilePath, String directoryPath){

        this.userFilePath = userFilePath;
        this.directoryPath = directoryPath;
    }

    public void createCsv(){

        File directory = new File(directoryPath);
        File userFile = new File(userFilePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (!userFile.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath))){
                writer.write("ID, First Name, Last Name, E-mail, Group, \n");

                writer.close();
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    public void objToCsv(User user){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath, true))) {

            String record = String.format("%s, %s, %s, %s, %s, %s, %s, %s\n", user.getFullname(), user.getEmail(), user.getPassword(), user.getDate(), user.getGender(), user.getGroup(), user.isMarried(),user.getNote());
            writer.write(record);

            System.out.println("Lietotājs ir veiksmīgi piereģistrēts!");

            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}