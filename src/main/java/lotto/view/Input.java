package lotto.view;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.validate.ValidateInput.*;

public class Input {
    public void inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = validateAmount(readLine());
    }

    public Lotto inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseWinningNumbers(readLine());

        validateWinningNumbers(winningNumbers);

        return new Lotto(winningNumbers);
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = validateBonusNumber(readLine());
    }

    private List<Integer> parseWinningNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .distinct()
                .toList();
    }


}
