package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.core.domain.Lotto;
import lotto.core.domain.Money;
import lotto.core.domain.WinnerLotto;
import lotto.system.Config.SystemConfig;
import lotto.system.input.InputView;
import lotto.system.output.OutputView;

public class AppController {
    private final Set<Lotto> lottos;
    private final Money money;
    private final WinnerLotto winnerLotto;
    private final InputView inputView;
    private final OutputView outputView;
    private final SystemConfig systemConfig;

    private AppController(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
        this.money = new Money();
        this.winnerLotto = new WinnerLotto();
        this.lottos = new HashSet<>();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static AppController initialize() {
        SystemConfig config = SystemConfig.getInstance();
        return new AppController(config);
    }

    public void run() {
        try {
            systemConfig.startSystem();
            buyLottos();
            checkLottoResult();
        } catch (RuntimeException  e) {
            OutputView.showErrorMessage(String.valueOf(e));
        } finally {
            systemConfig.shutdown();
        }
    }

    public void buyLottos() {
        String input = inputView.showInputMoneyMessage();
        money.inputMoney(input);
        int quantity = money.countQuantity();
        generateLottos(quantity);
        outputView.showQuantityMessage(quantity);
    }

    public void checkLottoResult() {
        winnerLotto.createWinnerLotto();
        winnerLotto.matchWinnerLotto(lottos);
        winnerLotto.showResultBoard();
        int prize = winnerLotto.calculatePrize();
        outputView.showIncomeRate(money.calculateIncomeRate(prize));
    }

    public void generateLottos(int quantityOfLotto) {
        for (int i = 0; i < quantityOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            showGeneratedLottos(numbers);
        }
    }

    private void showGeneratedLottos(List<Integer> LottoNumbers) {
        outputView.showLotto(LottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}