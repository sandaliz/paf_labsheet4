package com.example.greetingapi;

import java.time.LocalDate;

public record Greeting (long id, String content, LocalDate date) {
    
}

// madam's way
// public class Greeting {
//     private long id;
//     private String content;

//     public Greeting(long id, String content) {
//         this.id = id;
//         this.content = content;
//     }

//     public long getId() {
//         return id;
//     }

//     public String getContent() {
//         return content;
//     }
// }