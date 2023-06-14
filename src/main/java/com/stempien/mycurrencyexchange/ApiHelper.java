package com.stempien.mycurrencyexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
    public class ApiHelper {
        public double getCourseInfo(String urlString){
            try {
                String apiUrl = "https://api.nbp.pl/api/exchangerates/rates/a/"+urlString+"/?format=json";
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    String jsonResponse = response.toString();
                    JSONObject jsonObject = new JSONObject(jsonResponse);
                    System.out.println(jsonResponse);
                    JSONArray rates = jsonObject.getJSONArray("rates");
                    Double wynik = null;
                    for (int i = 0; i < rates.length(); i++) {
                        JSONObject ratesObject = rates.getJSONObject(i);
                        wynik = ratesObject.getDouble("mid");
                        System.out.println(wynik);
                    }
                    return wynik;
                } else {
                    System.out.println("Błąd podczas pobierania danych. Kod odpowiedzi: " + responseCode);
                }
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
