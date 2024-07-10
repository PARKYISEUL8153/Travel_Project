package HOMEPAGE.Map;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import HOMEPAGE.DTO.dto;


@Mapper
public interface Mapping_data {
	
	@Insert("insert into joinform values(#{join_id},#{join_pw},#{join_pw1},#{join_name},#{join_cell1},#{join_cell2},#{join_addr})")
	public void insert_data(String join_id ,String join_pw, String join_pw1,String join_name, String join_cell1 , String join_cell2 ,String join_addr );

	@Select("select * from joinform")
	public List<dto> select();
	
	@Insert("insert into notice values(#{id},#{title},#{email},#{data})") //문의사항
	public void insert_board(String id,String title ,String email, String data);
	
	@Update("update joinform set pw='${join_pw}', pw2='${join_pw}' where id='${join_id}'")
	public void updata_pw(String join_pw, String join_id);
		
	@Select("select id from joinform")
	public List<String> select_id();
}
