package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.core.domain.Lotto;
import lotto.core.domain.Money;
import lotto.core.domain.ScoreBoard;
import lotto.core.domain.WinnerLotto;
import lotto.system.Config.SystemConfig;
import lotto.system.input.InputView;
import lotto.system.message.Message;
import lotto.system.message.MessageType;
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
        this.inputView = new InputView(systemConfig.getInputMessageQueue(),systemConfig.getOutputMessageQueue());
        this.outputView = new OutputView(systemConfig.getOutputMessageQueue());
    }

    public static AppController initialize() {
        SystemConfig config = SystemConfig.getInstance();
        return new AppController(config);
    }


    public void run() throws InterruptedException {
        try {
            systemConfig.startSystem();
            buyLottos();
            checkLottoResult();
            systemConfig.stopSystem();
        } catch (RuntimeException  | InterruptedException e) {
            systemConfig.getOutputMessageQueue().put(new Message(MessageType.SYSTEM_OUTPUT,String.valueOf(e)));
        } finally {
            systemConfig.shutdown();
        }
    }

    public void buyLottos() {
        try {
            getMoney();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        int quantity = money.countQuantity();
        generateLottos(quantity);
        outputView.showQuantityMessage(quantity);
    }
    private void getMoney() throws InterruptedException {
        try {
            String input = inputView.showInputMoneyMessage();
            money.inputMoney(input);
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage("잘못된 입력입니다. 다시 입력해주세요.");
            getMoney();
        }
    }
    public void checkLottoResult() throws InterruptedException{
        String number = inputView.showInputLottoNumberMessage();
        String BonusNumber = inputView.showInputBonusNumberMessage();
        winnerLotto.createWinnerLotto(number,BonusNumber);
        winnerLotto.matchWinnerLotto(lottos);
        List<ScoreBoard.ResultDto> results = winnerLotto.getResultBoard();
        results.forEach(result -> outputView.showResultOfBoard(result.getSituation(), result.getCount()));
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