/**
 * 判断字符串是不是数字
 * @author Jan on 2018/7/29.
 * @version 1.0
 */
public class Solution9 {
    /**字符串转数字判读，函数转换法
     *
     * 字符数组转字符串new String（charArray）
     * @param str
     * @return
     */
    public boolean isNumber(char [] str){
        try {
            double ret = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * []表示里面的内容只有一个会出现，[\+\-]只会+或-
     * ?表示前面的内容可出现0次或1次，[\+\-]?表示可能会有+、-中一个
     * d数字，等价于[0-9]
     * （*）表示前面的内容出现任意次 d*即：数字出现任意次（可以0次，.12也算数字）
     * ()表示子串，(\.\d*)?表示出现小数的串
     * +匹配前面的子表达式一次或多次
     * ([eE][\-\+]?[0-9]+)?科学记数法匹配
     * @param str
     * @return
     */
    public boolean isNumber1(char [] str){
        return new String(str).matches("[\\+\\-]?\\d*(\\.\\d*)?([eE][\\-\\+]?[0-9]+)?");
    }

}
