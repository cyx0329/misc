/*
Smallest Substring of All Characters
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
Constraints:

[time limit] 5000ms

[input] array.character arr

1 ≤ arr.length ≤ 30
[input] string str

1 ≤ str.length ≤ 500
[output] string
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        char[] arr = new char[]{'A','B','C','E','K','I'};
        String str = "KADOBECODEBANCDDDEI";
        System.out.println(getShortestUniqueSubstring(arr, str));
        //"KADOBECODEBANCDDDEI"
    }
    
    private static String getShortestUniqueSubstring(char[] arr, String str) {
   
        Set<Character> set = new HashSet();
        for(char ch : arr) {
          set.add(ch);
        }
    
        Map<Character, Integer> map = new HashMap();

        int left = 0, right = 0;
        int start = 0, end = 0, length = Integer.MAX_VALUE;

        while(right < str.length()) {
            char ch = str.charAt(right);
            if(set.contains(ch)) {
                map.put(ch, map.getOrDefault(ch,0)+1);
            }

            while(map.size() == set.size()) {
                if(right - left < length) {
                  start = left;
                  end = right;
                  length = right-left;
                }
                char c = str.charAt(left);
                if(set.contains(c)) {
                  map.put(c, map.get(c)-1);
                  if(map.get(c) == 0) map.remove(c);
                }
                left++;
            }
            right++;
        }  
        return length == Integer.MAX_VALUE ? "" : str.substring(start, end+1);
  }
}
