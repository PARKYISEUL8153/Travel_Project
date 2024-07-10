package HOMEPAGE.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HOMEPAGE.Map.Mapping_data;


@Controller
public class boardcont {

	@GetMapping("/fukuoka")
	public String fuku() {
		
		return "/board/fukuoka.html";
	}
	
	@GetMapping("/tokyo")
	public String tokyo() {
		
		return "/board/tokyo.html";
	}
	@GetMapping("/osaka")
	public String osaka() {
		
		return "/board/osaka.html";
	}
	
	@GetMapping("/sapporo")
	public String sapporo() {
		
		return "/board/sapporo.html";
	}
	
	@GetMapping("/suggest")
	public String sugg()
	{
		
		return "/board/suggest.html";
	}
	
	@GetMapping("/event")
	public String even()
	{
		
		return "/board/event.html";
	}


	
	
}
