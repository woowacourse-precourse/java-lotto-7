package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class LottoView {
    public int getInputPurchaseAmount() {
        try {
            System.out.println("구매금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            validateAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPurchaseAmount();
        }
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public List<Integer> getInputWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해주세요.");
            String input = Console.readLine();
            return parseNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputWinningNumbers();
        }
    }

    public int getInputBonusNumber() {
        try {
            System.out.println("보너스 번호를  입력해주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            return getInputBonusNumber();
        }
    }

    public void displayLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }
}
