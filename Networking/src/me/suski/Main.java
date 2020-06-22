package me.suski;

import javax.sql.rowset.serial.SerialStruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            URI baseUri = new URI("http://username:password@mynewserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URL url1 = resolvedUri1.toURL();
            URL url2 = resolvedUri2.toURL();
            URL url3 = resolvedUri3.toURL();

            System.out.println("URL 1 = " + url1);
            System.out.println("URL 2 = " + url2);
            System.out.println("URL 3 = " + url3);

            URI relativizedURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI = " + relativizedURI);

            System.out.println("------------");

            URL url4 = new URL("http://example.org");

            URI uri4 = url4.toURI();
            System.out.println("Scheme = " + uri4.getScheme());
            System.out.println("Scheme-specific part = " + uri4.getSchemeSpecificPart());
            System.out.println("Authority = " + uri4.getAuthority());
            System.out.println("User Info = " + uri4.getUserInfo());
            System.out.println("Host = " + uri4.getHost());
            System.out.println("Port = " + uri4.getPort());
            System.out.println("Path = " + uri4.getPath());
            System.out.println("Query = " + uri4.getQuery());
            System.out.println("Fragment = " + uri4.getFragment());

            System.out.println("------------");

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(
                            url4.openStream()));

            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

            System.out.println("------------");

            URLConnection urlConnection = url4.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream2 = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream()));

            String line2 = "";
            while (line2 != null) {
                line2 = inputStream2.readLine();
                System.out.println(line2);
            }
            inputStream2.close();

            System.out.println("------------");

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

            for (Map.Entry<String, List<String>> entry :
                    headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();

                System.out.println("Key = " + key);
                for (String str :
                        value) {
                    System.out.println("\tvalue = " + value);
                }
            }

            System.out.println("------------");

            URL url5 = new URL("http://example.org");

            HttpURLConnection connection = (HttpURLConnection) url5.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputStream3 = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            String line3;
            while ((line3 = inputStream3.readLine()) != null) {
                System.out.println(line3);
            }
            inputStream3.close();

            System.out.println("------------cats");

            URL url6 = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");

                connection = (HttpURLConnection) url6.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            inputStream = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            line = "";
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
            }
            inputStream.close();



        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
