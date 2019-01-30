
public class HouseRobbery
{
    
    public int houseRobber(int[] nums){
        
        for(int houseN=0; houseN<=nums.length-1; houseN++){
            
            
            int houseN2 = houseN-2 >=0 ? nums[houseN-2] : 0;
           
            nums[houseN] = nums[houseN] + houseN2;
           
          
         }

         return nums[nums.length-1] >= nums[nums.length-2] ? nums[nums.length-1] : nums[nums.length-2];
        
        
    }

    public static void main(String[] args)
    {
       final HouseRobbery robberer = new HouseRobbery();
       System.out.println(robberer.houseRobber(new int[]{1, 3, 1, 3, 100}));
    }

}
