package lotto.Controller;

import lotto.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {

    private final InputView input;
    private final OutputView output;

    private List<Lotto> lotteryTickets;
    private Lotto inputLotto;
    private int bonusNumber;

    public LottoController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
        this.lotteryTickets = new ArrayList<>();
    }

    public void start() {
        int amount = input.requestPurchasePrice();
        issueLotto(amount);
        List<Integer> getNumbers = input.requestNumbers();
        int bonusNumber = input.requestBonusNumber();
        setInputNumbers(getNumbers, bonusNumber);

        output.printPurchasedLotto(lotteryTickets);
    }

    public void issueLotto(int amount) {
        for (int i=0; i<amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotteryTickets.add(new Lotto(numbers));
        }
    }

    public void setInputNumbers(List<Integer> numbers, int bonus) {
        this.inputLotto = new Lotto(numbers);
        this.bonusNumber = bonus;
    }
}
