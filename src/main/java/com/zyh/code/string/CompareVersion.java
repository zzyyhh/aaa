package com.zyh.code.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangyinghui  Date: 2020/8/30 Time: 11:01 PM
 */
public class CompareVersion {
//    https://leetcode-cn.com/company/kuaishou/
    //from https://leetcode-cn.com/problems/compare-version-numbers/solution/bi-jiao-ban-ben-hao-by-leetcode/

    /**
     * 示例 1:
     * 输入: version1 = "0.1", version2 = "1.1"
     * 输出: -1
     * 示例 2:
     * 输入: version1 = "1.0.1", version2 = "1"
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
     * 输出: -1
     * 示例 4：
     * <p>
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
     * 示例 5：
     * <p>
     * 输入：version1 = "1.0", version2 = "1.0.0"
     * 输出：0
     * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
     * 链接：https://leetcode-cn.com/problems/compare-version-numbers
     *
     * @param v1
     * @param v2
     * @return
     */
    private static int compare(String v1, String v2) {
        if (StringUtils.isEmpty(v1)) {
            return -1;
        }
        if (StringUtils.isEmpty(v2)) {
            return 1;
        }
        if (StringUtils.equals(v1, v2)) {
            return 0;
        }
        //to string[]
        String[] v1Array = v1.split("\\.");
        String[] v2Array = v2.split("\\.");

        //按个位去比较
        int i = 0;
        int j = 0;
        while (i < v1Array.length || j < v2Array.length) {
            int v1Value = i < v1Array.length ? Integer.valueOf(v1Array[i]) : 0;
            int v2Value = j < v2Array.length ? Integer.valueOf(v2Array[j]) : 0;
            if (v1Value > v2Value) {
                return 1;
            }
            if (v1Value < v2Value) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compare("1.0","1.0.0"));
        System.out.println(compare("1.01","1.001"));
        System.out.println(compare("7.5.2.4","7.5.3"));
    }
}
