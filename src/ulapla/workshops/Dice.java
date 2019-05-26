package ulapla.workshops;

import java.util.Arrays;
import java.util.Random;

public class Dice {

    public static void main(String[] args){

        String code = "2D10+10";
        System.out.println(diceThrow(code));

        System.out.println(diceThrow("2D10"));
        System.out.println(diceThrow("D6-5"));
        System.out.println(diceThrow("2D3"));
    }

    public static int diceThrow(String code){
        int result = 0;
        Random random = new Random();

        //jaki index ma D
        int dIndex = -1;
        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == 'D'){
                dIndex = i;
            }
        }

        //jaki indeks ma znak
        int signIndex = -1;
        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == '+' || code.charAt(i) == '-'){
                signIndex = i;
            }
        }

        //ile scian ma kostka
        int diceRange = 0;
        if(signIndex >= 0) {
            diceRange = Integer.parseInt(code.substring(dIndex+1, signIndex));
        }
        else {
            diceRange = Integer.parseInt(code.substring(dIndex+1));
        }

        //ile rzutów
        int throwCounter = 1;
        if(dIndex > 0){
            throwCounter = Integer.parseInt(code.substring(0,dIndex));
        }

        //dodaj lub odejmij od wuniku
        int shift = 0;
        if(signIndex > 0){
            shift = Integer.parseInt(code.substring(signIndex));
        }



        for(int i = 0; i < throwCounter; i++){
            int temp = (random.nextInt(diceRange)+1);
            result += temp;
            //System.out.println((i+1)+ ". rzut: " + temp);
        }
        result += shift;

        return result;
    }
}
