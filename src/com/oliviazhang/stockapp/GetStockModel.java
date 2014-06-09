package com.oliviazhang.stockapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

public class GetStockModel {
	String price;
	String company;
	String pegraito;

	public void doStockSearch(String stocksym) {
		String response = "";
		try {
			URL url = new URL(
					"http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"
							+ stocksym
							+ "%22)%0A%09%09&env=http%3A%2F%2Fdatatables.org%2Falltables.env&format=json");

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				response += str;
			}
			in.close();
		} catch (IOException e) {
			System.out
					.println("An error occurs when trying to fetch stock prices");
		}
		try {
			JSONObject responseObject = (JSONObject) new JSONTokener(response)
					.nextValue();
			JSONObject query = (JSONObject) responseObject.get("query");
			JSONObject quote = ((JSONObject) query.get("results"))
					.getJSONObject("quote");
			pegraito = quote.getString("PEGRatio");
			company = quote.getString("Name");
			price = quote.getString("Open");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPrice() {
		return price;
	}

	public String getCompany() {
		return company;
	}

	public String getPeg() {
		return pegraito;
	}
}