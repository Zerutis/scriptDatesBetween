package com.Zerutis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static int[] monthsDays = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        printBonusDatesBetween(from,to);
    }
    static void printBonusDatesBetween(int fromYear, int toYear){
        List<String> answer = new ArrayList<String>();

        for(int i = fromYear; i<toYear; i++){

            if(i%4 == 0){
                monthsDays[1]++;
            }else if(monthsDays[1] == 29){
                monthsDays[1]--;
            }
            for(int j = 1; j<=12; j++){
                for(int k = 1; k<=monthsDays[j-1]; k++){
                    String date;
                    if(j < 10 && k < 10){
                        date = i + "0" + j + "0" + k;
                    }else if(j < 10){
                        date = i + "0" + j + "" + k;
                    }else if(k < 10){
                        date = i + "" + j + "0" + k;
                    }else{
                        date = i + "" + j + "" + k;
                    }

                    String firstPart = date.substring(0,4);
                    String secondPart = date.substring(4);

                    StringBuilder sbr = new StringBuilder();
                    sbr.append(secondPart);
                    sbr.reverse();
                    if(firstPart.contains(sbr)){
                        String month = date.substring(4,6);
                        String day = date.substring(6,8);
                        answer.add(firstPart+"-"+month+"-"+day);
                    }

                }
            }
        }
        answer.forEach(a -> System.out.println(a));
    }
}
