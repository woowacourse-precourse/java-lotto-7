package lotto.validation;

import java.util.*;

import lotto.Lotto;

public class InputValid {
    public static int checkMoney(String input) throws IllegalArgumentException {
        int m = checkInt(input);
        if(m%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        if(m <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0이 아닌 값이어야 합니다.");
        }
        return m;
    }

    public static Lotto checkNumber(String input) throws IllegalArgumentException {
        String[] numstr = input.split(",");
        HashSet<Integer> numbers = new HashSet<>();
        for(String eachstr : numstr) {
            numbers.add(checkEachNum(eachstr));
        }
        return new Lotto(new ArrayList<>(numbers));
    }

    public static int checkBonus(String input, Lotto win) {
        int num = checkEachNum(input);

        return num;
    }

    public static int checkInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.");
        }
    }

    public static int checkEachNum(String input) throws IllegalArgumentException {
        int num = checkInt(input);
        if(num<1 || num>45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45의 숫자여야 합니다.");
        }
        return num;
    }
}
