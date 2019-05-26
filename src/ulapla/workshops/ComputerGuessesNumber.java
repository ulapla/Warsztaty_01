package ulapla.workshops;



import java.util.Scanner;

public class ComputerGuessesNumber {

    public static void main(String[] args){

        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadne w max. 10 próbach");
        int min = 0, max = 1000, counter = 1;
        boolean goOn = true;

        while (goOn) {

            int guess = ((max - min) / 2) + min;
            System.out.println("Próba nr " + counter+ ". Zgaduję: " + guess);
            System.out.println("Wybierz 1 - 3:");
            System.out.println("1 - za mało");
            System.out.println("2 - za dużo");
            System.out.println("3 - tafiłem");

            Scanner scanner = new Scanner(System.in);
            int option = 0;

            try{
                     option = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){

            }

                switch (option) {
                    case 1:
                        min = guess;
                        counter++;
                        break;
                    case 2:
                        max = guess;
                        counter++;
                        break;
                    case 3:
                        System.out.println("Wygrałem!");
                        goOn = false;
                        break;
                    default:
                        System.out.println("Niewłaściwy wybor.");
                        break;
                }



        }
    }
}
