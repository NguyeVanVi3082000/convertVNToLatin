package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        // write your code here
        System.out.println(convert("Gói cước đã chọn là gói đặc biệt, chỉ dành cho khách hàng cá nhân"));

    }


    public static String convert(String input) {
        Map<String, String> map = new HashMap<>();


        String unicodeA = "\\u00E0 \\u00E1 \\u1EA1 \\u1EA3 \\u00E3 \\u00E2 \\u1EA7 \\u1EA5 \\u1EAD \\u1EA9 \\u1EAB \\u0103 \\u1EB1 \\u1EAF \\u1EB7 \\u1EB3 \\u1EB5";
        String unicodeE = "\\u00E8 \\u00E9 \\u1EB9 \\u1EBB \\u1EBD \\u00EA \\u1EC1 \\u1EBF \\u1EC7 \\u1EC3 \\u1EC5";
        String unicodeI = "\\u00EC \\u00ED \\u1ECB \\u1EC9 \\u0129";
        String unicodeO = "\\u00F2 \\u00F3 \\u1ECD \\u1ECF \\u00F5 \\u00F4 \\u1ED3 \\u1ED1 \\u1ED9 \\u1ED5 \\u1ED7 \\u01A1 \\u1EDD \\u1EDB \\u1EE3 \\u1EDF \\u1EE1";
        String unicodeU = "\\u00F9 \\u00FA \\u1EE5 \\u1EE7 \\u0169 \\u01B0 \\u1EEB \\u1EE9 \\u1EF1 \\u1EED \\u1EEF";
        String unicodeY = "\\u1EF3 \\u00FD \\u1EF5 \\u1EF7 \\u1EF9";
        String unicodeD = "\\u0111";


        String vnCodeA = "à á ạ ả ã â ầ ấ ậ ẩ ẫ ă ằ ắ ặ ẳ ẵ";
        String vnCodeE = "è é ẹ ẻ ẽ ê ề ế ệ ể ễ";
        String vnCodeI = "ì í ị ỉ ĩ";
        String vnCodeO = "ò ó ọ ỏ õ ô ồ ố ộ ổ ỗ ơ ờ ớ ợ ở ỡ";
        String vnCodeU = "ù ú ụ ủ ũ ư ừ ứ ự ử ữ";
        String vnCodeY = "ỳ ý ỵ ỷ ỹ";
        String vnCodeD = "đ";


        List<String> allUniCode = Arrays.asList(unicodeA, unicodeE, unicodeI, unicodeO, unicodeU, unicodeY, unicodeD);
        List<String> allVNCode = Arrays.asList(vnCodeA, vnCodeE, vnCodeI, vnCodeO, vnCodeU, vnCodeY, vnCodeD);


        for (int i = 0; i < allUniCode.size(); i++) {
            List<String> unicode = Arrays.asList(allUniCode.get(i).split(" "));
            List<String> vnCode = Arrays.asList(allVNCode.get(i).split(" "));
            for (int j = 0; j < unicode.size(); j++) {
                map.put(unicode.get(j), vnCode.get(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (map.containsValue(String.valueOf(input.charAt(i)))) {
                String keyByValue = getKeyByValue(map, String.valueOf(input.charAt(i)));
                sb.append(keyByValue);
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String getKeyByValue(Map<String, String> map, String value) {
        Optional<String> first = map.keySet().stream().filter(item -> map.get(item).equals(value)).findFirst();
        return first.get();
    }
}
