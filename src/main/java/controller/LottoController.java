package controller;

import domain.LottoMachine;
import domain.LottoPlay;
import domain.User;
import java.util.List;
import service.UserService;
import util.DependencyFactory;
import valid.Task;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UserService userService;
    private LottoPlay lottoPlay;

    public LottoController(DependencyFactory factory) {
        this.inputView = factory.getInputView();
        this.outputView = factory.getOutputView();
        this.userService = factory.getUserService();
    }

    public void run() {
        initLottoPlay();
        playLotto();
        winningResultView();
    }

    private void initLottoPlay() {
        User user = initUser();
        initUserLottos(user);
        LottoMachine lottoMachine = initLottoMachine();
        this.lottoPlay = new LottoPlay(user, lottoMachine);
    }

    private User initUser() {
        return Task.reTryTaskUntilSuccessful(() -> new User(inputView.inputPurchaseAmount()));
    }

    private void initUserLottos(User user) {
        userService.issueLotto(user);
        outputView.outputPurchaseLottoAmount(user.getLottos());
    }

    private LottoMachine initLottoMachine() {
        List<Integer> winningNumbers = Task.reTryTaskUntilSuccessful(() -> inputView.inputWinningNumbers());
        int bonusNumber = Task.reTryTaskUntilSuccessful(() -> inputView.inputBonusNumber(winningNumbers));
        return new LottoMachine(winningNumbers, bonusNumber);
    }

    private void playLotto() {
        lottoPlay.drawLottos();
        userService.updateRateOfReturn(lottoPlay.getUser());
    }

    private void winningResultView() {
        outputView.outputWinningStatistics(lottoPlay.getRankResult().getRankResult());
        outputView.outputRateOfReturn(lottoPlay.getUser().getRateOfReturn());
    }
}
