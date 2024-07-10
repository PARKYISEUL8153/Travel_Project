package HOMEPAGE.DTO;
import lombok.Data;

@Data
public class DTO_builder {

	private String join_id,join_pw, join_pw1, join_name, join_cell1, join_cell2, join_addr;

	public DTO_builder Setid(String join_id) {
		this.join_id = join_id;	return this; }
	
	public DTO_builder Setpw(String join_pw) {
		this.join_pw = join_pw;	return this; }
	
	public DTO_builder Setpw1(String join_pw1) {
		this.join_pw1 = join_pw1; return this; }
	
	public DTO_builder Setname(String join_name) {
		this.join_name = join_name;	return this; }
	
	public DTO_builder Setcell1(String join_cell1) {
		this.join_cell1 = join_cell1; return this; }
	
	public DTO_builder Setcell2(String join_cell2) {
		this.join_cell2 = join_cell2; return this; }
	
		public DTO_builder Setaddr(String join_addr) {
		this.join_addr = join_addr;	return this; }
		
	public dto build() 	{	return new dto(join_id,join_pw,join_pw1,join_name, join_cell1, join_cell2, join_addr);	}
	

	

}
