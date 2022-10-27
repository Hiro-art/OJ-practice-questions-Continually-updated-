import java.util.Scanner;

import static java.lang.Math.max;

public class Main {

    public static int countDigitOne(int n){
        int res=0;
        for(int k=1;k<=n;k*=10){
            int i=k;
            res += (n / (i*10) ) * i + Math.min(max(( n % (i*10) ) - i + 1,0), i);
            i*=10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(countDigitOne(num));
    }

}
