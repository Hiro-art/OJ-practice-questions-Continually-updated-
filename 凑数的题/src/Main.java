//import java.util.*;
//
////感觉有点类似分治法的思想
//public class Main {
//
//    //判断能否算出24
//    public boolean judgePoint24(int[] nums,int n) {
//
////code here
//
//        if(n==1){
//            if(nums[0] == 24){
//                return true;
//            }else{
//                return false;
//            }
//        }
//        int[] rest_2 = new int[4];
//        //初始化剩余2元素数组
//        for(int g=0;g<4;g++){
//            rest_2[g] = 0;
//        }
//
//        //首先枚举两个数的组合
//        for (int i=0;i<n-1;i++){
//            for (int j=i+1;j<n;j++) {
//                //将剩下的两个数放入数组当中
//                int index = 0;
//                for (int k = 0; k < n; k++) {
//                    if (k != i && k != j) {
//                        rest_2[index++] = nums[k];
//                    }
//                }
//
//                rest_2[index] = nums[i] + nums[j];
//                if (judgePoint24(rest_2, index + 1)) {
//                    return true;
//                }
//                rest_2[index] = nums[i] - nums[j];
//                if (judgePoint24(rest_2, index + 1)) {
//                    return true;
//                }
//                rest_2[index] = nums[i] * nums[j];
//                if (judgePoint24(rest_2, index + 1)) {
//                    return true;
//                }
//                if(nums[i] != 0) {
//                    rest_2[index] = nums[j] / nums[i];
//                    if (judgePoint24(rest_2, index + 1)) {
//                        return true;
//                    }
//                }
//                if(nums[j] != 0) {
//                    rest_2[index] = nums[i] / nums[j];
//                    if (judgePoint24(rest_2, index + 1)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//// code here
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        Main slt = new Main();
//
//        int[] num = new int[4];
//
//        for (int i = 0; i < 4; i++) num[i] = sc.nextInt();
//
//        System.out.println(slt.judgePoint24(num,4));
//    }
//
//}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<int[]> Permutation(int[] a) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (j == k || k == i)
                        continue;
                    for (int m = 0; m < 4; m++) {
                        if (m == k || m == j || m == i)
                            continue;
                        int[] b = new int[] { a[i], a[j], a[k], a[m] };
                        arrayList.add(b);
                    }
                }
            }
        }
        return arrayList;
    }

    private static double getNum(double a, int b, char ch) {
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static String getPoint24Answer(int[] num) {
        char[] t = new char[] { '+', '-', '*', '/' };
        ArrayList<int[]> intlist = Permutation(num);
        int flag = 0;
        for (int z = 0; z < intlist.size(); z++) {
            int a[] = intlist.get(z);
            for (int i = 0; i < 4; i++) {
                if ((i == 3 && (a[0] % a[1] != 0 || a[1] % a[0] != 0))) {
                    break;
                }
                double a12 = getNum(a[0], a[1], t[i]);

                for (int j = 0; j < 4; j++) {
                    if(a[2]!=0 && a12 !=0) {
                        if ((j == 3 && (a12 % a[2] != 0 || a[2] % a12 != 0))) {
                            break;
                        }
                    }

                    double a123 = getNum(a12, a[2], t[j]);

                    for (int k = 0; k < 4; k++) {
                        if ((k == 3 && (a123 % a[3] != 0 || a123 % a[3] != 0)))
                            break;

                        double a1234 = getNum(a123, a[3], t[k]);
                        if (a1234 == 24) {
                            flag = 1;
                            if(t[i] == '+' || t[i] == '-'){
                                if (t[j] == '+' || t[j]=='-'){
                                    if (t[k] == '+' || t[k]=='-'){
//                                        return "true" + "\n" + "解释：" + a[0] + t[i] + a[1]  + t[j] + a[2]  + t[k] + a[3] + " = 24";
                                        return "true";
                                    }else if (t[k] == '*' || t[k]=='/'){
//                                        return "true" + "\n" + "解释：(" + a[0] + t[i] + a[1] + t[j] + a[2] + ")" + t[k] + a[3] + " = 24";
                                        return "true";
                                    }
                                }else if (t[j] == '*' || t[k]=='/'){
                                    if (t[k] == '+' || t[k]=='-'){
//                                        return "true" + "\n" + "解释：(" + a[0] + t[i] + a[1] + ")" + t[j] + a[2]  + t[k] + a[3] + " = 24";
                                        return "true";
                                    }else if (t[k] == '*' || t[k]=='/'){
//                                        return "true" + "\n" + "解释：(" + a[0] + t[i] + a[1] + ")" + t[j] + a[2] + t[k] + a[3] + " = 24";
                                        return "true";
                                    }

                                }
                            }else if (t[i] == '*' || t[i]=='/'){
                                if (t[j] == '+' || t[j]=='-'){
                                    if (t[k] == '+' || t[k]=='-'){
//                                        return "true" + "\n" + "解释：" + a[0] + t[i] + a[1] + t[j] + a[2] + t[k] + a[3] + " = 24";
                                        return "true";
                                    }else if (t[k] == '*' || t[k]=='/'){
//                                        return "true" + "\n" + "解释：(" + a[0] + t[i] + a[1]  + t[j] + a[2] + ")" + t[k] + a[3] + " = 24";
                                        return "true";
                                    }
                                }else if (t[j] == '*' || t[k]=='/'){
                                    if (t[k] == '+' || t[k]=='-'){
//                                        return "true" + "\n" + "解释：" + a[0] + t[i] + a[1] + t[j] + a[2] + t[k] + a[3] + " = 24";
                                        return "true";
                                    }else if (t[k] == '*' || t[k]=='/'){
//                                        return "true" + "\n" + "解释：" + a[0] + t[i] + a[1] + t[j] + a[2] + t[k] + a[3] + " = 24";
                                        return "true";
                                    }
                                }
                            }
//                            return true + "\n" + "解释：(((" + a[0] + t[i] + a[1] + ")" + t[j] + a[2] + ")" + t[k] + a[3] + ") = 24";
                        }
                    }
                }
            }
        }
        if (flag == 0){
//            return "false" + "\n" + "解释：无法运算得到24";
            return "false";
        }
        return null;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Main slt = new Main();

        int[] num = new int[4];

        for (int i = 0; i < 4; i++) num[i] = sc.nextInt();

        int flag = 0;
        for(int i=0;i<4;i++){
            if(num[i] >9 || num[i]<1){
                flag = 1;
            }
        }
        if(flag==1){
            System.out.println("false");
        }else if (flag==0){
            System.out.println(getPoint24Answer(num));
        }
    }
}

