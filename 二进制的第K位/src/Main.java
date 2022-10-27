import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.print(new Main().findKthBit(n, k));
    }

    public char findKthBit(int n, int k) {
        boolean is_reverse=false;//默认为1
        int len=1;
        while((--n)!=0){
            len=(len<<1)+1;
        }
        while(len>1){
            if((len+1)/2==k){
                return is_reverse?'0':'1';
            }
            else if((len+1)/2<k){
                is_reverse=!is_reverse;
                k=len-k+1;
            }
            len>>=1;
        }
        return is_reverse?'1':'0';
    }
}