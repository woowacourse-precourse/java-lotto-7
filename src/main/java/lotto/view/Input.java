package lotto.view;

import lotto.domain.Lotto;
import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.validate.ValidateInput.*;

public class Input {
    public int inputPurchaseAmount(){
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputAmount = readLine();

                return validateAmount(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputWinningNumbers(){
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> winningNumbers = parseWinningNumbers(readLine());

                validateWinningNumbers(winningNumbers);

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(){
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = readLine();

                return validateBonusNumber(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
