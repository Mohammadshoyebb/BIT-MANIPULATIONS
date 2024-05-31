public class Odd_or_Even{
    public static void oddEven(int n){
        int bitMask = 1;

        if((n & bitMask) == 0){
            System.out.println("Number is even ");
        }
        else{
            System.out.println("Number is odd");
        }
    }
    public static void main(String[] args) {
        int n = 5;
        oddEven(n);
        int a = 89;
        oddEven(a);
        int b = 80;
        oddEven(b);

    }
}