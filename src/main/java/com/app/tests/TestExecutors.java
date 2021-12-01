package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnables.AppThread;
import com.app.runnables.UserProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hans
 */
public class TestExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<String> users = getUsersFromFile("/Users/hans/Desktop/tutorial/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter3/03_07/begin/javaseconcurrency/new_users.txt");

        UserDao dao = new UserDao();
        for(String user:users){
            Future<Integer> future = service.submit(new UserProcessor(user, dao));
            System.out.println("Result of the operation is: " + future.get());
        }
        service.shutdown();
        System.out.println("Main execution over");
    }

    public static List<String> getUsersFromFile(String fileName){
        List<String> users = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
            String line = null;
            while((line=reader.readLine())!=null){
                users.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
