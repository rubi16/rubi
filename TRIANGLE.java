import java.util.Scanner;

public class TRIANGLE
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        System.out.println("\n\n This is a program to check the type of triangle. ");
        System.out.println("Enter the three angles of triangle in degrees:");
        int  angle1=input.nextInt();
        int angle2=input.nextInt();
        int angle3=input.nextInt();
        int sum=angle1+angle2+angle3;
        if(sum==180)
            triangletype(angle1,angle2,angle3);
        else 
            System.out.println("sum of the degrees of three angles must be =180 ");
    }
    public static void triangletype(int angle1,int angle2,int angle3)
    {
        if(angle1>90||angle2>90||angle3>90)
            System.out.println("The given angles tells that it is a obtuse angled triangle");
        else if(angle1==90||angle2==90||angle3==90)
            System.out.println("The given angles tells that it is a right angled triangle");
        else 
            System.out.println("The given angles tells that it is a acute angled triangle");
    }
}