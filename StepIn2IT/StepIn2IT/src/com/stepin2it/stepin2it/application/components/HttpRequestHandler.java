package com.stepin2it.stepin2it.application.components;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpStatus;


/**
 * @author muhammad.bilal
 */

public class HttpRequestHandler {

	public static String requestHttpResponse(String urlString) throws IOException {

		StringBuffer buffer = null; 
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		int responseCode = connection.getResponseCode();
		if(responseCode == HttpStatus.SC_OK){
			
			InputStream is =connection.getInputStream();

			final int bufferSize = 1024;
			byte[] data = new byte [bufferSize];
			buffer = new StringBuffer(bufferSize * 10);
			int size;

			size = is.read(data, 0, data.length);
			while (size > 0){
				String str = new String(data, 0, size);
				buffer.append(str);
				size = is.read(data, 0, data.length);
			}
		}

		return buffer.toString();

	}


}
