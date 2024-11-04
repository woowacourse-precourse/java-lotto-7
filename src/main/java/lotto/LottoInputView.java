package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        LottoValidator.validateNumericInput(input); // 새로운 메소드
        LottoValidator.validatePurchaseInput(input);
        return Integer.parseInt(input);
    }

    public Lotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = parseNumbers(input);
        Collections.sort(numbers);
        LottoValidator.validateWinningNumbers(numbers);
        return new Lotto(numbers);
    }

    public int readBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        LottoValidator.validateNumericInput(input);
        int number = Integer.parseInt(input);
        LottoValidator.validateBonusNumber(number, winningLotto.getNumbers());
        return number;
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식으로 입력해 주세요.");
        }
    }

}
