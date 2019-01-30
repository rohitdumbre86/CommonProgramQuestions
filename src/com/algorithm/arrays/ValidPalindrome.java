package com.algorithm.arrays;

/**
 * 
 * 
 * 
 **/
public class ValidPalindrome
{
    
    public boolean isValidPalindrome(String s){
        
        char[] palids = s.toCharArray();
        
        for(int i=0; i<palids.length; i++){
            int k = palids.length-1-i;
            
            if(palids[i]!=palids[k]){
                
                if(isPalindromeValid(palids,i+1,k) || isPalindromeValid(palids,i,k-1)){
                    return true;
                }
                
            }      
        }
        
        
        return false;
    }
    
    
    
    
    private boolean isPalindromeValid(char[] palids, int i, int k)
    {
       for(int j=i; j<= (k+i)-j; j++){
           if(palids[j]!=palids[(k+i)-j]){
               return false;
           }
       }
       
       return true;
    }




    public static void main(String[] args){
        
        
        ValidPalindrome valids = new ValidPalindrome();
        valids.isValidPalindrome("abca");
        
    }

}
