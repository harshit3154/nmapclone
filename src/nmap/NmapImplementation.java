/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author harsh
 */
class NmapImplementation {
    
    public static void info(String[] args){
        for(String arg:args){
            System.out.println(arg);
        }
   // public static void main(String... args){
         // Define the Nmap command and target with flags
        //String[] command = {"nmap", "-v","-T4","-A", "192.168.1.4"}; // Example: -sP flag for ping scan

        // Execute the Nmap command
        try {
            // Build the command
            ProcessBuilder processBuilder = new ProcessBuilder(args);
            // Start the process
            Process process = processBuilder.start();

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder sb=new StringBuilder();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
                sb.append("\n");
                try{
                    (Nmap.ta).setText(sb.toString());
                }catch(Exception e){
                    
                }
            }
            sb.setLength(0);
            // Read any errors
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
                sb.append(line);
                try{
                    (Nmap.ta).setText(sb.toString());
                }catch(Exception e){
                    
                }
            }
            sb.setLength(0);

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            Nmap.ta.setText(e.toString());
        }
    }
    
}
