public class UpdateIthBit {

    public static int setIthBit(int n,int i){
        int bitMask = 1<<i;
        return (bitMask | n);
    }

    public static int clearIthBit(int n,int i){
        int bitMask = ~(1<<i);
        return (bitMask & n);
    }

    public static int upadteIthBit(int n, int i, int newBit){
        if(newBit == 0){
            return clearIthBit(n, i);
        }
        else{
            return setIthBit(n, i);
        }
    }

//=======================================================================ANOTHER METHOD================================================================
    /*
     * public static int upadteIthBit(int n, int i, int newBit){
     * n = clearIthBit(n,i);
     * int bitMask = newBit << i ;
     * return bitMask | n ;
     * }
     */
    public static void main(String[] args) {
        System.out.println(upadteIthBit(12, 3, 0));
        System.out.println(upadteIthBit(16, 2, 1));
        System.out.println(upadteIthBit(14, 1, 0));
        System.out.println(upadteIthBit(20, 5, 1));
    }
}
