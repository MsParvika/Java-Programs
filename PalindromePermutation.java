public class PalindromePermutation {

    private boolean checkPermutations(String input){
        int[] frequency = new int[26];
        int oddCount= 0;
        for(char a : input.toCharArray()) {
            if(a-'a' >=0) {
                frequency[a - 'a']++;
                if (frequency[a - 'a'] % 2 == 0)
                    oddCount--;
                else
                    oddCount++;
            }
        }
        return oddCount <= 1;
    }

    public static void main(String arg[]){
        String test = "taco bbact";
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.checkPermutations(test));
    }


}
