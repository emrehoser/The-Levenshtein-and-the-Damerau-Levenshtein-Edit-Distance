package com.company;

import java.util.*;

public class Main {
    public static void levenshtein(String firstString,String secondString){

        List<String> operation = new ArrayList<>();

        int firstSize = firstString.length()+1;
        int secondSize = secondString.length()+1;

        int[][] distanceMatrix = new int[firstSize][secondSize];

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                distanceMatrix [i][j] = 0;
            }
        }

        for(int i = 0; i < firstSize; i++){
            distanceMatrix [i][0] = i;
        }
        for(int j = 0; j < secondSize; j++){
            distanceMatrix [0][j] = j;
        }

        for(int i = 1; i < firstSize; i++){
            for (int j = 1; j < secondSize; j++){
                if (firstString.charAt(i-1) == secondString.charAt(j-1)){
                    if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j-1])
                        operation.add("Copy");
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j] + 1)
                        operation.add("Delete");
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i][j-1] + 1)
                        operation.add("Insert");

                    distanceMatrix [i][j] = Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1));
                }
                else{
                    if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j-1] + 1)
                        operation.add("Replace");
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j] + 1)
                        operation.add("Delete");
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i][j-1] + 1)
                        operation.add("Insert");

                    distanceMatrix [i][j] = Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1));
                }
            }
        }
        System.out.println(distanceMatrix[firstSize-1][secondSize-1]);

        System.out.println();

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                System.out.print(distanceMatrix [i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.print("Operations = ");
        for(int i = 0; i < operation.size(); i++) {
            System.out.print(operation.get(i) + ", ");
        }

    }
    public static void main(String[] args) {
        levenshtein("cats","fast");
    }


}


