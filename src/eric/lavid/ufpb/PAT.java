package eric.lavid.ufpb;

import java.util.ArrayList;
import java.util.Arrays;

public class PAT {

	private int table_id; 
	private int section_syntax_indicator; 
	private int zero; 
	private int reserved1; 
	private int section_length;
	private int transport_stream_id; 
	private int reserved2; 
	private int version_number; 
	private int current_next_indicator; 
	private int section_number;
	private int last_section_number;
	private ArrayList<Integer> program_map_PID;
	private long CRC_32;
	private int cont=0;
	
	public PAT(){
		program_map_PID=new ArrayList();
	}
	
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public int getSection_syntax_indicator() {
		return section_syntax_indicator;
	}
	public void setSection_syntax_indicator(int section_syntax_indicator) {
		this.section_syntax_indicator = section_syntax_indicator;
	}
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getReserved1() {
		return reserved1;
	}
	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}
	public int getSection_length() {
		return section_length;
	}
	public void setSection_length(int section_length) {
		this.section_length = section_length;
	}
	public int getTransport_stream_id() {
		return transport_stream_id;
	}
	public void setTransport_stream_id(int transport_stream_id) {
		this.transport_stream_id = transport_stream_id;
	}
	public int getReserved2() {
		return reserved2;
	}
	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}
	public int getVersion_number() {
		return version_number;
	}
	public void setVersion_number(int version_number) {
		this.version_number = version_number;
	}
	public int getCurrent_next_indicator() {
		return current_next_indicator;
	}
	public void setCurrent_next_indicator(int current_next_indicator) {
		this.current_next_indicator = current_next_indicator;
	}
	public int getSection_number() {
		return section_number;
	}
	public void setSection_number(int section_number) {
		this.section_number = section_number;
	}
	public int getLast_section_number() {
		return last_section_number;
	}
	public void setLast_section_number(int last_section_number) {
		this.last_section_number = last_section_number;
	}
	public ArrayList<Integer> getProgram_map_PID(){
		return this.program_map_PID;
	}
	public void setProgram_map_PID(int program_map_pid){
		this.program_map_PID.add(program_map_pid);
	}
	public long getCRC_32() {
		return CRC_32;
	}
	public void setCRC_32(long cRC_32) {
		CRC_32 = cRC_32;
	}

	@Override
	public String toString() {
		return "\nPAT [table_id=" + table_id + ", section_syntax_indicator=" + section_syntax_indicator + ", zero=" + zero
				+ ", reserved1=" + reserved1 + ", section_length=" + section_length + ", transport_stream_id="
				+ transport_stream_id + ", reserved2=" + reserved2 + ", version_number=" + version_number
				+ ", current_next_indicator=" + current_next_indicator + ", section_number=" + section_number
				+ ", last_section_number=" + last_section_number + ", program_map_PID=" + program_map_PID.toString() + ", CRC_32="
				+ CRC_32 + ", cont=" + cont + "]";
	}
	
	
}
