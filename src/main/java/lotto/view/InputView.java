package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.policy.LottoPricePolicy;

public class InputView {

    public static int budget() {
        int budget;
        while (true) {
            try {
                String input = Console.readLine();
                validateNumber(input);
                validateThousandUnit(input);

                budget = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return budget;
    }

    private static void validateNumber(String input) {
        String number = "^[0-9]*$";
        if (!(input.matches(number))) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static void validateThousandUnit(String input) {
        if (Long.parseLong(input) % LottoPricePolicy.LOTTO_TICKET_PRICE.price() != 0) {
            throw new IllegalArgumentException("[ERROR] 천원단위의 구입금액을 입력해야 합니다.");
        }
    }

    public static List<Integer> winningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                String input = Console.readLine();
                validateString(input);
                winningNumbers = stringToIntegerList(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private static void validateString(String input) {
        String number = "^[0-9]*(,[0-9]*){5}";
        if (!(input.matches(number))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 양식 오류.");
        }
    }

    private static List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int bonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                String input = Console.readLine();
                validateNumber(input);
                bonusNumber = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
