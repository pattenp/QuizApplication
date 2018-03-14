package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import model.Category;

public class ApiService {

	public String getCategory() throws IOException {
		URL url = new URL("http://localhost:8080/api/1/category/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int respCode = connection.getResponseCode();
		if (respCode == HttpURLConnection.HTTP_OK) {
			BufferedReader buffReader = new BufferedReader(
					new InputStreamReader(
							connection.getInputStream())
			);
			String inputLine;
			StringBuffer response = new StringBuffer();

			while((inputLine = buffReader.readLine()) != null) {
				response.append(inputLine);
			}

			System.out.println(response.toString());
		}
		return null;
	}


	public static void main(String[] args) {
		ApiService api = new ApiService();
		try {
			api.getCategory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
