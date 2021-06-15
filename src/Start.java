import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) {
        try {
            System.out.println("Введите данные в формате: Число действие число. Пробелы обязательны");
            System.out.println("Программа принимает как арабские, так и римские цифры");
            System.out.println("Числа от 1 до 10, или от I до X включительно:");

            BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
            String str = brReader.readLine();

            Arithmetic arithmetic = new Arithmetic();
            String result = arithmetic.result(str);
            System.out.println(result);

        }
        catch (CalcException | IOException e) {

        }


    }
}
