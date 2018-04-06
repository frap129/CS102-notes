package cs102.notes;

public class RecursiveFactorials {

    private static final int FACTORIAL = 9999;

    public static void main(String[] args) {
	    long start = System.currentTimeMillis();
	    int factorial = factorialRecursive(FACTORIAL);
	    long stop = System.currentTimeMillis() - start;
	    System.out.println("With recursion: " + stop +"ms");
        start = System.currentTimeMillis();
        factorial = factorialFor(FACTORIAL);
        stop = System.currentTimeMillis() - start;
        System.out.println("With a for loop: " + stop +"ms");
        start = System.currentTimeMillis();
        factorial = factorialWhile(FACTORIAL);
        stop = System.currentTimeMillis() - start;
        System.out.println("With a while: " + stop +"ms");
    }

    private static int factorialRecursive(int n){
        if (n == 0) return 1;
        else if (n == 1) return n * (n - 1);
        else return n * factorialRecursive(n - 1);
    }

    private static int factorialFor(int n){
        int result = 1;
        for(int i = n - 1; i > 1; i--) {
            result = result * n;
            n--;
        }
        return result;
    }
    private static int factorialWhile(int n){
        int result = 1;
        while(n >= 1){
            result = result * n;
            n--;
        }
        return result;
    }
}
