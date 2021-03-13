//minimum edit distance

/*rules:

*/

class MED {
    public static void main(String[] args){
        String s1 = "perpetrate";
        String s2 = "perpetuate";
        nativeRecursive nr = new nativeRecursive(s1, s2);
        int i = nr.editDistance(s1, s2, s1.length(), s2.length());
        System.out.println(i);
    }
}

class nativeRecursive{
    //INSERT: m and n - 1
    //REMOVE: m - 1 and n
    //REPLACE: m - 1 and n - 1
    /*
        REPLACE         REMOVE          
        INSERT
    */


    String s1, s2;
    public nativeRecursive(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
        
    }
    public static int min(int x, int y, int z){
        if(x <= y && x <= z){
            return x;
        }
        if(y <= x && y <= z){
            return y;
        }
        return z;
    }
    public static int editDistance(String s1, String s2, int s1_length, int s2_length){
        int s1_D = s1_length,
            s2_D = s2_length;
        if(s1_D == 0){
            return s2_D;
        }
        if(s2_D == 0){
            return s1_D;
        }

        if(s1.charAt(s1_D - 1) == s2.charAt(s2_D - 1)){
            return editDistance(s1, s2, s1_D -1, s2_D -1);
        }

        return 1 +
            min(editDistance(s1, s2, s1_D, s2_D -1),
                editDistance(s1, s2, s1_D - 1, s2_D),
                editDistance(s1, s2, s1_D -1, s2_D - 1)
            );
    }

}