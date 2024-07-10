package HOMEPAGE.Controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import HOMEPAGE.Map.Mapping_data;
import jakarta.servlet.http.HttpServletRequest;
import HOMEPAGE.DTO.DTO_builder;


@Controller

public class cont {
	
	@Autowired
	public Mapping_data Mapp;
	
	@GetMapping("/")
	public String index() 
	{	
	
		
		return "index.html";
	}

	@GetMapping("/joinus")
	public String joinus( ) 
	{	
	
		return "joinus.html";
	}

	@PostMapping("/joinus")
	public String member_join(@RequestParam String join_id,@RequestParam String join_pw,@RequestParam String join_pw1,@RequestParam String join_name,
							@RequestParam String join_cell1,@RequestParam String join_cell2,@RequestParam String join_addr) 
	{
			DTO_builder data = new DTO_builder();
			
			data.Setid(join_id)
			.Setpw(join_pw1)
			.Setpw1(join_pw1)
			.Setname(join_name)
			.Setcell1(join_cell1)
			.Setcell2(join_cell2)
			.Setaddr(join_addr)
			.build();	
			
			Iterator<String> it = Mapp.select_id().iterator();
			while(it.hasNext())
			{
				if(it.next().equals(join_id)) 
				{
					return "joinus";
				} 
				else 
				{
					Mapp.insert_data(join_id, join_pw, join_pw1, join_name, join_cell1, join_cell2, join_addr);}
				}
					return "redirect:/login_page";
						
	}

	@GetMapping("/login_page")
	public String createForm(HttpServletRequest request)
	{ 			
	
		return "/login_page.html";
	}

	@PostMapping("/logout")
	public String logout_main(HttpServletRequest request)  
	{
		return "redirect:/";
	}


	@GetMapping("/reservation")
	public String reservation( ) 
	{
		
		return "reservation.html";
	}

	@GetMapping("/information")
	public String information() 
	{
		return "information.html";
	}
	
	@PostMapping("/notice")
	public String data(@RequestParam String id ,@RequestParam String title, @RequestParam String email, @RequestParam String data) 
	{

		Mapp.insert_board(id, title,email,data);
		return "notice.html";
	}

	
	@PostMapping("/mypage")
	public String mypage(@RequestParam String join_pw, @RequestParam String join_id) {
		
		if(join_id != null)
		{		
			Mapp.updata_pw(join_pw, join_id);
			return "redirect:/";
		}
		
		return "/user/mypage.html";
	}
	
	
	@GetMapping("/notice")
	public String notice() 
	{

		return "notice.html";
	}

	@GetMapping("/system")
	public String system() {
		return "/admin/system.html";
	}
	@GetMapping("/mypage")
	public String mypage1() {
		
		return "/user/mypage.html";
	}
}
