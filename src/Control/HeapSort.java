package Control;

import java.util.ArrayList;

import model.Doc;



// ⭐ O HEAP SORT FAZ DO VETOR UMA ÁRVORE BINÁRIA;
// ⭐ CADA FILHO TEM QUE SER MENOR QUE SEU PAI;
// ⭐ OS FILHOS DE UM ELEMENTO PAI ESTAO NAS POSIÇÕES
//             2N+1 E 2N+2 ( ONDE N = POSIÇÃO DO PAI )  
//             EX: ( VETOR = [1,2,3] POSIÇÃOPAI = 0 ,  POSIÇÃOFILHO' = 1 , POSIÇÃOFILHO'' = 2 );

// COMPLEXIDADES:
// NO PIOR CASO : ........ O ( N* LOG N )
// NO CASO MÉDIO : ..... O ( N* LOG N )
// NO MELHOR CASO : .. O ( N* LOG N )

public class HeapSort {
  public void heapSort( ArrayList<Doc> lista ){
    int listaLength = lista.size();
    for ( int i =  (listaLength/2)-1 ; i>=0 ; i--){ // FAZENDO O PRIMEIRO FOR PARA  ORGANIZAR A ÁRVORE, OU SEJA FAZENDO A ÁRVORE BINÁRIA EM SI
      heap(lista, listaLength, i);  
    }
    for ( int i = listaLength-1; i>0 ; i-- ){     // FAZENDO O SEGUNDO FOR AGORA PARA ORGANIZAR TUDO 
      Doc aux = lista.get(0);
      lista.set(0, lista.get(i));
      lista.set(i, aux);
      
      heap(lista, i, 0);
    }
  }
  private void heap( ArrayList<Doc> lista, int listaLength, int root ) {
    int rootAux = root;           // DEFINIDO UM ROOT AUXILIAR PARA PODER FAZER AS TROCAS DEPOIS
    int left = 2* root +1;       // 2N+1
    int right = 2* root +2;     //  2N+2
    if( left < listaLength &&  Integer.parseInt(lista.get(left).getAno()) > Integer.parseInt(lista.get(rootAux).getAno()) ){        //VERIFICANDO SE O FILHO DA ESQUERDA É MAIOR QUE O PAI ( ROOT )
      rootAux = left;               // SE O FILHO FOR MAIOR FAZ A TROCA, MAS NÃO VARIÁVEL AUXILIAR !!
    }
    if( right < listaLength &&  Integer.parseInt(lista.get(right).getAno()) > Integer.parseInt(lista.get(rootAux).getAno()) ){   // VERIFICANDO SE O FILHO DA DIREITA É MAIOR QUE O PAI ( ROOT )
      rootAux = right;            // A MESMA COISA AQUI, SE NO IF ANTERIOR O LEFT  FOI MAIOR QUE O PAI ENTÃO AGORA ELE É O PAI, MAS SE O RIGHT FOR MAIOR AQUI ROLA A TORCA
    }
    if ( rootAux != root ){     // AQUI É USADO O ROOTAUX PARA VERIFICAR SE É DIFERENTE DO ROOT PASSADO NA FUNÇÃO, PARA PODER FAZER AS ALTERAÇÕES NO VETOR
      Doc aux = lista.get(root);    
      // lista[root]=lista[rootAux];
      lista.set(root, lista.get(rootAux));
      // lista[rootAux]=aux;
      lista.set(rootAux, aux);
      heap(lista, listaLength, rootAux); //  RECURSIVIDADE !!
    }
  }
}
