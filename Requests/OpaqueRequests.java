package Requests;

import java.net.*;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PublicOrUnmonitoredRequest{
        private static void makeRequest(String requestUrl){
                
                try {
                        URL google = new URL(requestURL);
                        InputStream is = google.openStream();
                        is.close();
                        String requestOutput = "Request to " + requestURL + " successful";
                        System.out.println(requestOutput);
                } catch (MalformedURLException ex) {
                        System.out.println("MalformedURLException");
                        System.exit(0);
                } catch (IOException ex) {
                        System.out.println("IOException");
                        System.exit(0);
                } catch (InterruptedException ex) {
                        System.out.println("InterruptedException");
                        System.exit(0);
                }

        }
}
                

public class OpaqueRequests {
        public static void main (String[] args) {
                while(true){
                        try {
                                Properties prop = new Properties();
                                String fileName = "requests.conf";
                                InputStream configis = null;

                                configis = new FileInputStream(fileName);
                                prop.load(configis);

                                String requestURL = prop.getProperty("REQUEST_URL");
                                
                                PublicOrUnmonitoredRequest pour = new PublicOrUnmonitoredRequest();
                                pour.makeRequest(requestURL);

                                TimeUnit.SECONDS.sleep(3);
                        } catch (MalformedURLException ex) {
                                System.out.println("MalformedURLException");
                                System.exit(0);
                        } catch (IOException ex) {
                                System.out.println("IOException");
                                System.exit(0);
                        } catch (InterruptedException ex) {
                                System.out.println("InterruptedException");
                                System.exit(0);
                        }
                }
        }
}
