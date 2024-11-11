package data_access;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public final class apiAccess {  // make this a static class later and package it

    private static final String API_KEY = "baw+70SpL57JbD/nNLXgOQ==RTGa7BsSwkAMlsBQ";
    private static final String API_URL = "https://api.api-ninjas.com/v1/animals?name=";
    private static final Map AVAILABLE_ANIMALS = new HashMap<>(
            Map.ofEntries(
                    Map.entry("pig", "Suidae"),
                    Map.entry("alpaca", "Camelidae"),
                    Map.entry("horse", "Equidae"),
                    Map.entry("cow", "Bovidae"),
                    Map.entry("chicken", "Phasianidae"),
                    Map.entry("fox", "Canidae"),
                    Map.entry("bear", "Ursidae"),
                    Map.entry("tiger", "Felidae"),
                    Map.entry("flamingo", "Phoenicopteridae"),
                    Map.entry("rabbit", "Leporidae"))
    );

    private apiAccess(){
        throw new AssertionError("Instantiating utility class.");
    }

    public static String getData(String animal){  // returns a list of animals with the keyword 'animal' in it
        String apiUrl = API_URL + animal;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "Error: " + responseCode + " " + connection.getResponseMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List getAnimal(String animal){
        String apiUrl = API_URL + animal;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);
            List<String> animals = new ArrayList<>();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONArray jsonArray = new JSONArray(response.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    JSONObject taxonomy = jsonObject.getJSONObject("taxonomy");
                    // check if it's in the same family because there might be other animals with same name but different
                    // species
                    if (taxonomy.getString("family").equals(AVAILABLE_ANIMALS.get(animal))) {
                        animals.add(jsonObject.getString("name"));
                    }
                }
                return animals;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(apiAccess.getAnimal("pig"));

    }
}
