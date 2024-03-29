package questions;

import com.dsa.Answer;

public class ReverseInteger {
    public static void main(String[] args) {
        int reversedInteger = ReverseInteger.reverse(-153423);
        Answer.print(reversedInteger, "Reverse Integer");
    }

    private static int reverse(int number) {
        boolean negative = number < 0;
        if (negative) {
            number = Math.negateExact(number);
        }
        int reversedNumber = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            number = number / 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
        }
        return negative ? -reversedNumber : reversedNumber;
    }
}
