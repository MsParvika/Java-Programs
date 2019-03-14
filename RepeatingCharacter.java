
public class RepeatingCharacter {

    static int FirstRepeated(String str)
    {
        // An integer to store presence/absence 
        // of 26 characters using its 32 bits. 
        int checker = 0;

        for (int i = 0; i < str.length(); ++i)
        {
            int val = (str.charAt(i)-'a');
            // If bit corresponding to current
            // character is already set 
            if ((checker & (1 << val)) > 0) {
                System.out.println("oh" + val + "  this is  " +checker  + " shiftt " + (1<<val));
                return i;
            }
            // set bit in checker 
            checker = checker | (1 << val);
            System.out.println(val + "  this is  " +checker  + " shiftt " + (1<<val));

        }

        return -1;
    }

    // Driver code 
    public static void main(String args[])
    {
        String s = "abcfdeacf";
        //String s = "abcdefghijklmnopqrstuvwxyz";
        int i=FirstRepeated(s);
        if (i!=-1)
            System.out.println("Char = "+ s.charAt(i) + "   and Index = "+i);
        else
            System.out.println( "No repeated Char");
    }
} 