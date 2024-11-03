package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public Lotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = parseNumbers(input);
        return new Lotto(numbers);
    }

    public int readBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        int number = Integer.parseInt(input);
        validateBonusNumber(number, winningLotto);
        return number;
    }


    private void validateNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
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

    private void validateBonusNumber(int number, Lotto winningLotto) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


}
