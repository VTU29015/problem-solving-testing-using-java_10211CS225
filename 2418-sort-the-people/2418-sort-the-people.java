class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Sort indices based on heights
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

        // Create result
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = names[index[i]];
        }

        return result;
    }
}
