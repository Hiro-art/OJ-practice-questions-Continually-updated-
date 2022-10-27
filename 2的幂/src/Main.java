import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Main main = new Main();
        System.out.println(main.reorderedPowerOf2(n));
    }

    public boolean reorderedPowerOf2(int n) {
        int i=0;
        double data=0;
        data = pow(2,i);
        while(n>data){
            i++;
            data = pow(2,i);
        }

        if (n == data){
            return true;
        }
        else{
            return false;
        }
    }
}
