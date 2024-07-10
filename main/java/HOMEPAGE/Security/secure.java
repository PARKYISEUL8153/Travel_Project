package HOMEPAGE.Security;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import HOMEPAGE.DTO.dto;
import HOMEPAGE.Map.Mapping_data;
import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class secure {

	
		
		@Bean
	    protected PasswordEncoder passwordEncoder() 
		{
	        return new BCryptPasswordEncoder();
	    }

	 
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception 
	    {
	    	
	    	http.csrf(csrf->csrf.disable());

	        http.authorizeHttpRequests(authz->authz.requestMatchers("/login_page","/admin/system","/notice").authenticated());
	        
	        http.authorizeHttpRequests
	        		(authz->authz.requestMatchers("/**","tempalates","static").permitAll()
	        		.requestMatchers("/notice").hasAnyRole("ADMIN","USER")
	        		.requestMatchers("/system").hasRole("ADMIN").anyRequest().permitAll());
	        
	        http.formLogin
	        		(formlogin -> formlogin.loginPage("/login_page").loginProcessingUrl("/login_page")
	        		.failureForwardUrl("/loginerror?login_error=1")
	        		.usernameParameter("username")
	     	        .passwordParameter("password")
	        		.defaultSuccessUrl("/",true).failureUrl("/login_page").permitAll());
	        
	        
	        http.logout
	        		(logout->logout.logoutUrl("/logout").logoutSuccessUrl("/login_page")
	        		.addLogoutHandler((request,response,authentication)->
	        		{HttpSession session = request.getSession();
	        		session.invalidate();})
	        		.logoutSuccessHandler((request,response,authentication)->response.sendRedirect("/login_page")).deleteCookies("JESSIONID","cookie"));
	        			
	  	        return http.build();
	    }
	
	    
	  
	    @Autowired
	    private Mapping_data mapper;
	  
	    @Bean
		public InMemoryUserDetailsManager InMemoryUserDetailsManager() throws Exception
		{
	    	return new InMemoryUserDetailsManager();
		}
	  
	    
	    @Primary
	    @Bean
	    public AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception
		{
	       	List<dto> li =mapper.select();
	    	Iterator<dto> it = li.iterator();
	    	while(it.hasNext())
	    	{
	    		for(dto i:li)
	    		{
	    			it.next();
	    			
	    			if(i.getid().equals("admin"))
	    			{
	    				auth.inMemoryAuthentication().withUser(i.getid()).password(passwordEncoder().encode(i.getpw())).roles("ADMIN");
	    			}
	    			else {
	    				auth.inMemoryAuthentication().withUser(i.getid()).password(passwordEncoder().encode(i.getpw())).roles("USER");
	    			}
	    		}		
	    	}
	    	return auth;
		}
	    	
	    
	}
