package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.message.SystemMessage;

public class LottoMachine {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public List<Lotto> getLotteries() {
        int moneyAmount = inputView.moneyAmountInput(SystemMessage.INPUT_PURCHASE_MONEY_AMOUNT.getMessage());
        int lottoAmount = calculateNumberLotto(moneyAmount);
        outputView.print(lottoAmount + "개를 구매했습니다.");
        return generateLotto(lottoAmount);
    }

    public List<Lotto> generateLotto(int lottoAmount) {
        return IntStream.range(0, lottoAmount)
                .mapToObj(num ->
                        new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                                .sorted()
                                .toList()
                        )
                ).toList();
    }

    public int calculateNumberLotto(int moneyAmount) {
        return moneyAmount / 1000;
    }
}
