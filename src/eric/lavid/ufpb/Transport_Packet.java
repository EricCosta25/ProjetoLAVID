package eric.lavid.ufpb;

public class Transport_Packet {
	private int sync_byte;		
	private int transport_error_indicator; 
	private int payload_unit_start_indicator; 
	private int transport_priority ;
	private int PID ;
	private int transport_scrambling_control; 
	private int adaptation_field_control ;
	private int continuity_counter ;
	
	public Transport_Packet(){
		
	}

	public int getSync_byte() {
		return sync_byte;
	}

	public void setSync_byte(int sync_byte) {
		this.sync_byte = sync_byte;
	}

	public int getTransport_error_indicator() {
		return transport_error_indicator;
	}

	public void setTransport_error_indicator(int transport_error_indicator) {
		this.transport_error_indicator = transport_error_indicator;
	}

	public int getPayload_unit_start_indicator() {
		return payload_unit_start_indicator;
	}

	public void setPayload_unit_start_indicator(int payload_unit_start_indicator) {
		this.payload_unit_start_indicator = payload_unit_start_indicator;
	}

	public int getTransport_priority() {
		return transport_priority;
	}

	public void setTransport_priority(int transport_priority) {
		this.transport_priority = transport_priority;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public int getTransport_scrambling_control() {
		return transport_scrambling_control;
	}

	public void setTransport_scrambling_control(int transport_scrambling_control) {
		this.transport_scrambling_control = transport_scrambling_control;
	}

	public int getAdaptation_field_control() {
		return adaptation_field_control;
	}

	public void setAdaptation_field_control(int adaptation_field_control) {
		this.adaptation_field_control = adaptation_field_control;
	}

	public int getContinuity_counter() {
		return continuity_counter;
	}

	public void setContinuity_counter(int continuity_counter) {
		this.continuity_counter = continuity_counter;
	}

	@Override
	public String toString() {
		return "Transport_Packet [sync_byte=" + sync_byte + ", transport_error_indicator=" + transport_error_indicator
				+ ", payload_unit_start_indicator=" + payload_unit_start_indicator + ", transport_priority="
				+ transport_priority + ", PID=" + PID + ", transport_scrambling_control=" + transport_scrambling_control
				+ ", adaptation_field_control=" + adaptation_field_control + ", continuity_counter="
				+ continuity_counter + "]";
	}

}































