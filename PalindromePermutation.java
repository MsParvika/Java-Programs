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

    private boolean checkPermutations2(String input){
        int frequencyBits = 0;
        for(char a : input.toCharArray()) {
            if(a-'a' >=0) {
                if((frequencyBits & 1<<(a - 'a')) == 0)
                    frequencyBits = frequencyBits | 1<<(a - 'a');
                else
                    frequencyBits = frequencyBits & ~(1<<(a - 'a'));
            }
        }
        return (frequencyBits & (frequencyBits-1)) == 0;
    }

    public static void main(String arg[]){
        String test = "taco bbact";
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.checkPermutations(test));
        System.out.println(palindromePermutation.checkPermutations2(test));

    }


}
