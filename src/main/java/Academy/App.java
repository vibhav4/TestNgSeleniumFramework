package Academy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");

        String s1 = "Shipra";

        String s2 = "Shipra";

        String s3 = new String("Shipra");

        String s4 = new String("Shipra");

        System.out.println(s1==s2);

        System.out.println(s1.equals(s2));

        System.out.println(s3 == s4);

        System.out.println(s3.equals(s4));

        System.out.println(s3==s1);
    }
}
