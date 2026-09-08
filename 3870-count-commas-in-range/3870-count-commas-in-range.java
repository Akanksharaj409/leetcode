class Solution {
    public int countCommas(int n) {
        int ans = 0;
        // if(n.length < 4) {
        //     return ans;
        // }
        
        // int curr = n;
        // for(int i=1; i<=n; i++) {
            
        // }
        // return n.length%3;

        for(int power=1000; power<=n; power*=1000) {
            ans += n-power+1;

            if(power> n/1000) {
                break;
            }
        }

        return ans;
    }
}