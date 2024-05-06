class Solution {
    public boolean isPathCrossing(String path) {
        // O(1) average for insert and look up
        Set<Integer> visited = new HashSet<>();
        // Start at the origin
        int x = 0, y = 0;
        // Add the starting position to the set
        visited.add(0);
        
        for (char direction : path.toCharArray()) {
            // Update coordinates based on the direction
            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            
            // Hash value, large enough that coordinates do not intersect
            int hash = y * 10000 + x;
            
            // Check if the new position is already visited, if not add to set
            if (!visited.add(hash)) {
                return true; // Return if the path crosses itself
            }
        }
        // No crossed paths found
        return false;
    }
}