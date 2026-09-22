class Solution {
    private int base = 1000000;

    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) {
            return 1;
        }
        int count = 1;
        String src = a;

        while(src.length()<b.length()) {
            count++;
            src += a;
        }

        if(src.equals(b)) {
            return count;
        }
        if(rabinKarp(src, b) != -1) {
            return count;
        }
        if(rabinKarp(src+a, b) != -1) {
            return count+1;
        }
        return -1;
    }

    private int rabinKarp(String src, String tar) {
        if(src.length()==0 || tar.length()==0) {
            return -1;
        }
        int m = tar.length();
        int pow = 1;

        for(int i=0; i<m; i++) {
            pow = (pow*31)%base;
        }

        int tarCode = 0;
        for(int i=0; i<m; i++) {
            tarCode = (tarCode*31 + tar.charAt(i))%base;
        }

        int hashCode = 0;
        for(int i=0; i<src.length(); i++) {
            hashCode = (hashCode*31+src.charAt(i))%base;

            if(i<m-1) {
                continue;
            }
            if(i>=m) {
                hashCode = (hashCode-src.charAt(i-m)*pow)%base;
            }
            if(hashCode < 0) {
                hashCode += base;
            }

            if(hashCode == tarCode) {
                if(src.substring(i-m+1, i+1).equals(tar)) {
                    return i-m+1;
                }
            }
        }
        return -1;
    }
}