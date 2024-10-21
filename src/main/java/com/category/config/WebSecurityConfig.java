//package com.category.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////            .csrf().disable()  // Disable CSRF for testing purposes
////            .authorizeRequests()
////            .antMatchers(HttpMethod.POST, "/api/products/save").permitAll()
////            .antMatchers(HttpMethod.POST, "/api/categories/save").permitAll()
////            .antMatchers(HttpMethod.GET, "/api/categories/getAllData").permitAll()
////            .antMatchers(HttpMethod.GET, "/api/categories/getAllData/id").permitAll()
////            .antMatchers(HttpMethod.PUT, "/api/categories/putData/id").permitAll()
////            .antMatchers(HttpMethod.DELETE, "/api/categories/delete/id").permitAll()
////        
////            .antMatchers(HttpMethod.GET, "/api/categories/getAllProducts").permitAll()
////            .antMatchers(HttpMethod.GET, "/api/categories/getProductById/id").permitAll()
////            .antMatchers(HttpMethod.PUT, "/api/categories/updateProduct/id").permitAll()
////            .antMatchers(HttpMethod.DELETE, "/api/categories/deleteProduct/id").permitAll()// Allow POST on this endpoint
////            .anyRequest().authenticated();
////    }
//	
//	
//
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors() // Enable CORS
//            .and()
//            .csrf().disable() // Disable CSRF for simplicity
//            .authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/api/categories/").permitAll() // Allow GET requests to categories
//            .antMatchers(HttpMethod.POST, "/api/categories/").permitAll() // Allow POST requests to categories
//            .antMatchers(HttpMethod.PUT, "/api/categories/").permitAll() // Allow PUT requests to categories
//            .antMatchers(HttpMethod.DELETE, "/api/categories/").permitAll() // Allow DELETE requests to categories
//            .antMatchers("/api/products/").permitAll()// Allow all requests to your API
//            .anyRequest().authenticated() // For any other request, require authentication
//            .and()
//            .httpBasic(); // Use basic authentication (can be removed if not needed)
//
//        return http.build();
//    }
//	}
//
//    
//