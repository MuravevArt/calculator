import java.util.HashMap;
import java.util.Map;

public class Parse {
    //соответствие римские-арабские числа (I..X, 1..10)
    final Map<String, Integer> romeArabMap = new HashMap<>();

    //соответствие римские-арабские наименования чисел
    final int[] arabDigit = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    final String[] romeDigit = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public Parse() {
        romeArabMap.put("I", 1);
        romeArabMap.put("II", 2);
        romeArabMap.put("III", 3);
        romeArabMap.put("IV", 4);
        romeArabMap.put("V", 5);
        romeArabMap.put("VI", 6);
        romeArabMap.put("VII", 7);
        romeArabMap.put("VIII", 8);
        romeArabMap.put("IX", 9);
        romeArabMap.put("X", 10);
    }

    //Проверка, что это Арабское число
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Проверка, что это Римское число в пределах от I до X
    public boolean isRoman(String str) {
        return romeArabMap.containsKey(str);
    }

    //Конвертация из Римского числа в Арабское в пределах от I до X
    public Integer romeToArabConvert(String st) {
        if (romeArabMap.containsKey(st)) {
            return romeArabMap.get(st);
        }
        return null;
    }

    //Конвертация из Арабского числа в Римское в пределах от 1 до 399
    public String arabToRomeConvert(Integer num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabDigit.length; i++) {
            while ((num - arabDigit[i]) >= 0) {
                num -= arabDigit[i];
                result.append(romeDigit[i]);
            }
        }
        return result.toString();
    }

    //Проверка корректности оператора, что он равен +-*/
    public boolean checkOperator(String op) {
        return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
    }

}
