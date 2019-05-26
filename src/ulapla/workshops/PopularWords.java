package ulapla.workshops;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class PopularWords {

    public static void main(String[] args){

        // zapis nagłówków do pliku
        Path path = Paths.get("popular_words.txt");
        Connection connect = Jsoup.connect("http://www.onet.pl/");

        try {
            PrintWriter writer = new PrintWriter(path.toFile());
            Document document = connect.get();
            Elements links = document.select("span.title");

            for (Element elem : links) {
                //System.out.println(elem.text());
                String[] line = elem.text().split("[ :!?;,\\.\"]+");
                for (String word : line){
                    writer.println(word);
                }
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //zapis przefiltrowanych danych

        String[] omitted = {"ponieważ","który","która","które","oraz","czyli","przed"};
        Path pathToFilteredFile = Paths.get("filtered_popular_words.txt");

        try {
            PrintWriter filteredWritter = new PrintWriter(pathToFilteredFile.toFile());
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                boolean write = true;
                String word = scanner.nextLine();
                for(int i = 0; i < omitted.length; i++){ //pomin słowa z tablicy omitted
                    if(omitted[i].equals(word)) {
                        write = false;
                    }
                }
                if((word.length() > 3) && write) { //zapisz słowa dłuższe nic 3 znaki
                    filteredWritter.println(word);
                }
            }
            filteredWritter.close();
        }catch(IOException e){
            System.out.println("Nie odnaleziono pliku ze słowami");
        }



    }
}
