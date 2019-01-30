package com.algorithm.arrays;

public class BinaryAddition
{
    
public String addBinary(String bA, String bB) {
        
        String binaryValue = "";
        int carryBit = 0;
        for(int iA=bA.length()-1,iB=bB.length()-1; iA>=0|| iB>=0; --iA,--iB){
            
            int intA = iA < 0 ? 0 : bA.charAt(iA)-'0';
            int intB = iB < 0 ? 0 : bB.charAt(iB)-'0';
            
            binaryValue = (char)(((carryBit+intA+intB)%2)+ (int)'0') + binaryValue;
            
            carryBit = (carryBit+intA+intB)/2 > 0 ? 1 : 0;               
            
            
        }
        
        if(carryBit >= 1){
            binaryValue = "1" + binaryValue;
        }
        
        
        return binaryValue;
    }

  public static void main(String[] args){
      BinaryAddition bAdd = new BinaryAddition();
      
      System.out.println(bAdd.addBinary("11", "1"));
  }
}
