package ulapla.workshops;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoSimulator {


    public static void main(String[] args){

        while(true) {
            System.out.println("Podaj 6 liczb od 1 do 49:");
            System.out.println("Chcesz zakończyć - wpisz: quit");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();

            if (input.equals("quit")) { //zamykanie
                break;
            }
            String[] splited = input.split("[, ]+");

            int[] testResult = dataTest(splited);

            if(testResult!=null) {
                checking(testResult);
            }
            System.out.println("********************************");
        }
    }

    public static int[] dataTest(String[] dane) {
        int[] numbers = new int[6];

        if (dane.length != 6) {
            System.out.println("To nie jest 6 liczb. Podaj jeszcze raz.");
            return null;
        }

        for (int i = 0; i < dane.length; i++) {
            try {
                numbers[i] = Integer.parseInt(dane[i]);//czy podano liczby
                if (numbers[i] > 49 || numbers[i] < 1) {
                    System.out.println("Wprowadzono liczbę spoza zakresu");
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędne dane. Podaj jeszcze raz.");
                return null;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[i] == numbers[j]) {
                    System.out.println("Liczby muszą być różne. Podaj jeszcze raz");
                    return null;
                }
            }
        }
        return numbers;
    }


    public static void checking(int[] numbers){
        Random rand = new Random();
        Arrays.sort(numbers);

        int hitCounter = 0;

        int[] winNumbers = new int[6];

        //pętla sprawdza czy wylosowano 6 różnych liczb
        for (int i = 0; i < winNumbers.length; i++) {
            int temp = rand.nextInt(49) + 1;
            //if(i==3)winNumbers[2]=temp; //do testow poprawnosci dzialania petli
            if (Arrays.binarySearch(winNumbers,temp) < 0) {
                winNumbers[i] = temp;
            }
            else {
                i--;
            }

        }

        for (int i = 0; i < winNumbers.length; i++) {

            // winNumbers[i] = i+4;//do testowania sprawdzania czy wynik dobrze liczy

           //jeśli Arrays zwróci coś większego niż -1 to znaczy, że występuje to w tablicy
           if (Arrays.binarySearch(numbers,winNumbers[i])>=0){
               hitCounter++;
           }
        }
        Arrays.sort(winNumbers);
        System.out.println("Wybrane numery: " + Arrays.toString(numbers));
        System.out.println("Wylosowane numery: " + Arrays.toString(winNumbers));

        switch (hitCounter) {
            case 0:
            case 1:
            case 2:
                System.out.println("Nie trafiłaś");
                break;
            case 3:
                System.out.println("Trafiłaś \" trójkę \"");
                break;
            case 4:
                System.out.println("Trafiłaś \"czwórkę\"");
                break;
            case 5:
                System.out.println("Trafiłaś \"piątkę\"");
                break;
            case 6:
                System.out.println("Trafiłaś \"szóstkę\"");
                break;
        }
    }



}
