package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final int MAX_REPEAT = 3;

    private int reEnterInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validate(input);
        return inputToInteger(input);
    }

    public int enterPurchaseAmount() {
        int result = 0;
        while (true) {
            try {
                result = reEnterInputPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    private Lotto reEnterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> inputWinningNumbers = Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        return new Lotto(inputWinningNumbers);
    }

    public Lotto enterWinningNumbers() {
        Lotto lotto = null;
        while (true) {
            try {
                lotto = reEnterWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private int reEnterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        bonusNumberValidate(input);
        Integer number = inputToInteger(input);
        return number;
    }

    private void bonusNumberValidate(String input) {
        if(input.length() >= 3 || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 수만 입력할 수 있습니다.");
        }
    }

    public int enterBonusNumber() {
        int bonusNumber = 0;
        while (true) {
            try {
                bonusNumber = reEnterBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void validate(String input) {
        blankValidate(input);
        unitValidate(input);
    }

    private void unitValidate(String input) {
        Integer value = inputToInteger(input);
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 한 장의 가격은 1,000원입니다. 1,000원 단위로 입력해주세요.");
        }
    }

    private void blankValidate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private Integer inputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
