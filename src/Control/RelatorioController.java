package Control;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

import Helpers.MillisToTime;
import model.Doc;

public class RelatorioController {
  private ArrayList<Doc> documentos;
  private long millis;
  private int qtdComparacoes;
  private int qtdItensPercorridos;

  public RelatorioController(ArrayList<Doc> documentos){
    // showDocumentos(documentos);
    this.documentos = embaralhar(documentos);
    // showDocumentos(this.documentos);
  }

  private ArrayList<Doc> embaralhar(ArrayList<Doc> documentos){
    ArrayList<Doc> documentos_ = new ArrayList();
    while (documentos.size() > 0){
      Random indice = new Random();
      Doc doc = documentos.remove(indice.nextInt(documentos.size()));
      documentos_.add(doc);
    }

    return documentos_;
  }

  public void heapSort(){
    Instant starts = Instant.now();

    HeapSort hs = new HeapSort(documentos);
    hs.heapSort();

    Instant ends = Instant.now();

    this.qtdComparacoes = hs.getQtdComparacoes();
    this.qtdItensPercorridos = hs.getQtdItensPercorridos();

    Duration tempo = Duration.between(starts, ends);
    
    this.millis = tempo.toMillis();
  }

  public void mergeSort(){
    Instant starts = Instant.now();
    
    MergeSort ms = new MergeSort();
    ms.mergeSort(documentos);
    
    Instant ends = Instant.now();

    this.qtdComparacoes = ms.getQtdComparacoes();
    this.qtdItensPercorridos = ms.getQtdItensPercorridos();

    Duration tempo = Duration.between(starts, ends);
    
    this.millis = tempo.toMillis();
  }

  public long getMillis(){
    return millis;
  }

  public String getTempo(){
    return MillisToTime.convert(millis);
  }

  public int getQtdComparacoes(){
    return qtdComparacoes;
  }

  public int getQtdItensPercorridos(){
    return qtdItensPercorridos;
  }

  public static void main(String[] args) {
    ArrayList<Doc> documentos = DocControler.getArrayDocs();

    RelatorioController rc = new RelatorioController(documentos);

    rc.mergeSort();
    System.out.println("tempo: "+rc.getTempo());
    System.out.println("Quantidade de comparações feitas: "+rc.getQtdComparacoes());
    System.out.println("Quantidade de itens percorridos: "+rc.getQtdItensPercorridos());
  }
}
