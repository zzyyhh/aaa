package com.zyh.company.kuaishou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinghui.zhang on 2020/9/1
 */
public class Letter {
    /**
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     */
    // 数字到号码的映射
   static Map<Character, String> phoneMap = new HashMap<Character, String>() {
        private static final long serialVersionUID = -1789487564140827221L;
        {
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    // 路径
    private static StringBuilder sb = new StringBuilder();

    // 结果集
    private static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) { return res; }
        backtrack(digits, 0);
        return res;
    }

    // 回溯函数
    private static void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = phoneMap.get(digits.charAt(index));
        for (char ch : val.toCharArray()) {
            sb.append(ch);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
