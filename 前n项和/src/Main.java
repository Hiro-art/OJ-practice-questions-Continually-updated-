import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int start = 1;
        int sum=0;
        for (int i=0;i<num;i++){
            sum += start;
            start++;
        }
        System.out.println(sum);
    }
}
