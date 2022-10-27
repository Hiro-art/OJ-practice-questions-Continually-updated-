import java.util.*;
public class Main {
    public static void main(String arg[]) {
        Scanner snc =new Scanner(System.in);

        int n =snc.nextInt();
        int k =snc.nextInt();
        List<Integer> nums= new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(snc.nextInt());
        }
        System.out.println(k_dis((ArrayList<Integer>) nums,k));
    }
    public static int k_dis (ArrayList<Integer> nums, int k) {
        int len = nums.size();
        int count = 0;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i==j){
                    continue;
                }
                else {
                    if ((nums.get(i) - nums.get(j)) == k ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
} 