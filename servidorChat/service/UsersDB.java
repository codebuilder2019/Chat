package servidorChat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsersDB {
    private String fileName;
    private String delimiter;
    private int idCount;
    private ArrayList<User> users;
    
    public UsersDB(String fileName, String delimiter) throws IOException{
        this.fileName = fileName;
        this.delimiter = delimiter;
        
        File usersFile = new File(this.fileName);
        File metaFile = new File("meta_" + this.fileName);
        
        if(!usersFile.exists()){
            metaFile.createNewFile();
            usersFile.createNewFile();
          
            FileWriter csvWriter = new FileWriter("meta_" + this.fileName);
            csvWriter.append("0");
            csvWriter.flush();
            csvWriter.close();
            
            this.idCount = 0;
        }
    }
    
    public int addUser(String name, String role, String department, String user, String password) throws IOException{
        idCount++;

        User newUser = new User(idCount, name, role, department, user, password);
        this.users.add(newUser);
        this.commit();
        
        return idCount;
    }
    
    public void connect() throws FileNotFoundException, IOException {
        String row;
        this.users = new ArrayList<User>();
        
        BufferedReader csvReader = new BufferedReader(new FileReader("meta_" + this.fileName));
        this.idCount = Integer.parseInt(csvReader.readLine());
        csvReader.close();
        
        csvReader = new BufferedReader(new FileReader(this.fileName));
        
        while ((row = csvReader.readLine()) != null) {
            String[] stringUser = row.split(this.delimiter);
            User newUser = new User(Integer.parseInt(stringUser[0]), stringUser[1], stringUser[2], stringUser[3], stringUser[4], stringUser[5]);
            this.users.add(newUser);
        }
        
        csvReader.close();
    }
    
    private void commit() throws IOException {
        FileWriter csvWriter = new FileWriter("meta_" + this.fileName);
        csvWriter.append(String.valueOf(idCount));
        csvWriter.flush();
        csvWriter.close();
        
        csvWriter = new FileWriter(this.fileName);
        
        for (int i = 0; i < users.size(); i++) {
            csvWriter.append(String.valueOf(this.users.get(i).getId()));
            csvWriter.append(", ");
            csvWriter.append(this.users.get(i).getName());
            csvWriter.append(", ");
            csvWriter.append(this.users.get(i).getRole());
            csvWriter.append(", ");
            csvWriter.append(this.users.get(i).getDepartment());
            csvWriter.append(", ");
            csvWriter.append(this.users.get(i).getUser());
            csvWriter.append(", ");
            csvWriter.append(this.users.get(i).getPassword());
            csvWriter.append("\n");
        }
        
        csvWriter.flush();
        csvWriter.close();
    }
    
    public boolean deleteUserById(int id) throws IOException {
        boolean userDeleted = false;
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                userDeleted = true;
                this.commit();
                break;
            }
        }
        
        return userDeleted;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }
    
    public User getUserById(int id){
        User user = null;
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                user = users.get(i);
                break;
            }
        }

        return user;
    }
    
    public boolean updateById(int id, String name, String role, String department, String user, String password) throws IOException{
        boolean foundUser = false;
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setName(name);
                users.get(i).setRole(role);
                users.get(i).setDepartment(department);
                users.get(i).setUser(user);
                users.get(i).setPassword(password);
                this.commit();
                break;
            }
        }
        
        return foundUser;
    }
    
    public User verifyCredentials(String user, String password) {
        User validUser = null;
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUser().equals(String.valueOf(user))) {
                if (users.get(i).getPassword().equals(String.valueOf(password))) {
                    validUser = users.get(i);
                }
                
                break;
            }
        }
        
        return validUser;
    }
}
