import java.util.Scanner;

class MAIN
{
    public static void main(String[] args) {
        double temp,  speed ;
        Object newtemp,newspeed;
        Converter converter;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the method number you want to opt:-");
        System.out.println("1.Thermometer\n2.Thermocouple\n3.PilotTube\n4.ShaftLog\n");
        int choice= input.nextInt();
        switch(choice)
        {
            case 1 :  System.out.println("Enter a temperature value in Celcius scale :");
                      temp = input.nextDouble();
                       converter = new Thermometer();
                       newtemp= converter.convert(temp);
                      System.out.println("Temperature in Farenheit scale: "+newtemp);
                      System.out.println("Is temperature "+temp+"deg Celcius is hot: "+((Thermometer)converter).isHot(temp));
                      break;
            case 2 :  System.out.println("Enter a temperature value in Celcius scale :");
                       temp = input.nextDouble();
                      converter = new Thermocouple();
                       newtemp= converter.convert(temp);
                      System.out.println("Temperature in Kelvin scale: "+newtemp);
                      System.out.println("Is temperature "+temp+"deg Celcius is hot: "+((Thermocouple)converter).isHot(temp));
                      break;
            case 3 :  System.out.println("Enter a speed value in kms scale :");
                       speed = input.nextDouble();
                       converter = new PitotTube();
                      newspeed= converter.convert(speed);
                      System.out.println("Speed in mach scale: "+newspeed);
                      System.out.println("Is "+speed+" kms is fast :"+((PitotTube)converter).isFast(speed));
                      break;
            case 4 :  System.out.println("Enter a speed value in kmh scale :");
                      speed = input.nextDouble();
                       converter = new ShaftLog();
                       newspeed= converter.convert(speed);
                      System.out.println("Speed in mph scale: "+newspeed);
                      System.out.println("Is "+speed+" kmh is fast :"+((ShaftLog)converter).isFast(speed));
                      break;
            default :
                        System.out.println(" Please choose with proper choice.");
        }

       
    }
}

interface Converter
{
   public Object convert(Object obj);
}

abstract class TemperatureConverter implements Converter
{
    protected abstract boolean isHot(double T);
   public abstract  Object convert(Object obj);
    
}

abstract class SpeedConverter implements Converter
{
    protected abstract boolean isFast(double S);
   public abstract Object convert(Object obj);
    
}

class Thermometer extends TemperatureConverter
{
   public Object convert(Object obj)
   {
      double TempinF = (double)obj*1.8+32;//conversion of the temperature from Celcius to Farenheit
      return(TempinF);
   } 

   protected  boolean isHot(double T)
   {
     return(T>30); 
   }
}

class Thermocouple extends TemperatureConverter
{
   public Object convert(Object obj)
   {
      double TempinK = (double)obj + 273.15;// conversion of temp from celcius to kelvin
      return(TempinK);
   } 
   protected  boolean isHot(double T)
   {
     return(T>30); 
    }
}

class PitotTube extends SpeedConverter
{
  public  Object convert(Object obj)
   {
      double mach= (double)obj*2.941176;// conversion from kms to mach
      return(mach);
   }

   protected  boolean isFast(double S)
    {
       return (S>10);
    }
}

class ShaftLog extends SpeedConverter
{
   public Object convert(Object obj)
   {
      double mph= (double)obj*0.621371;// conversion from kmh to mph
      return(mph);
   }
   protected  boolean isFast(double S)
    {
      return(S>40);
    }
}

/*1.it is possible to call  the convert method on an instance of thermometer because 
thermometer is inheriting the class TemperatureConverter which implements the Converter interface.
Same goes with pilotTube as it is inheriting the class SpeedConverter.And if a Java class implements any interface,
the object instance can be referenced as instance of interface.

2.Since converter is a instance of interface Converter, so it can only access the methods available in the intyerface Converter.
As if we implement an interface and provide body to its method in that class.We can hold the object of that class using a reference 
variable of the interface.But using this we can only access methods of interface only, accessing other methods of the class gives
a compile time error.

3. Typecasting is a process of converting one type , which could be class or interface to another, keeping in mind that the classes 
or interfaces are from the same hierarchy.In this program Thermometer , Thermocouple , PilotTube , ShaftLog are sub class of the class 
that implements this interface. Typecasting the converter instance into any of these sub class ,changes its type to that particular class,
so it can now be able to access all the methods of the class.

*/
