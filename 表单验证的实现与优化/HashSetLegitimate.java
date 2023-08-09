package com.youfeng.blog;

import java.util.HashSet;

/**
 * @author -侑枫
 * @date 2023/7/30 17:43:00
 */
public class HashSetLegitimate {
    /**
     * 使用HashSet存储输入字符串中出现的字符，以便后续匹配验证。
     */
    private final HashSet<Character> charSet;

    /**
     * 构造函数，在对象创建时初始化charSet为一个新的空HashSet。
     */
    public HashSetLegitimate() {
        charSet = new HashSet<>();
    }

    /**
     * 将输入的字符串中的字符逐个添加到charSet中。
     * @param inputString 输入的字符串
     */
    public void addCharsToSet(String inputString) {
        for (char c : inputString.toCharArray()) {
            charSet.add(c);
        }
    }

    /**
     * 验证给定的匹配字符串是否与用户的用户名和密码匹不匹配。
     * 如果匹配字符串中的任何字符在charSet中出现，返回false，表示不匹配；否则返回true，表示匹配。
     * @param match 违禁字符
     * @param user 用户信息
     * @return 结果集
     */
    public boolean isMatch(String match, User user) {
        addCharsToSet(user.getUserName());
        addCharsToSet(user.getPassword());
        for (char c : match.toCharArray()) {
            if (charSet.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public void main(String[] args) {
        HashSetLegitimate hashSetLegitimate = new HashSetLegitimate();
        String match = "user123";
        User user = new User();
        user.setPassword("abcdefgh12345678");
        user.setUserName("!abcdefgh12345678");
        boolean isValid = hashSetLegitimate.isMatch(match, user);
        System.out.println("Is valid: " + isValid);
    }
    static class User {
        private String userName;
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

