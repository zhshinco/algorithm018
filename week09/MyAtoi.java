public class MyAtoi {

    public int myAtoi(String str) {
        int len = str.length();

        char[] charArray = str.toCharArray();

        // 1、去除前缀空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、是否为全空格 "    "
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 先判断非法状况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            //每一步把符号位累乘
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}