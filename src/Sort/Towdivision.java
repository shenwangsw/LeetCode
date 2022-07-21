package Sort;

public class Towdivision {

    public static void main(String[] args) {
        int [] ints = {1,2,3,4,67,5,8,78,10};
        maxmin(0,ints.length-1,ints);
    }
    public static int maxmin(int LIndex,int RIndex,int[] ints){
       int lmax= ints[0];
       int lmin = ints[0];
       int rmax = ints[0];
       int rmin = ints[0];
       int max = 0;
       int min =0;
       int mid = 0;
       if (LIndex==RIndex){
           max= ints[LIndex];
           min = ints[LIndex];
       }
       else if(LIndex == RIndex-1){
            if(ints[LIndex]<ints[RIndex]){
                max = ints[RIndex];
                min = ints[LIndex];
            }
            else {
                max = ints[LIndex];
                min = ints[RIndex];
            }
       }
       else{
            mid = LIndex+RIndex/2;
            //max


       }
        return 0;

    }


}