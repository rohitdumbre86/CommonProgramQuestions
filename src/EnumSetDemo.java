import java.util.EnumSet;

public class EnumSetDemo
{
    
    public enum RxSubChange
    {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J,
        K;
        private int flag;
        
        private RxSubChange()
        {
           this.flag = 1 << this.ordinal();
        }
        
        public static int getMask(EnumSet<RxSubChange> enums){
            int mask = 0;
          for (RxSubChange rxChange : enums){
              mask |= rxChange.flag;
          }
          
          return mask;
       
        }
        
        public static EnumSet<RxSubChange> getEnums(int mask){
            
            EnumSet<RxSubChange> set1 = EnumSet.noneOf(RxSubChange.class);
            
            for(final RxSubChange rx : values()){
               if((mask & rx.flag) > 0){
                   set1.add(rx);
               }
            }
            
            return set1;
        }
    }
    

    public static void main(String[] args)
    {
       EnumSet<RxSubChange> set1, set2,set3,set4;
       
       set1 = EnumSet.of(RxSubChange.A, RxSubChange.K);
       int mask = RxSubChange.getMask(set1);
       System.out.println(mask);
       System.out.println(RxSubChange.getEnums(mask));
       
    }

}
