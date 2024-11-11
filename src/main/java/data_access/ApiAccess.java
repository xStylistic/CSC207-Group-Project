package data_access;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * API access file.
 */
public final class ApiAccess {

    private static final String API_KEY = "baw+70SpL57JbD/nNLXgOQ==RTGa7BsSwkAMlsBQ";
    private static final String API_URL = "https://api.api-ninjas.com/v1/animals?name=";
    private static final Map<String, String> AVAILABLE_ANIMALS = new HashMap<>(
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
    private static final Map<String, List> CURRENT_ANIMALS = new HashMap<>();

    private ApiAccess() {
        throw new AssertionError("Instantiating utility class.");
    }

    /**
     * Gets all the data given the animal.
     * @param animal is animal name
     * @return string of animals and their data
     */
    public static String getData(String animal) {
        final String apiUrl = API_URL + animal;
        try {
            final URL url = new URL(apiUrl);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);

            final int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                final StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            }
            else {
                return "Error: " + responseCode + " " + connection.getResponseMessage();
            }
        }
        catch (Exception exA) {
            exA.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all the animal name given the animal.
     * @param animal is animal name
     * @return list of animal names
     */
    public static List getAnimal(String animal) {
        final String apiUrl = API_URL + animal;
        try {
            final URL url = new URL(apiUrl);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);
            final List<String> animals = new ArrayList<>();

            final int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                final StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                final JSONArray jsonArray = new JSONArray(response.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    final JSONObject jsonObject = jsonArray.getJSONObject(i);
                    final JSONObject taxonomy = jsonObject.getJSONObject("taxonomy");
//                    final JSONObject characteristics = jsonObject.getJSONObject("characteristics");
                    // check if it's in the same family because there might be other animals with same name but
                    // different species
                    System.out.println(jsonObject.getJSONArray("locations"));
                    if (taxonomy.getString("family").equals(AVAILABLE_ANIMALS.get(animal))) {
                        animals.add(jsonObject.getString("name"));
                        CURRENT_ANIMALS.put(jsonObject.getString("name"), new ArrayList<>(Arrays.asList(
                                jsonObject.getJSONArray("locations"),
//                                characteristics.getString("most_distinctive_feature"),
                                taxonomy.getString("family")
                        )));
                    }
                }
                return animals;
            }
            else {
                return null;
            }
        }
        catch (Exception exA) {
            exA.printStackTrace();
        }
        return null;
    }

    /**
     * Main test.
     * @param args commandline arguments are ignored
     */
    public static void main(String[] args) {
        System.out.println(ApiAccess.getAnimal("pig"));

    }
}