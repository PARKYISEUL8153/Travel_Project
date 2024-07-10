package HOMEPAGE.DTO;
import lombok.Data;

@Data
public class dto {
	
	private String join_id,join_pw, join_pw1, join_name, join_cell1, join_cell2, join_addr;
 	
	public dto (String join_id,String join_pw,String join_pw1,String join_name,String join_cell1,String join_cell2, String join_addr ) 
	{
		this.join_id=join_id;
		this.join_pw=join_pw;
		this.join_pw1=join_pw1;
		this.join_name=join_name;
		this.join_cell1=join_cell1;
		this.join_cell2=join_cell2;
		this.join_addr=join_addr;
	}
	public String getid()	{	return join_id;		}
	public String getpw()	{	return join_pw;		}
	public String getpw1()	{	return join_pw1;	}
	public String getname()	{	return join_name;	}
	public String getcell1(){	return join_cell1;	}
	public String getcell2(){	return join_cell2;	}
	public String getaddr()	{	return join_addr;	}

	public dto build()
	{	return new dto(join_id,join_pw,join_pw1,join_name,join_cell1,join_cell2,join_addr); 	}
	
	
}