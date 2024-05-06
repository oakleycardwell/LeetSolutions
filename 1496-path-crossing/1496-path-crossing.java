class Solution {
    public boolean isPathCrossing(String path) {
        // O(1) average for insert and look up
        Set<String> visited = new HashSet<>();
        // Start at the origin
        int x = 0, y = 0;
        // Add the starting position to the set
        visited.add(x + "," + y);
        
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
            // Check if the new position is already visited
            String pos = x + "," + y;
            if (visited.contains(pos)) {
                return true;
            }
            // Add current position to set
            visited.add(pos);
        }
        
        return false;
    }
}