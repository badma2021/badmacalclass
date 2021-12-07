package badmacalclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculation cl = new Calculation();
        String str;
        System.out.println("Enter an equation");
        try {
            str = br.readLine();

            str = cl.calculate(str, 1, 10, 1);//to set certain parameters for the calculator: input equation(str), interval between 1 and 10 numbers and using the Roman numerals(flag=1 or 0)
            System.out.println(str);

        } catch (NullPointerException e) {
            System.out.println("Please input proper characters");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please input proper characters");
        } catch (NumberFormatException e) {
            System.out.println("Please input proper characters");
        } catch (ArithmeticException e) {
            System.out.println("деление на ноль ");
        }

    }

}