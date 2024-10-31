package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {
        LottoMachine lottoMachine = inputPrice();
        OutputView.getLottoList(lottoMachine);

        Lotto winnerLotto = inputWinnerLotto();
        int bonus = inputBonus(winnerLotto);
    }

    private static LottoMachine inputPrice() {
        try {
            int price = InputView.inputPrice();
            return new LottoMachine(price);
        } catch (IllegalArgumentException e) {
            InputView.errorPrint(e.getMessage());
            return inputPrice();
        }
    }

    private static Lotto inputWinnerLotto() {
        while (true) {
            try {
                return new Lotto(numberParse());
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private static int inputBonus(Lotto winnerLotto) {
        while (true) {
            try {
                int bonus = InputView.inputBonus();
                return checkContains(winnerLotto, bonus);
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private static int checkContains(Lotto winnerLotto, int bonus) {
        if (winnerLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 숫자입니다.");
        }
        return bonus;
    }

    private static List<Integer> numberParse() {
        List<Integer> winnerNumbers = new ArrayList<>();
        while (true) {
            try {
                List<String> inputNumbers = InputView.inputNumbers();

                for (String lotto : inputNumbers) {
                    winnerNumbers.add(Integer.parseInt(lotto));
                }
                return winnerNumbers;
            } catch (NumberFormatException e) {
                InputView.errorPrint("당첨 번호는 숫자로만 작성해 주세요.");
            }
        }
    }
}
