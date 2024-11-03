package lotto.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Vaildator.InputValidator;
import lotto.controller.CheckerController;

public class LottoService {
    private final List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private static int payment;

    private int lottoCount;

    public void buyLottos(int amount) {
        payment = amount;
        lottoCount = amount / 1000;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    public static int getPayment() {
        return payment;
    }

    public List<Integer> inputLottoNumbers(String input) {
        InputValidator.validInput(input);
        String[] splitNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitNumbers) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        InputValidator.bonusDuple(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void checkResult() {
        CheckerController.checkResult(lottos, winningNumbers, bonusNumber);
    }
}
