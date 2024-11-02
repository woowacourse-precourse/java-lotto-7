package controller;

import convert.InputConvertor;
import domain.LottoMachine;
import domain.LottoPlay;
import domain.User;
import java.util.List;
import service.LottoMachineService;
import service.UserService;
import util.LottoGenerator;
import valid.Task;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView(new InputConvertor());
    private final OutputView outputView = new OutputView();
    private LottoPlay lottoPlay;

    private final UserService userService = new UserService(new LottoGenerator());
    private final LottoMachineService lottoMachineService = new LottoMachineService();

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
