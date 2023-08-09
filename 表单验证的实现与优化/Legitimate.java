package com.youfeng.blog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author -侑枫
 * @date 2023/7/30 16:40:25
 */
public class Legitimate {
    public static void main(String[] args) {
        User user = new User();
        user.setPassword("abcdefgh12345678");
        user.setUserName("!abcdefgh12345678");
        System.out.println(login2(user) ? "成功" : "失败");
    }

    public static boolean login(User user) {
        if (user == null) {
            return false;
        }
        String match = "+- */!@#$%";
        for (int i = 0; i < user.getUserName().length(); i++) {
            for (int j = 0; j < match.length(); j++) {
                if (match.charAt(j) == user.getUserName().charAt(i)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < user.getPassword().length(); i++) {
            for (int j = 0; j < match.length(); j++) {
                if (match.charAt(j) == user.getPassword().charAt(i)) {
                    return false;
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        return true;
    }

    public static boolean login1(User user) {
        if (user == null) {
            return false;
        }
        List<String> list = new ArrayList<>(Arrays.asList("+", "-", " ", "*", "/", "!", "@", "#", "$", "%"));
        for (String match : list) {
            if (user.getUserName().contains(match)) {
                return false;
            }
            if (user.getPassword().contains(match)) {
                return false;
            }
        }
        return true;
    }

    public static boolean login2(User user) {
        if (user == null) {
            return false;
        }
        String pattern = "[+\\- */!@#$%]";
        return !user.getUserName().matches(".*" + pattern + ".*")
                && !user.getPassword().matches(".*" + pattern + ".*");
    }

}

class User {
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
