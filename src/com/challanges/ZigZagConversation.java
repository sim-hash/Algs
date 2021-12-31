package com.challanges;

public class ZigZagConversation {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert2("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {

        char[] letters = s.toCharArray();
        int len = letters.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx] = sb[idx].append(letters[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx] = sb[idx].append(letters[i++]);
            }
        }
        for (int j = 1; j < sb.length; j++) {
            sb[j] = sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }

    // Time: O(n)
    // Space: O(n)
    public static String convert2(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder();
        }
        int len = s.length();
        int index = 0;
        int increment = 1;
        for (int i = 0; i < len; i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) {
                increment = 1;
            }
            if (index == numRows - 1) {
                increment = -1;
            }
            index += increment;
        }
        for(int i = 1; i < sb.length; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
