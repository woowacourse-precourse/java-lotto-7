package lotto.core.controller;

import java.util.List;
import lotto.core.domain.model.GameResult;
import lotto.core.domain.model.Lotto;
import lotto.core.domain.model.Lottos;
import lotto.core.domain.model.Money;
import lotto.core.domain.model.User;
import lotto.core.view.OutputView;
import lotto.system.Config.SystemConfig;


public class GameController {
    private User user;
    private Money money;
    private Lotto answer;
    private int bonusNumber;
    private int ticketAmount;
    private final SystemConfig systemConfig;

    private final InputController inputController;
    private final OutputView outputView;

    private GameController(InputController inputController, OutputView outputView,SystemConfig config) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.money = new Money();
        this.user = new User();
        this.systemConfig = config;
    }
    public static GameController initialize(InputController inputController, OutputView outputView) {
        SystemConfig config = SystemConfig.getInstance();
        return new GameController(inputController,outputView,config);
    }

    public void run() {
        this.startGame();
        this.showResult();
    }
    public void startGame() {
        this.money = buyLottos();
        user = user.newInstance(money);
        Lottos userLottos = generateUserLottos(ticketAmount);
        outputView.showUserLottoMessage(userLottos);
    }

    public Money buyLottos() {
        outputView.showInputMoneyMessage();
        int givenMoney = inputController.getMoney();
        this.money.saveMoney(givenMoney);
        this.ticketAmount = money.getTicketAmount(givenMoney);
        outputView.showLottoAmountMessage(this.ticketAmount);
        return this.money;
    }

    private Lottos generateUserLottos(int ticketAmount) {
        return user.buyLottos(ticketAmount);
    }

    public void showResult() {
        getAnswerNumbers();
        showWinnerPrice();
    }

    private void getAnswerNumbers() {
        outputView.showInputLottoNumberMessage();
        List<Integer> answerNumbers = inputController.getLottoNumber();
        this.answer = Lotto.newInstance(answerNumbers);
        outputView.showInputLottoBonusNumberMessage();
        this.bonusNumber = inputController.getBonusNumber();
    }

    private void showWinnerPrice() {
        outputView.showResultHeadMessage();
        GameResult gameResult = user.matchUp(answer, bonusNumber);
        outputView.showBallCountResult(gameResult);
        outputView.showProfit(gameResult);
    }


}
