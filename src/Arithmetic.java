import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    private int num1, num2; //числа в выражении
    private String operator; //математический оператор в выражении

    //выполнение арифметического выражения (целые числа)
    public int calcExp(int n1, String op, int n2) {
        int res;
        switch (op) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            default:
                throw new AssertionError();
        }

        return res;
    }

    public String result(String exp) throws CalcException {
        boolean isRomanExp; //Признак, что числа Римские
        Parse parse = new Parse();

        //Разделяем string разделителем " ".
        List<String> expItems = Arrays.asList(exp.split(" "));

        //Проверка, что 3 элемента.
        if (expItems.size() != 3) {
            throw new CalcException("Ошибка! Пожалуйста, соблюдайте условия ввода! Он должен соответствовать \"Число Оператор Число\" с пробелами");
        }

        //Проверка, что оператор +-*/
        if (parse.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new CalcException("Ошибка! Оператор должен быть: + - * /");
        }

        //Проверка, что числа либо оба Арабские, либо оба Римские
        if (parse.isNumeric(expItems.get(0)) && parse.isNumeric(expItems.get(2))) {
            num1 = Integer.parseInt(expItems.get(0));
            num2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (parse.isRoman(expItems.get(0)) && parse.isRoman(expItems.get(2))) {
            num1 = parse.romeToArabConvert(expItems.get(0));
            num2 = parse.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {
            throw new CalcException("Ошибка! Числа должны быть либо оба Арабские, либо оба Римские!");
        }

        //Проверка, что оба числа от 1 до 10 включительно
        if (!(num1 >= 1 && num1 <= 10)) {
            throw new CalcException("Ошибка! Первое число должно быть от 1 до 10 включительно!");
        }
        if (!(num2 >= 1 && num2 <= 10)) {
            throw new CalcException("Ошибка! Второе число должно быть от 1 до 10 включительно!");
        }

        //Получение результата
        int res = calcExp(num1, operator, num2);

        //Если числа Римские, то конвертируем в Римские и возвращаем результат. Если отрицательное, добавляем -.
        if (isRomanExp) {
            String sign = res < 0 ? "-" : "";
            return sign + parse.arabToRomeConvert(Math.abs(res));
        }

        //Возвращаем ответ арабское число
        return String.valueOf(res);
    }
}
