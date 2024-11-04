package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler implements Input{

    // 1.금액 입력 기능
    @Override
    public int inputPayment() {
        String paymentStr = Console.readLine();
        validatePaymentInput(paymentStr);
        return parsePayment(paymentStr);
    }
    private void validatePaymentInput(String paymentStr) {
        if (paymentStr.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열 입니다.");
        }
        if (!paymentStr.matches("\\d+")) { // 숫자로만 이루어졌는지 확인
            throw new IllegalArgumentException("[ERROR] 결제 금액은 숫자여야 합니다.");
        }
    }

    private int parsePayment(String paymentStr) {
        try {
            return Integer.parseInt(paymentStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자 범위를 초과했습니다.");
        }
    }

    // 2.당첨 번호 입력 기능
    @Override
    public List<Integer> inputWinningNumbers() {
        String winningNumbersStr = Console.readLine();
        return parseWinningNumbers(winningNumbersStr);
    }

    private List<Integer> parseWinningNumbers(String winningNumbersStr) {
        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String winningNumber : winningNumbersStr.split(",")) {
            int number = parseWinningNumber(winningNumber.trim());
            validateWinningNumber(number, uniqueNumbers);
            winningNumbers.add(number);
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        return winningNumbers;
    }

    private int parseWinningNumber(String winningNumberStr) {
        try {
            return Integer.parseInt(winningNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private void validateWinningNumber(int number, Set<Integer> uniqueNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.");
        }
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다.");
        }
    }

    // 3. 보너스 번호 입력 기능
    @Override
    public int inputBonusNumber() {
        String bonusNumberStr = Console.readLine();
        validateBonusNumberInput(bonusNumberStr);
        return parseBonusNumber(bonusNumberStr);
    }

    private void validateBonusNumberInput(String bonusNumberStr) {
        if (bonusNumberStr.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열 입니다.");
        }
        if (!bonusNumberStr.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private int parseBonusNumber(String bonusNumberStr) {
        int bonus;
        try {
            bonus = Integer.parseInt(bonusNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자 범위를 초과했습니다.");
        }
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
        }
        return bonus;
    }
}
