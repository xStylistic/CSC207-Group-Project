package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * API access file.
 */
public final class AnimalDataAccessObject {

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

    private AnimalDataAccessObject() {
        throw new AssertionError("Instantiating utility class.");
    }

    /**
     * Gets all the animal name given the animal.
     * @param animal is animal name
     * @return list of animal names
     */
    public static Map getAnimal(String animal) {
        final String apiUrl = API_URL + animal;
        final List<String> animals = new ArrayList<>();
        final Map<String, List> animalsMap = new HashMap<>();
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

                final JSONArray jsonArray = new JSONArray(response.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    final JSONObject jsonObject = jsonArray.getJSONObject(i);
                    final JSONObject taxonomy = jsonObject.getJSONObject("taxonomy");
                    final JSONObject characteristics = jsonObject.getJSONObject("characteristics");
                    // check if it's in the same family because there might be other animals with same name but
                    // different species
                    final Iterator<String> keys = characteristics.keys();
                    final String[] keyArray = new String[characteristics.length()];
                    int index = 0;
                    while (keys.hasNext()) {
                        keyArray[index++] = keys.next();
                    }
                    final String randomKey = keyArray[new Random().nextInt(keyArray.length)];

                    final List<String> animalLocations = new ArrayList<String>();
                    if (jsonObject.getJSONArray("locations") != null) {
                        for (int j = 0; j < jsonObject.getJSONArray("locations").length(); j++) {
                            animalLocations.add(jsonObject.getJSONArray("locations").getString(j));
                        }
                    }

                    if (taxonomy.getString("family").equals(AVAILABLE_ANIMALS.get(animal))) {
                        animals.add(jsonObject.getString("name"));
                        animalsMap.put(jsonObject.getString("name"), new ArrayList<>(Arrays.asList(
                                animalLocations,
                                randomKey + ": " + characteristics.getString(randomKey),
                                taxonomy.getString("family")
                        )));
                    }
                }
            }
        }
        catch (IOException exA) {
            exA.printStackTrace();
        }
        catch (JSONException exA) {
            exA.printStackTrace();
        }
        return animalsMap;
    }
}
