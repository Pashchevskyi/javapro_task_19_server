package ua.ithillel.lms;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ServerSocket socket = new ServerSocket(8080);
        socket.getRequest(System.out::println);
        socket.prepareResponse("This is RESPONSE on request ");
    }
}
