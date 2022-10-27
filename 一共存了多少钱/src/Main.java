import java.util.*;

public class Main {

    public static void main(String arg[]) {

        Scanner snc = new Scanner(System.in);

        int n = snc.nextInt();

        System.out.println(totalMoney(n));

    }

    public static int totalMoney(int n) {

        int num = 1;
        int total = 0;
        int monday = 1;

        for (int i = 1; i <= n; i++) {
            total += num;
            num++;
            if(i%7==0){
                monday++;
                num = monday;
            }
        }

        return total;
    }
}
