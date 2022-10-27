import java.util.*;

public class Main {

    public static void main(String arg[]) {

        Scanner snc = new Scanner(System.in);

        int n = snc.nextInt();

        int k = snc.nextInt();

        Main main = new Main();

        System.out.println(main.minimumNumbers(n, k));

    }

    //寻找多重集的最小长度
    public int minimumNumbers(int num, int k) {
        if (num==0) {
            return 0;
        }
        if (k==0 && num%10==0) {
            return 1;
        }
        for(int n=1;n<12;n++) {
            if ((k * n)%10 == num % 10 && k*n <= num) {
                return n;
            }
        }
        return -1;
    }
}
//        int min_len = 0;
//        int flag = 0;
//        int first_num = k;
//        int second_num = first_num + 10;
//
//        for(;first_num<num/2;){
//            second_num = second_num + 10;
//            if (second_num > num) {
//                first_num = first_num + 10;
//                second_num = first_num + 10;
//            }
//            if ((first_num + second_num) == num) {
//                min_len++;
//                flag =1;
//                System.out.println(first_num);
//                System.out.println(second_num);
//            }
//        }
//
//        if (flag == 0){
//            return -1;
//        }
//        else{
//            return min_len;
//        }


