package com.company;

import java.util.*;

public class Main {

    public static void levenshtein(String firstString,String secondString){

        int firstSize = firstString.length()+1;
        int secondSize = secondString.length()+1;

        //matrix that holds operations path
        String[][] pathMatrix = new String[firstSize][secondSize];

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                pathMatrix [i][j] = "";
            }
        }
        //edit table matrix
        int[][] distanceMatrix = new int[firstSize][secondSize];

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                distanceMatrix [i][j] = 0;
            }
        }
        //base conditions
        for(int i = 1; i < firstSize; i++){
            pathMatrix [i][0] = pathMatrix[i-1][0] + "Insert(" + firstString.charAt(i-1) + ")-";
            distanceMatrix [i][0] = i;
        }
        for(int j = 1; j < secondSize; j++){
            pathMatrix [0][j] = pathMatrix[0][j-1] + "Insert(" + secondString.charAt(j-1) + ")-";
            distanceMatrix [0][j] = j;
        }

        //levenshtein algorithm
        for(int i = 1; i < firstSize; i++){
            for (int j = 1; j < secondSize; j++){
                if (firstString.charAt(i-1) == secondString.charAt(j-1)){

                    if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j] + 1)
                        pathMatrix[i][j] = pathMatrix[i-1][j] + "Delete(" + firstString.charAt(i-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i][j-1] + 1)
                        pathMatrix[i][j] = pathMatrix[i][j-1] + "Insert(" + secondString.charAt(j-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j-1])
                        pathMatrix[i][j] = pathMatrix[i-1][j-1] + "Copy(" + firstString.charAt(i-1) + ")-";

                    distanceMatrix [i][j] = Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1));

                }
                else{

                    if(Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j] + 1)
                        pathMatrix[i][j] = pathMatrix[i-1][j] + "Delete(" + firstString.charAt(i-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i][j-1] + 1)
                        pathMatrix[i][j] = pathMatrix[i][j-1] + "Insert(" + secondString.charAt(j-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j-1] + 1){
                        pathMatrix[i][j] = pathMatrix[i-1][j-1] + "Replace(" + firstString.charAt(i-1) + ", " + secondString.charAt(j-1) + ")-" ;
                    }

                    distanceMatrix [i][j] = Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1));
                }
            }
        }

        System.out.println("Edit Distance: " + distanceMatrix[firstSize-1][secondSize-1]);

        System.out.println();

        System.out.println("Edit Table");
        System.out.println();

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                System.out.print(distanceMatrix [i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Operations = "+ pathMatrix[firstSize-1][secondSize-1].substring(0,pathMatrix[firstSize-1][secondSize-1].length()-1));

        System.out.println();
    }
    public static void dameraulevenshtein(String firstString,String secondString){

        int firstSize = firstString.length()+1;
        int secondSize = secondString.length()+1;

        //operation path matrix
        String[][] pathMatrix = new String[firstSize][secondSize];

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                pathMatrix [i][j] = "";
            }
        }
        //edit table matrix
        int[][] distanceMatrix = new int[firstSize][secondSize];

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                distanceMatrix [i][j] = 0;
            }
        }
        //base conditions
        for(int i = 1; i < firstSize; i++){
            pathMatrix [i][0] = pathMatrix[i-1][0] + "Insert(" + firstString.charAt(i-1) + ")-";
            distanceMatrix [i][0] = i;
        }
        for(int j = 1; j < secondSize; j++){
            pathMatrix [0][j] = pathMatrix[0][j-1] + "Insert(" + secondString.charAt(j-1) + ")-";
            distanceMatrix [0][j] = j;
        }

        //levenshtein algorithm
        for(int i = 1; i < firstSize; i++){
            for (int j = 1; j < secondSize; j++){
                if (firstString.charAt(i-1) == secondString.charAt(j-1)){

                    if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j] + 1)
                        pathMatrix[i][j] = pathMatrix[i-1][j] + "Delete(" + firstString.charAt(i-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i][j-1] + 1)
                        pathMatrix[i][j] = pathMatrix[i][j-1] + "Insert(" + secondString.charAt(j-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j-1])
                        pathMatrix[i][j] = pathMatrix[i-1][j-1] + "Copy(" + firstString.charAt(i-1) + ")-";

                    distanceMatrix [i][j] = Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1));

                }
                else{

                    if(Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j] + 1)
                        pathMatrix[i][j] = pathMatrix[i-1][j] + "Delete(" + firstString.charAt(i-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i][j-1] + 1)
                        pathMatrix[i][j] = pathMatrix[i][j-1] + "Insert(" + secondString.charAt(j-1) + ")-";
                    else if(Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1)) == distanceMatrix[i-1][j-1] + 1){
                        pathMatrix[i][j] = pathMatrix[i-1][j-1] + "Replace(" + firstString.charAt(i-1) + ", " + secondString.charAt(j-1) + ")-" ;
                    }

                    distanceMatrix [i][j] = Math.min(distanceMatrix[i-1][j-1] + 1, Math.min(distanceMatrix[i-1][j] + 1, distanceMatrix[i][j-1] + 1));
                }
                //damerau levenshtein part
                if (i > 1 && j > 1){
                    if(firstString.charAt(i-2) == secondString.charAt(j-1)){
                        if(firstString.charAt(i-1) == secondString.charAt(j-2)){
                            if(Math.min(distanceMatrix[i][j],distanceMatrix[i-2][j-2] + 1) == distanceMatrix[i-2][j-2] + 1)
                                pathMatrix[i][j] = pathMatrix[i-2][j-2] + "Transpose(" + firstString.charAt(i-2) + ", " + firstString.charAt(i-1) + ")-";
                            distanceMatrix[i][j] = Math.min(distanceMatrix[i][j],distanceMatrix[i-2][j-2] + 1);

                        }
                    }
                }

            }
        }

        System.out.println("Edit Distance: " + distanceMatrix[firstSize-1][secondSize-1]);

        System.out.println();

        System.out.println("Edit Table");
        System.out.println();

        for(int i = 0; i < firstSize; i++){
            for(int j = 0;j < secondSize; j++){
                System.out.print(distanceMatrix [i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.print("Operations = "+ pathMatrix[firstSize-1][secondSize-1].substring(0,pathMatrix[firstSize-1][secondSize-1].length()-1));

    }
    public static void main(String[] args) {

        String firstString = args[0];
        String secondString = args[1];

        levenshtein(firstString, secondString);
        dameraulevenshtein(firstString, secondString);
    }
}


