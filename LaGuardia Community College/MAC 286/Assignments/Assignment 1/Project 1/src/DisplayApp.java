import java.io.*;

class DisplayApp
{
    public static void main(String[] args) throws IOException
    {
        Queue theQueue = new Queue(5); // queue holds 5 items
        long value;
        while(true)
        {
            System.out.println("Enter first letter of:");
            System.out.print("show, insert, remove, exit: ");
            int choice = getChar();
            switch(choice)
            {
                case 's':
                    theQueue.display();
                    break;
                case 'i':
                    if( !theQueue.isFull() )
                    {
                        System.out.print("Enter value to insert: ");
                        value = getLong();
                        theQueue.insert(value);
                        theQueue.display();
                    }
                    else
                        System.out.print("*** Queue is full ***\n");
                    break;
                case 'r':
                    if( !theQueue.isEmpty() )
                    {
                        value = theQueue.remove();
                        System.out.println("Removed " + value);
                        theQueue.display();
                    }
                    else
                        System.out.print("*** Queue is empty ***\n");
                    break;
                case 'e':
                    System.exit(0);
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()
    //-------------------------------------------------------------
    //-------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        if(s.length() == 0) // if immediate Enter
            return '#';
        else
            return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static long getLong() throws IOException
    {
        String s = getString();
        return (long)Integer.parseInt(s);
    }
//-------------------------------------------------------------
} // end class DisplayApp