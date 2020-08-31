package com.zyh.company.kuaishou;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyinghui  Date: 2020/8/31 Time: 9:47 PM
 */
public class LongestSubstringWithoutRepeatingChar {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     */

    //是一个滑动窗口问题
//    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/longest-substring-without-repeating-characters-b-2/


    private static int longestSubstringWithoutRepeatingChar(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }

        int len = 0;
        int[] m = new int[128];

        for (int i = 0, j = 0; j < str.length(); j++) {
            i = Math.max(m[str.charAt(j)], i);
            len = Math.max(len, j - i + 1);
            m[str.charAt(j)] = j + 1;

        }

        return len;
    }

    private static int longestSubstringWithoutRepeatingChar1(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }

        int len = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < str.length(); j++) {

            if(!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
            } else {
                //移动i
                i++;
                //删除
                set.remove(str.charAt(j));
            }

        }

        return len;
    }

}
