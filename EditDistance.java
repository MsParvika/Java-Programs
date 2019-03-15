public class EditDistance {

        static int min(int x, int y, int z){
            if (x<=y && x<=z) return x;
            if (y<=x && y<=z) return y;
            else return z;
        }

        static int recurseSolution(String a, String b, int aLength, int bLength){
            if(aLength ==0)
                return bLength;

            if(bLength ==0)
                return aLength;

            if (a.charAt(aLength-1) == b.charAt(bLength-1))
                return recurseSolution(a,b,aLength-1, bLength-1);

            return 1 + min( recurseSolution(a,b, aLength, bLength-1),
                     recurseSolution(a, b, aLength-1, bLength),
                    recurseSolution(a, b, aLength-1, bLength-1)
            );
        }


        static int dPSolution(String a, String b, int aLength, int bLength){

            int dpTable[][] = new int[aLength+1][bLength+1];
            for(int i=0;i <= aLength;i++){
                for(int j=0 ; j <= bLength; j++){
                    if (i==0)
                        dpTable[i][j]=j;
                    else if (j==0)
                        dpTable[i][j]=i;

                    else if (a.charAt(i-1)== b.charAt(j-1))
                        dpTable[i][j]= dpTable[i-1][j-1];

                    else
                        dpTable[i][j] = 1 + min( dpTable[i][j-1], dpTable[i-1][j], dpTable[i-1][j-1]);
                }
            }
            return dpTable[aLength][bLength];
        }



    public static void main(String arg[]){
        String a = "sunday";
        String b= "saturday";
        System.out.println(recurseSolution(a,b, a.length(), b.length()));
        System.out.println(dPSolution(a,b, a.length(), b.length()));
    }
}
