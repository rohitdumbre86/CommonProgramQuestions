package com.algorithm.string;

public class NumberProblem
{

   private boolean isValidNumber(String number)
   {
       if(number==null || number.trim().isEmpty()) return false;
       
       number = number.trim();
       
       
       if(number==null || number.trim().isEmpty()) return false;
       
       number = number.trim();
       
       String expr1 = "(-|\\+)*(\\d)*\\.{0,1}(\\d)+";
       String expr2 = "(-|\\+)*(\\d)+\\.{0,1}(\\d)*";
       String expr3 = "("+expr1+"|"+expr2+")"+"e(-|\\+){0,1}(\\d)+";
       
       if(number.matches(expr1)){
           return true;
       }
       else if(number.matches(expr2)){
           return true;
       }
       else if(number.matches(expr3)){
           return true;
       }
      
           
       return false;
   }
    
    
    public static void main(String[] args)
    {
        NumberProblem problem = new NumberProblem();
        System.out.println(problem.isValidNumber("-1"));
        System.out.println(problem.isValidNumber("1.4"));
        System.out.println(problem.isValidNumber("1e4"));
        System.out.println(problem.isValidNumber("1e4"));
        System.out.println(problem.isValidNumber("-.0"));
        System.out.println(problem.isValidNumber("43.e6"));

        
    }

}
