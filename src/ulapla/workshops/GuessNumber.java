package ulapla.workshops;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args){

        System.out.println("Zgadnij liczbę od 0 do 100");
        Random rand = new Random();
        int win = rand.nextInt(100);

        boolean notEnd = true;

        while(notEnd) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Podaj liczbę: ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("To nie liczba, podaj liczbę: ");
            }

            int scanned = scanner.nextInt();

            if (win == scanned) {
                System.out.println("Wygrałaś! Wylosowana liczba to: " + win);
                notEnd = false;
            } else if (scanned > win) {
                System.out.println("Za dużo");
            } else {
                System.out.println("Za mało");
            }
        }
    }
}
