package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.model.Lotto;
import lotto.util.LottoInfo;

public class InputHandler {

    public int readPurchaseAmount() {
        final int amount = parseToInteger(readLine());
        validatePositive(amount);
        return amount;
    }

    public Lotto readWinningNumber() {
        final String regex = ",";
        final String input = readLine();
        validateNumbersFormat(input);
        final List<Integer> number = Arrays.stream(input.split(regex))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(number);
    }

    public int readBonusNumber() {
        final int bonusNumber = parseToInteger(readLine());
        validatePositive(bonusNumber);
        return bonusNumber;
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validatePositive(int input) {
        final int zero = 0;
        if (input < zero) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
    }

    private static void validateNumbersFormat(String input) {
        final String delimiter = ",";
        final String regex = "\\d[" + delimiter + "\\d]+" + "{" + (LottoInfo.NUMBER_COUNT.getNum() - 1) + "}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + delimiter + "를 기준으로 작성해야 합니다.");
        }
    }
}
