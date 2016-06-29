package eric.lavid.ufpb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gerente {
	private ArrayList<PAT> pats;
	private ArrayList<PMT>pmts;
	private ArrayList<Transport_Packet> transports; 
	
 
	public Gerente(){
		pats= new ArrayList();
		pmts= new ArrayList();
		transports=new ArrayList();
	}
	public Transport_Packet transport(byte[]pacote){
		Transport_Packet transporte=new Transport_Packet();
		transporte.setSync_byte(pacote[0]);
		transporte.setTransport_error_indicator((pacote[1] & 255)>>7 & 1);
		transporte.setPayload_unit_start_indicator((pacote[1] & 255)>>6 & 1);
		transporte.setTransport_priority((pacote[1] & 255)>>5 & 1);
		transporte.setPID(concatenaBits((pacote[1] & 255) & 31 ,pacote[2] & 255,5,13));
		transporte.setTransport_scrambling_control((pacote[3] & 255)>>6 & 3);
		transporte.setAdaptation_field_control((pacote[3] & 255)>>4 & 3);
		transporte.setContinuity_counter((pacote[3] & 255) & 15);
		transports.add(transporte);
		return transporte;
	}
	
	//cria uma instancia da PAT e inicializa com dados do pacote do video, e adiciona a uma ArrayList "pats".
	public PAT pat(byte[]pacote){
		PAT p=new PAT();
		p.setTable_id(pacote[5] & 255);
		p.setSection_syntax_indicator(((pacote[6] & 255)>>7) & 1);
		p.setZero(((pacote[6] & 255)>>6) & 1);
		p.setReserved1(((pacote[6] & 255)>>4) & 3);
		p.setSection_length(concatenaBits((pacote[6] & 255) & 15 ,pacote[7] & 255,4,12) & 4095  /* 2**12 */);
		p.setTransport_stream_id(concatenaBits((pacote[8] & 255) ,pacote[9] & 255,5,13) & 65535 /* 2**16 */);
		p.setReserved2(((pacote[10] & 255)>>6) & 3);
		p.setVersion_number(((pacote[10] & 255)>>1) & 31);
		p.setCurrent_next_indicator((pacote[10] & 255) & 1);
		p.setSection_number(pacote[11] & 255);
		p.setLast_section_number(pacote[12] & 255);
		
		int N=(((p.getSection_length() - 8) / 4)<0) ? 0:((p.getSection_length() - 8) / 4);
		int cont=13;
		int program_number=concatenaBits(pacote[cont], pacote[cont+1], 8, 16);
		for(int i=0;i<N;i++){
			if(program_number != 0){
				p.setProgram_map_PID(concatenaBits((pacote[cont+2] & 255) & 31,pacote[cont+3] & 255,5,13));
			}
			cont+=4;
		}
		p.setCRC_32(concatenaBits(concatenaBits(pacote[cont] & 255, pacote[cont+1] & 255,8,16) ,concatenaBits(pacote[cont+2] & 255,pacote[cont+3] & 255,8,16) ,16,32));
		pats.add(p);
		return p;
	}
	
	//cria uma instancia da tabela PMT e inicializa com dados do pacote do video, e adiciona a uma ArrayList "pmts".
	public PMT pmt(byte[]pacote){
		PMT pMT=new PMT();
		pMT.setTable_id(pacote[5] & 255);
		pMT.setSection_syntax_indicator(((pacote[6] & 255)>>7) & 1);
		pMT.setZero(((pacote[6] & 255)>>6) & 1);
		pMT.setReserved1(((pacote[6] & 255)>>4) & 3);
		pMT.setSection_length(concatenaBits((pacote[6] & 255) & 15 ,pacote[7] & 255,4,12) & 4095);
		pMT.setProgram_number(concatenaBits((pacote[8] & 255) ,pacote[9] & 255,5,13) & 65535);
		pMT.setReserved2(((pacote[10] & 255)>>6) & 3);
		pMT.setVersion_number(((pacote[10] & 255)>>1) & 31);
		pMT.setCurrent_next_indicator((pacote[10] & 255) & 1);
		pMT.setSection_number(pacote[11] & 255);
		pMT.setLast_section_number(pacote[12] & 255);
		pMT.setReserved3(((pacote[13] & 255)>>5) & 7);
		pMT.setPCR_PID(concatenaBits((pacote[13] & 255) & 31,pacote[14],5,13) & 8191);
		pMT.setReserved4(((pacote[15] & 255)>>4) & 15);
		pMT.setProgram_info_length(concatenaBits((pacote[15] & 255) & 15,pacote[16] & 255,4,12));
		
		int N=(((pMT.getSection_length()-13)/5) < 0) ? 0 : ((pMT.getSection_length()-13)/5);
		int cont=17;
		for(int i=0;i<N;i++){
			pMT.setStream_type(pacote[cont] & 255);
			pMT.setReserved5(((pacote[cont + 1] & 255) >> 5) & 7);
			pMT.setElementary_PID(concatenaBits((pacote[cont+1] & 255) & 31,pacote[cont+2] & 255,5,13));
			pMT.setReserved6(((pacote[cont+3] & 255)>>4) & 15);
			pMT.setES_info_length(concatenaBits((pacote[cont+3] & 255) & 15,pacote[cont+4] & 255,4,12));
			cont+=5;
		}
		pMT.setCRC_32(concatenaBits(concatenaBits(pacote[cont] & 255, pacote[cont+1] & 255,8,16) ,concatenaBits(pacote[cont+2] & 255,pacote[cont+3] & 255,8,16) ,16,32));
		pmts.add(pMT);
		return pMT;
	}
	
	public ArrayList<PAT> listaPAT(){
		return this.pats;
	}
	
	public ArrayList<PMT> listaPMT(){
		return this.pmts;
	}
	
	//concatena dois numeros em binario, e return seu valor em inteiro.
	public int concatenaBits(int x,int y,int quantBitsX, int quantTotalBits){
		int valor1=x << (quantTotalBits - quantBitsX);
		int total=valor1 + y;
		return total;
	}
	
	//cria arquivo e gravar nele(PAT).
	public void gravarPAT(String nomeArq) throws IOException{
		File arqPAT =new File(nomeArq+".txt"); 
		BufferedWriter escrever=new BufferedWriter(new FileWriter(arqPAT));
		escrever.write(nomeArq+" - PAT.txt");
		for(PAT p: pats){
			escrever.newLine();
			escrever.write(p.toString());
	
		}
		escrever.close();
	}
	
	//cria arquivo e gravar nele(PMT).
	public void gravarPMT(String nomeArq) throws IOException{
		File arqPAT =new File(nomeArq+".txt"); 
		BufferedWriter escrever=new BufferedWriter(new FileWriter(arqPAT));
		escrever.write(nomeArq+" - PMT.txt");
		for(PMT p: pmts){
			escrever.newLine();
			escrever.write(p.toString());
		}
		escrever.close();
	}
}
