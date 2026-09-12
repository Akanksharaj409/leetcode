class Solution {
    static class State {
        long score;
        ArrayList<Integer> ids;

        State() {
            score = 0;
            ids = new ArrayList<>();
        }

        State(long score, ArrayList<Integer> ids) {
            this.score = score;
            this.ids = ids;
        }
    }

    State better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        int n = Math.min(a.ids.size(), b.ids.size());

        for (int i = 0; i < n; i++) {
            if (!a.ids.get(i).equals(b.ids.get(i))) {
                return a.ids.get(i) < b.ids.get(i) ? a : b;
            }
        }

        return a.ids.size() <= b.ids.size() ? a : b;
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> {
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[0], y[0]);
        });

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = a[i][1];
        }

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int left = a[i][0];

            int lo = 0;
            int hi = i - 1;
            int pos = -1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (ends[mid] < left) {
                    pos = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            prev[i] = pos;
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 4; k++) {
                State skip = dp[i - 1][k];

                State base = dp[prev[i - 1] + 1][k - 1];

                ArrayList<Integer> ids = new ArrayList<>(base.ids);
                ids.add(a[i - 1][3]);
                Collections.sort(ids);

                State take = new State(
                    base.score + a[i - 1][2],
                    ids
                );

                dp[i][k] = better(skip, take);
            }
        }

        ArrayList<Integer> result = dp[n][4].ids;

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}