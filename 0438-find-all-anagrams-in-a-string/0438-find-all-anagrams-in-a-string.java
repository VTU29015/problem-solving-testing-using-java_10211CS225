class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']--;

            // Window is larger than p
            if (right - left + 1 > p.length()) {
                count[s.charAt(left) - 'a']++;
                left++;
            }

            // Window has same length as p
            if (right - left + 1 == p.length() && allZero(count)) {
                result.add(left);
            }
        }

        return result;
    }

    private boolean allZero(int[] count) {
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
