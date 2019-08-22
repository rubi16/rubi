import java.util.Scanner;
public class QSORT
{
    public static void main(String[] args)
    {
        System.out.println("This is a quicksort program.");
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size=input.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the elements in array one by one.");
        for(int i=0;i<size;i++)
        {
            arr[i]=input.nextInt();
        }
        for(int i=0;i<size;i++)
        {
            System.out.println("arr"+i+" ="+arr[i]);
        }
        qsort(arr,0,size-1);
        System.out.println("The array after quick sort is---");
        for(int i=0;i<size;i++)
        {
            System.out.println("arr"+i+" ="+arr[i]);
        }
    }
    public static void qsort(int arr[],int start,int end)
    {
        if(start<end)
        {
            int pindex= partition(arr,start,end);
            qsort(arr,start,pindex-1);
            qsort(arr,pindex+1,end);
        }
       
    }
    public static int partition(int arr[],int start,int end)
    {
        int pivot=arr[end];
        int pindex=start;
        for(int i=start;i<=end-1;i++)
        {
            if(arr[i]<=pivot)
            {
                int temp=arr[i];
                arr[i]=arr[pindex];
                arr[pindex]=temp;
                pindex++;
            }
        }
        int temp=arr[end];
        arr[end]=arr[pindex];
        arr[pindex]=temp;
        return pindex;
    }
}