package control.format;

public class Maiusculas {

    public static String todasPalavras (String frase){

        String palavras[] = frase.split("\\s");
        String maiusculadas = "";

        for(String p : palavras){
            String primeira = p.substring(0,1);
            String restanteDaPalavra = p.substring(1);
            maiusculadas += primeira.toUpperCase() + restanteDaPalavra + " ";
        }

        return maiusculadas.trim();
    }

}
