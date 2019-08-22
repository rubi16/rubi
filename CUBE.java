public class CUBE
    {
        public static void main(String[] args)
            {
            
                float num1=5;
                float num2=3;

            
                float result =cube(num1) + cube(num2) + mul(mul(3,mul(num1,num2)),(num1+num2));
                System.out.println("the result of (2+4)^3 =\n"+result);
            }
        public static float cube(float num)
            {
                return (num*num*num);
            }
        public static float mul(float num1 ,float num2)
            {
                return(num1*num2);
            }
        public static float sqr(float num)
            {
                return(num*num);
            }

    }