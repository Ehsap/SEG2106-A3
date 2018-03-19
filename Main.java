/**
 * Justin Huynh
 * 7745112
 * SEG2106 Assignment 3
 */

import java.io.*;

public class Main {

    static final int ERROR = 0;
    static final int OK = 1;
    static String token;
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static String getNextToken(){
        try {
            return bufferedReader.readLine();
        }
        catch(IOException ex){
            return "error reading file";
        }
    }

    public static void main(String[]args){
        String fileName = "input2.txt";

        try{
             fileReader = new FileReader("Assignment3Files/" + fileName);
             bufferedReader = new BufferedReader(fileReader);

             token = getNextToken();

             if (program() == ERROR || token.equals("$") != true){

                 System.out.println("ERROR");
             }
             else{
                 //return OK;
                 System.out.println("SUCCESS");
             }
        }
        catch(IOException ex){
            System.out.println("File not found!");
        }

    }

    static int program(){
        if(token.equals("begin")){
            token = getNextToken();
            statement_list();
            if (token.equals("end")){
                token = getNextToken();
                return OK;
            }
        }
        return ERROR;
    }

    static int statement_list(){
        if (statement() == ERROR ){
            return ERROR;
        }
        else return statement_list_prime();

    }

    static int statement(){
        if (token.equals("id")){
            token = getNextToken();
            if (token.equals("=")){
                token = getNextToken();
                return expression();
            }
        }
        return ERROR;
    }

    static int statement_list_prime(){
        if (token.equals(";")){
            token = getNextToken();
            return statement_list();
        }
        else if(token.equals(";")){
            return OK;
        }
        else return ERROR;

    }

    static int expression(){
        if (factor() == ERROR){
            return ERROR;
        }
        else return expression_prime();

    }

    static int expression_prime(){
        if (token.equals("+")){
            token = getNextToken();
            return factor();
        }
        else if(token.equals("-")){
            token = getNextToken();
            return factor();
        }
        else return OK;

    }

    static int factor(){
        if (token.equals("num")){
            token = getNextToken();
            return OK;
        }
        else if (token.equals("id")){
            token = getNextToken();
            return OK;
        }
        else return ERROR;

    }


}
