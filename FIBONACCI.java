import java.util.Scanner;

public class FIBONACCI
    {
        public static void main(String[] args)
        {
            Scanner input= new Scanner(System.in);
            System.out.println("This is a program of printing FIBONACCI series.");
            System.out.println("Enter the no. of terms in the series:");
            int terms= input.nextInt();
            System.out.println("Printing Fibonacci series upto "+ terms +"terms.");
            fibo(terms);
        }

    
        public static void fibo(int terms)
        {
            int term1=0; int term2=1;
            System.out.println(" "+term1+"\n "+term2);
            int termptr=2;
            while(termptr<=terms)
            {
                int nwterm= term1 + term2;
                System.out.println(" "+nwterm);
                term1=term2;
                term2=nwterm;
                termptr++;

            }
        }
    }