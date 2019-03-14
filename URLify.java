public class URLify {

    private int countNumberSpaces (String a){
        char[] url = a.toCharArray();
        int count = 0;
        for(char x : url){
            if(x==' ')
                count++;
        }
        return count;
    }

    private String replaceSpaces (String a){
        int numberOfSpaces = countNumberSpaces(a);
        int newLength = a.length() + 2*numberOfSpaces;
        char result[] = new char[newLength];
        System.out.println(a.length());
        //System.out.println(a.length());
        for(int i = a.length()-1 ; i >=0; i--){
            if(a.charAt(i)== ' ') {
                result[newLength-1]= '#';
                result[newLength-2]='2';
                result[newLength-3]='1';
                newLength = newLength-3;
            }
            else{
                result[newLength-1]= a.charAt(i);
                newLength--;
            }
        }
        return new String(result);
    }

    public static void main(String args[]){
        URLify urLify = new URLify();
        String url = "Mr John Smith ";
        System.out.println(urLify.replaceSpaces(url));
    }

}
