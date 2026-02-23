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
	private static String namedGreetingURL = "greeting/name?name=sandali";
	private static String greetingWithDateURL = "greeting/today?name=sandali"; 
	//main method
   public static void main(String[] args) {
		SpringApplication.run(GetgreetingsApplication.class, args);
		makeCallsWithDate();
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

	private static Greeting getGreetingWithDate(String url){
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

		System.out.println("Analyzing if this is a REST API:");
		explainRESTAPI();
	}

	private static void makeCallsWithDate(){
		System.out.println("--Calling Original Endpoints--");
		Greeting receivedGreeting1 = GetgreetingsApplication.getGreeting(defaultGreetingURL);
		Greeting receivedGreeting2 = GetgreetingsApplication.getGreetingByName(namedGreetingURL);
		
		System.out.println("Original greeting 1: " + receivedGreeting1.content());
		System.out.println("Original greeting 2: " + receivedGreeting2.content());
		
		// Display date if available (for Question 2)
		if (receivedGreeting1.date() != null) {
			System.out.println("Date from greeting 1: " + receivedGreeting1.date());
		}
		
		System.out.println("\n--Calling New Date Endpoint (Question 1 & 2)--");
		Greeting receivedGreeting3 = GetgreetingsApplication.getGreetingWithDate(greetingWithDateURL);
		
		System.out.println("Greeting with date: " + receivedGreeting3.content());
		System.out.println("Date from API: " + receivedGreeting3.date());
		
		// SELF-LEARNING QUESTION 3
		System.out.println("\n--Question 3--");
		System.out.println("Is this a REST API? " + isRESTAPI());
		System.out.println(explainRESTAPI());
	}
	
	// SELF-LEARNING QUESTION 3: Analysis methods
	private static boolean isRESTAPI() {
		/* 
		 * Check REST principles:
		 * 1. Client-server architecture? YES
		 * 2. Stateless? YES
		 * 3. Cacheable? PARTIALLY
		 * 4. Uniform interface? YES
		 * 5. Layered system? YES
		 * 6. Code on demand? NO
		 */
		return true; // It satisfies most REST principles
	}
	
	private static String explainRESTAPI() {
		StringBuilder explanation = new StringBuilder();
		explanation.append("REST API Analysis:\n");
		explanation.append("Client-Server: Separate client and server applications\n");
		explanation.append("Stateless: Each request contains all needed information\n");
		explanation.append("Cacheable: Responses could be cached (not explicitly configured)\n");
		explanation.append("Uniform Interface: Uses HTTP methods, URIs, JSON\n");
		explanation.append("Layered System: Can add proxies/load balancers\n");
		explanation.append("Code on Demand: Does not send executable code\n\n");
		explanation.append("Conclusion: Yes, this can be considered a REST API, ");
		explanation.append("though it's a simple implementation (Level 2 on Richardson Maturity Model).");
		
		return explanation.toString();
	}

}
