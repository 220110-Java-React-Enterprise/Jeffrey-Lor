package web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Card;
import models.Data;

public class YGOAPI implements IYGOAPI {

    private static final String GET_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php";

    @Override
    public Card searchCard(String query) {
        try {
            // Set up Yu-Gi-Oh! API by YGOPRODeck
            URL url = new URL(GET_URL + "?name=" + query.replaceAll(" ", "%20"));

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Make connection
            connection.connect();

            // Check if successful
            int status = connection.getResponseCode();
            if (status == 200 || status == 201) {
                // Put response into String
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                // Convert String response into JSON using Jackson
                ObjectMapper mapper = new ObjectMapper();
                Data d = mapper.readValue(sb.toString(), Data.class);

                // Uncomment to see JSON
                // System.out.println(sb.toString());

                return d.getData()[0];

            } else if (status == 400) {
                // Card wasn't found, but so try fuzzy search
                return fsearchCard(query);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Card fsearchCard(String query) {
        try {
            // Set up Yu-Gi-Oh! API by YGOPRODeck
            URL url = new URL(GET_URL + "?fname=" + query.replaceAll(" ", "%20"));

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Make connection
            connection.connect();

            // Check if successful
            int status = connection.getResponseCode();
            if (status == 200 || status == 201) {
                // Put response into String
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                // Convert String response into JSON using Jackson
                ObjectMapper mapper = new ObjectMapper();
                Data d = mapper.readValue(sb.toString(), Data.class);

                // Uncomment to see JSON
                // System.out.println(sb.toString());

                return d.getData()[0];

            } else if (status == 400) {
                System.out.println("Card not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
