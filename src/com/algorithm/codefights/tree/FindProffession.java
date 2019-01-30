package com.algorithm.codefights.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindProffession
{

    public static void main(String[] args)
    {
        System.out.println(findProfession(3, 3));
        System.out.println(findProfession(4, 2));
        System.out.println(findProfession(8, 100));
        System.out.println(findProfession(10, 470));
        System.out.println(findProfession(17, 5921));
        System.out.println(findProfession(20, 171971));
        System.out.println(findProfession(25, 16777216));
        System.out.println(findProfession(30, 163126329));


    }
    
   static String  findProfession(int level, int pos) {
       
        boolean isFirstChild = true;
        
        int actualPos = 0;
        int lvl = 0;
        while(lvl < level-1)
        {
            actualPos += (int)Math.pow(2, lvl);
            lvl++;
        }
        actualPos += pos;
        List<Boolean> childrens = new ArrayList<Boolean>();

        
        while(actualPos > 1)
        {
            if(actualPos%2==0)
            {
                childrens.add(true);
                actualPos = actualPos/2;                
            }
            else 
            {
                childrens.add(false);
                actualPos = (actualPos-1)/2;
            }
            
        }
        
        Collections.reverse(childrens);
        
        String profession = "Engineer";
        for(Boolean firstChild : childrens)
        {
               if(!firstChild)
               {
                   profession = profession.equals("Engineer") ? "Doctor" : "Engineer";   
               }
        }
        
       
       return profession;
   }
   
  

     private static void constructArrayTree(String[][] constructedTree, int currentLevel, int maxLevel){
         
         if(currentLevel >= maxLevel){
             return;
         }
         
         int currentIndex = 0;
         for(String parent : constructedTree[currentLevel]){
             
             if(parent==null) break;
              
             String firstChild = "";
             String secondChild = "";
             
             if(parent=="Engineer"){
                firstChild = "Engineer";
                secondChild = "Doctor";
             }
             else if(parent == "Doctor"){
                firstChild = "Doctor";
                secondChild = "Engineer";
             }

             constructedTree[currentLevel+1][2*(currentIndex)] = firstChild;
             constructedTree[currentLevel+1][2*(currentIndex)+1] = secondChild;
             
             currentIndex++;      
         }
         
         constructArrayTree(constructedTree, currentLevel+1, maxLevel);
      }

}
