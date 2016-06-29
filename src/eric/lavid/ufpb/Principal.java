package eric.lavid.ufpb;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.File;
//C:/Users/jefc21/Documents/video.ts
public class Principal {
	
	/**
	 * Recebe um Video o caminho de um video com extensão .ts.
	 * chama o metodo Transport_packet da classe gerete, passando o pacote atual, que é inicializado com dados do pacote.
	 * Verifica a presença Tabela PMT e  na sua existencia, o metodo pat é chamado da classe gerente e inicializado com dados do pacote que é passado como parâmetro. 
	 * Vericana na Tabela PAT(classe), os PIDS, que liga com a tabela PMT(classe).
	 * grava os metadados das tabelas PAT e PMT, em arquivos
	 */

	public static void main(String[] args) throws IOException{
		String caminhoVideo= JOptionPane.showInputDialog("CAMINHO DO VIDEO: Neste Formato C:/Users/usuario/video.ts");
		File f=new File(caminhoVideo);	//("C:/Users/jefc21/workspace/Lavid/video.ts");
		byte [] pacote=new byte[188];
		FileInputStream f1=new FileInputStream(f);
		int i=0;
		int tam=0;
		Gerente gerente=new Gerente();
		PAT p=new PAT();
		while((i=f1.read(pacote))>=0){
			Transport_Packet t = gerente.transport(pacote);

			if((t.getPID()==0) && (t.getPayload_unit_start_indicator()==1) && (t.getAdaptation_field_control()==1)){
				p = gerente.pat(pacote);
				
			}
			for(int x=0;x<p.getProgram_map_PID().size();x++){
				if(p.getProgram_map_PID().get(x) == (gerente.concatenaBits((pacote[1] & 255) & 31,pacote[2] & 255,5,13)& 8191)){
						gerente.pmt(pacote);
				}
			}
		}
		gerente.gravarPAT("nomeVIDEO_PAT");
		gerente.gravarPMT("nomeVIDEO_PMT");
		
	}
}