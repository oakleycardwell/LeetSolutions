class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsFreq = new int[words.length];
        
        // Calculate frequencies for words and queries
        for (int i = 0; i < words.length; i++) {
            wordsFreq[i] = f(words[i]);
        }
        Arrays.sort(wordsFreq); // Sort for efficient comparison
        
        int[] queriesFreq = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queriesFreq[i] = f(queries[i]);
        }
        
        // Count how many words have a greater smallest char frequency
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int freq : wordsFreq) {
                if (queriesFreq[i] < freq) {
                    count++;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }

    // Calculate frequency of the smallest character in a string
    private int f(String s) {
        int[] charCount = new int[26]; 
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (int count : charCount) {
            if (count > 0) {
                return count; 
            }
        }
        // For empty strings
        return 0; 
    }
}