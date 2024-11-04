package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_INPUT_GUIDE_MESSAGE = "1000 이상의 숫자를 입력해야함";
    public static final String LINE_BREAK = "\n";
    public static final String DELIMITER = ",";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public int inputPurchaseAmountGuide() {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        int amount;
        try {
            amount = Integer.parseInt(Console.readLine());
            validCanPurchaseLotto(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + AMOUNT_INPUT_GUIDE_MESSAGE);
            return inputPurchaseAmountGuide();
        }
        return calculateNumberOfTotalLotto(amount);
    }

    public void validCanPurchaseLotto(int totalAmount) {
        if (totalAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(AMOUNT_INPUT_GUIDE_MESSAGE);
        }
    }

    public int calculateNumberOfTotalLotto(int amount) {
        return amount / LOTTO_PRICE;
    }

    public WinningLotto inputWinningLotto() {
        WinningLotto winningLotto;
        try {
            Lotto lotto = inputWinnerNumber();
            int bonusNumber = inputBonusNumber();
            winningLotto = new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + "당첨 번호 중 보너스번호와 중복되는 숫자가 있습니다");
            return inputWinningLotto();
        }
        return winningLotto;
    }

    public Lotto inputWinnerNumber() {
        System.out.println(LINE_BREAK + "당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        Lotto lotto;
        try {
            checkInputEndsWithDelimiter(input);
            lotto = new Lotto(convertStringToIntList(input));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + "서식에 맞지 않는 입력이 있습니다.");
            return inputWinnerNumber();
        }
        return lotto;
    }

    private void checkInputEndsWithDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("쉼표로 끝나면 안됩니다");
        }
    }

    public int inputBonusNumber() {
        System.out.println(LINE_BREAK + "보너스 볼을 입력해 주세요.");
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
            checkNumberIsInvalid(number);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + "서식에 맞지 않는 입력이 있습니다.");
            return inputBonusNumber();
        }
        return number;
    }

    private List<Integer> convertStringToIntList(String stringWinningNumber) {
        List<String> splitedWinningNumber = splitString(stringWinningNumber);
        return splitedWinningNumber.stream()
                .map(this::checkFormattingCanBeConvertToInt)
                .map(this::checkNumberIsInvalid)
                .collect(Collectors.toList());
    }

    private List<String> splitString(String stringWinningNumber) {
        return Arrays.stream(stringWinningNumber.split(DELIMITER)).collect(Collectors.toList());
    }

    private int checkFormattingCanBeConvertToInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("서식에 맞지 않는 입력이 있습니다.");
        }
        return number;
    }

    private int checkNumberIsInvalid(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1~45 범위를 벗어나는 로또번호가 입력되었습니다");
        }
        return number;
    }

}
