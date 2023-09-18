# Getting Started
Webapp: 
- http://localhost:8080/netflix/ --> index.html
- http://localhost:8080/netflix/v1/tarifrechner/lofi/20 --> REST/JSON
- http://localhost:8080/netflix/greeting?name=Lofi  --> greeting.html
- http://localhost:8080/netflix/login --> login.html
- http://localhost:8080/netflix/tarif-rechner --> netflix-tarifrechner.html

H2 Console: http://localhost:8080/netflix/h2-console/

# Change to Spring Boot 3.1.x

- Use OpenRewrite: https://docs.openrewrite.org/running-recipes/popular-recipe-guides/migrate-to-spring-3

- Change the WebSecurityConfig:

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
  MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/");
  	http.authorizeHttpRequests(
  			(requests) -> requests.requestMatchers(mvcMatcherBuilder.pattern("/greeting")).permitAll().anyRequest().authenticated())
  			.formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

  	return http.build();
  }

  Problem with 2 servlets: Spring and H2 servlets
  See: https://github.com/spring-projects/spring-security/issues/13568

- remoteUser problem: 
  <h1 th:inline="text">Hello [[${#httpServletRequest.remoteUser}]]!</h1>

  Thymeleaf 3.1 no longer provides access to HttpServletRequest 
  so HttpServletRequest#getRemoteUser() cannot be used to access the currently authenticated user.
