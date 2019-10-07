package sample;

import java.util.LinkedHashSet;

public class InserirValores {

    public static void valores(String conteudo){
        //coleção para armazenar as preposições
        LinkedHashSet<String> prepo = new LinkedHashSet<String>();
        String[] itensP = new String[5];
        int cont =0;

        //divide os temos do campo
        String[] valores = conteudo.split(" ");

        //determina quantas preposições são
        for(int i =1; i<valores.length; i++){

            if(valores[i].equals("P")){
                prepo.add("P");
                itensP[cont] = "P";
                cont++;
            }else{
                if(valores[i].equals("Q")){
                    prepo.add("Q");
                    itensP[cont] = "Q";
                    cont++;
                }else{
                    if(valores[i].equals("R")){
                        prepo.add("R");
                        itensP[cont] = "R";
                        cont++;
                    }else {
                        if(valores[i].equals("S")){
                            prepo.add("S");
                            itensP[cont] = "S";
                            cont++;
                        }
                    }
                }
            }

        }
        montarTabela(valores, prepo.size(),itensP);

    }


    public static void montarTabela(String[] colunas, int quantP,String[] ordemP) {
        //monta uma matriz para montar a tabela
        // determina a quantidade de linhas
        int linha = (int) Math.pow(2,quantP);

        //determinar a quantidade de colunas
        String[][] tabela = new String[linha][colunas.length];

        //preenche a tabela
        for(int i = 0; i<tabela.length;i++){

            for(int j = 1; j< colunas.length;j++){
                if(colunas[j].equals(ordemP[0])){
                    //A primeira coluna é a metade da tabela
                    if(i<linha/2){
                        tabela[i][j] = "V";
                    }else{
                        tabela[i][j] = "F";
                    }
                }else {
                    if (colunas[j].equals(ordemP[1])) {
                        //A segunda coluna é um quarto da tabela
                        if((i%((int)(Math.pow(2,quantP))/2))< (((int)Math.pow(2,(quantP-1))))/2){
                            tabela[i][j] = "V";
                        }else {
                            tabela[i][j] = "F";
                        }
                    } else {
                        if (colunas[j].equals(ordemP[2])) {
                            //A terceira coluna é um oitavo da tabela
                            if((i%((int)(Math.pow(2,quantP))/4))< (((int)Math.pow(2,(quantP-1))))/4){
                                tabela[i][j] = "V";
                            }else {
                                tabela[i][j] = "F";
                            }
                        } else {
                            if(i>4){
                                //A quarta coluna e um dezesseis avos da tabela
                                if((i%((int)(Math.pow(2,quantP))/8))< (((int)Math.pow(2,(quantP-1))))/8){
                                    tabela[i][j] = "V";
                                }else {
                                    tabela[i][j] = "F";
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i<tabela.length;i++){
            for(int j = 1 ; j< tabela[i].length;j++){
                if(colunas[j].equals("v")){
                    if(comparar(tabela[i][j-1],tabela[i][j+1],colunas[j])){
                        tabela[i][j]="V";
                    }else{
                        tabela[i][j]="F";
                    }
                }else{
                    if(colunas[j].equals("^")){
                        if(comparar(tabela[i][j-1],tabela[i][j+1],colunas[j])){
                            tabela[i][j]="V";
                        }else{
                            tabela[i][j]="F";
                        }
                    }else{
                        if(colunas[j].equals("<->")){
                            if(comparar(tabela[i][j-1],tabela[i][j+1],colunas[j])){
                                tabela[i][j]="V";
                            }else{
                                tabela[i][j]="F";
                            }
                        }else{
                            if(colunas[j].equals("->")){
                                if(comparar(tabela[i][j-1],tabela[i][j+1],colunas[j])){
                                    tabela[i][j]="V";
                                }else{
                                    tabela[i][j]="F";
                                }
                            }else{
                                if(colunas[j].equals("!")){
                                    if(comparar(tabela[i][j-1],tabela[i][j+1],colunas[j])){
                                        tabela[i][j]="V";
                                    }else{
                                        tabela[i][j]="F";
                                    }
                                }else{
                                    if(colunas[j].equals("~")){
                                        if(j==1){
                                            if(tabela[i][j+1].equals("V")){
                                                tabela[i][j+1]="F";
                                            }else{
                                                tabela[i][j+1]="V";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        }


        for(int i = 0; i<colunas.length;i++){
            System.out.print(colunas[i]+" ");
        }
        System.out.println();

        for(int i = 0; i<tabela.length;i++){
            for(int j = 1 ; j< tabela[i].length;j++){
                System.out.print( " " +tabela[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean comparar(String posUM,String posDois, String valor){

        System.out.println(posUM + " "+posDois + " "+valor);

        if(valor.equals("->")){
            return posUM.equals("V")&&posDois.equals("F")?false:true;
        }
        if(valor.equals("^")){
            return posUM.equals("V")&&posDois.equals("V");
        }
        if(valor.equals("v")){
            return posUM.equals("F")&&posDois.equals("F")?false:true;
        }
        if(valor.equals("<->")){
            return posUM.equals(posDois);
        }
        return !posUM.equals(posDois);
    }
}
