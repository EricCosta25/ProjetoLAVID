package eric.lavid.ufpb;

import java.util.ArrayList;

public class PMT {
	
	 private int table_id; 
	 private int section_syntax_indicator; 
	 private int zero;
	 private int reserved1; 
	 private int section_length; 
	 private int program_number; 
	 private int reserved2; 
	 private int version_number; 
	 private int current_next_indicator; 
	 private int section_number; 
	 private int last_section_number; 
	 private int reserved3; 
	 private int PCR_PID; 
	 private int reserved4; 
	 private int program_info_length;
	 private ArrayList<Integer> stream_type;
	 private ArrayList<Integer> reserved5;
	 private ArrayList<Integer> elementary_PID;
	 private ArrayList<Integer> reserved6;
	 private ArrayList<Integer> ES_info_length;
	 private long CRC_32;
	 
	public PMT(){
		stream_type=new ArrayList();
		reserved5= new ArrayList();
		elementary_PID=new ArrayList();
		reserved6=new ArrayList();
		ES_info_length=new ArrayList();
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
	public int getProgram_number() {
		return program_number;
	}
	public void setProgram_number(int program_number) {
		this.program_number = program_number;
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
	public int getReserved3() {
		return reserved3;
	}
	public void setReserved3(int reserved3) {
		this.reserved3 = reserved3;
	}
	public int getPCR_PID() {
		return PCR_PID;
	}
	public void setPCR_PID(int pCR_PID) {
		PCR_PID = pCR_PID;
	}
	public int getReserved4() {
		return reserved4;
	}
	public void setReserved4(int reserved4) {
		this.reserved4 = reserved4;
	}
	public int getProgram_info_length() {
		return program_info_length;
	}
	public void setProgram_info_length(int program_info_length) {
		this.program_info_length = program_info_length;
	}

	public ArrayList<Integer> getStream_type() {
		return stream_type;
	}

	public void setStream_type(int stream_type) {
		this.stream_type.add(stream_type);
	}

	public ArrayList<Integer> getReserved5() {
		return reserved5;
	}

	public void setReserved5(int reserved5) {
		this.reserved5.add(reserved5);
	}

	public ArrayList<Integer> getElementary_PID() {
		return elementary_PID;
	}

	public void setElementary_PID(int elementary_PID) {
		this.elementary_PID.add(elementary_PID);
	}

	public ArrayList<Integer> getReserved6() {
		return reserved6;
	}

	public void setReserved6(int reserved6) {
		this.reserved6.add(reserved6);
	}

	public ArrayList<Integer> getES_info_length() {
		return ES_info_length;
	}

	public void setES_info_length(int eS_info_length) {
		ES_info_length.add(eS_info_length);
	}

	public long getCRC_32() {
		return CRC_32;
	}

	public void setCRC_32(long cRC_32) {
		CRC_32 = cRC_32;
	}

	@Override
	public String toString() {
		return "PMT [table_id=" + table_id + ", section_syntax_indicator=" + section_syntax_indicator + ", zero=" + zero
				+ ", reserved1=" + reserved1 + ", section_length=" + section_length + ", program_number="
				+ program_number + ", reserved2=" + reserved2 + ", version_number=" + version_number
				+ ", current_next_indicator=" + current_next_indicator + ", section_number=" + section_number
				+ ", last_section_number=" + last_section_number + ", reserved3=" + reserved3 + ", PCR_PID=" + PCR_PID
				+ ", reserved4=" + reserved4 + ", program_info_length=" + program_info_length + ", stream_type="
				+ stream_type.toString() + ", reserved5=" + reserved5.toString() + ", elementary_PID=" + elementary_PID.toString() + ", reserved6="
				+ reserved6.toString() + ", ES_info_length=" + ES_info_length.toString() + ", CRC_32=" + CRC_32 + "]";
	}
	
}
