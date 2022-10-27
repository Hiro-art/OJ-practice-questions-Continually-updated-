import java.util.Scanner;

public class Main {
    public static int consecutiveNumbersSum2(int N) {
        while ((N & 1) == 0) {
            N >>= 1;
        }
        int res = 1;
        // O(根号N)
        for (int i = 3; i * i <= N; i += 2) {
            int count = 1;
            while (N % i == 0) {
                N /= i;
                count++;
            }
            // rest *= （计数+1）
            res *= count;
        }
        return N == 1 ? res : (res << 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        System.out.println(consecutiveNumbersSum2(N));
    }

}

