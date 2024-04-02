class Solution {
    // Lookup table for gcd values
    private int[][] gcdLookup = new int[51][51];
    
    // Initialize GCD lookup table
    private void initGcdLookup() {
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                gcdLookup[i][j] = gcd(i, j);
            }
        }
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    // Convert edge list to tree shape
    private List<List<Integer>> buildTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }
    
    // Optimized DFS to find coprimes using a last seen depth map
    private void dfs(int node, int parent, int[] nums, List<List<Integer>> tree, int[] ans, int[][] lastSeen, int depth) {
        int bestDepth = -1, ancestor = -1;
        // Check against all possible values
        for (int i = 1; i <= 50; i++) {
            if (gcdLookup[nums[node]][i] == 1 && lastSeen[i][0] > bestDepth) {
                bestDepth = lastSeen[i][0];
                ancestor = lastSeen[i][1];
            }
        }
        ans[node] = ancestor;
        
        // Save the previous state and update the current state
        int[] prevState = {lastSeen[nums[node]][0], lastSeen[nums[node]][1]};
        lastSeen[nums[node]][0] = depth;
        lastSeen[nums[node]][1] = node;
        
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node, nums, tree, ans, lastSeen, depth + 1);
            }
        }
        
        // Backtrack to the previous state
        lastSeen[nums[node]][0] = prevState[0];
        lastSeen[nums[node]][1] = prevState[1];
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        initGcdLookup(); // Initialize the GCD lookup table
        int n = nums.length;
        List<List<Integer>> tree = buildTree(n, edges);
        int[] ans = new int[n];
        // Initialize the last seen depth map for each value
        int[][] lastSeen = new int[51][2]; // [value][0] = depth, [value][1] = node
        for (int[] row : lastSeen) Arrays.fill(row, -1); // -1 indicates not seen
        dfs(0, -1, nums, tree, ans, lastSeen, 0);
        return ans;
    }
}