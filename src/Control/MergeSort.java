package Control;

import java.util.ArrayList;

import model.Doc;

//⭐ O MERGE SORT É BASEADO NO CONCEITO ' DIVIDIR PARA CONQUISTAR '
//          - DIVIR  O PROBLEMA EM PROBLEMAS MENORES;
//          - CONQUISTAR O SUBPROBLEMA;
//          - COMBINAR OS SUBPROBLEMAS PARA SOLUCIONAR O PROBLEMA MAIOR;
//⭐ DIVIDE-SE O VETOR EM DOIS SUBVETORES ATÉ FICAR VÁRIOS SUBVETORES COM UMA POSIÇÃO;
//⭐ COMPARA, COMO SE FOSSEM PILHAS, O MENOR ELEMENTO DE UMA PILHA E OUTRA E 
//      VAI ALOCANDO NUM OUTRO VETOR ATÉ OBTER O VETOR ORDENADO
//

// COMPLEXIDADE:
// NO PIOR CASO = ........ O ( N* LOG N )
// NO CASO MÉDIO = ..... O ( N* LOG N )
// NO MELHOR CASO = .. O ( N* LOG N )

public class MergeSort {
  public void mergeSort(ArrayList<Doc> lista) {
    int listaLength = lista.size();
    if (listaLength < 2) { // RERIFICAÇÃO PARA PARAR A RECURSIVIDADE
      return;
    }
    int middle = listaLength / 2;  // DIFINIÇÃO DO MEIO DO VETOR PARA PODER DIVIDI-LO 
    ArrayList<Doc> left = new ArrayList<Doc>();  // DEFINIÇÃO DA ESQUERDA
    // for ( int i=0 ; i<=listaLength; i++ ){
    //   left.add(null);
    // }
    ArrayList<Doc> right = new ArrayList<Doc>(); //DEFINIÇÃO DA DIREITA
    // for ( int i=0; i< (listaLength - middle); i++ ){
    //   right.add(null);
    // }
    for (int i = 0; i < middle; i++) { //CRIANDO UMA SUBLISTA DA LISTA MAIOR
      // left.set(i, lista.get(i));
      left.add(i, lista.get(i));
    }
    for (int i = middle; i < lista.size(); i++) { // CRIANDO A OUTRA SUBLISTA
      // right.set(i - middle, lista.get(i));
      right.add(i - middle, lista.get(i));
    }
    mergeSort(left);  //RECURSIVIDADE DO PRO LADO ESQUERDO.
    mergeSort(right);//RECURSIVIDADE PRO LADO DIREITO.
    merge(lista, left, right); //CHAMANDO O MÉTODO QUE ORGANIZA A BAGAÇA TODA.
  }

  private void merge(ArrayList<Doc> lista, ArrayList<Doc> left, ArrayList<Doc> right) { // ESSE É O MÉTODO QUE COMPARA AS PONTAS DAS PILHAS E FAZ AS TROCAS
    int leftSize = left.size();
    int rightSize = right.size();
    int i = 0, j = 0, k = 0; // VARIÁVEIS PARA AUXILIAR NA POSIÇÃO NO VETOR
    while (i < leftSize && j < rightSize) {// ESSE WHILE SET OS VALORES MENORES NAS CASAS
      int leftValue = Integer.parseInt(left.get(i).getAno());
      int rightValue = Integer.parseInt(right.get(j).getAno());
      // System.out.println(""+ leftSize+ " "+  rightSize +" "+ left );

      if (leftValue <= rightValue) { // VERIFICAÇÃO SE O VALOR DA ESQUEDA É MENOR QUE O DA DIREITA. ATRIBUI O VALOR NA PRÓPRIA LISTA FAZENDO JÁ A TROCA
      
      lista.set(k,left.get(i));
      i++;
    } else { // SE O VALOR DA ESQUERDA NÃO É MENOR QUE  O DA DIREITA CAI AQUI E ATRIBUI O VALOR NA LISTA.
      lista.set(k, right.get(j));
      j++;
    }
    k++;
      
    }
    while (i < leftSize) { // ESSE WHILE ORGANIZA OS VALORES NA LISTA
      lista.set(k, left.get(i));
      i++;
      k++;
    }
    while (j < rightSize) {
      lista.set(k, right.get(j));
      j++;
      k++;
    }
  }
}
