package com.example.getgreetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetgreetingsApplication {

	//client for performing HTTP requests
	private static RestTemplate httpClient = null;
	//base URL for remote calls
	private static String baseURL = "http://localhost:8080/";
	//endpoints for remote calls
	private static String defaultGreetingURL = "greeting";
	private static String namedGreetingURL = "greeting?name=sandali";

	//main method
   public static void main(String[] args) {
		SpringApplication.run(GetgreetingsApplication.class, args);
		makeCalls();
	}

	//singleton pattern implemented to get a single instance of the HTTP client
	private static RestTemplate getHttpClient(){
		if(httpClient == null){
			httpClient = new RestTemplate();
		}
		return httpClient;
	}

	//call the default endpoint and get the response
	private static Greeting getGreeting(String url){
		RestTemplate restmp = getHttpClient();
		Greeting response = restmp.getForObject(baseURL + "/" + url, Greeting.class);
		return response;

	}

	//call the named endpoint and get the response
	private static Greeting getGreetingByName(String url){
		RestTemplate restmp = getHttpClient();
		Greeting response = restmp.getForObject(baseURL + "/" + url, Greeting.class);
		return response;
	}

	//call the endpoints, receive the responses and print them in the console
	private static void makeCalls(){
		Greeting receivedGreeting1 = GetgreetingsApplication.getGreeting(defaultGreetingURL);
		Greeting receivedGreeting2 = GetgreetingsApplication.getGreetingByName(namedGreetingURL);

		String content1 = receivedGreeting1.content();
		System.out.println(content1);

		String content2 = receivedGreeting2.content();
		System.out.println(content2);
	}

}
