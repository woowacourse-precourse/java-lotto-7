package controller;

import convert.InputConvertor;
import domain.LottoMachine;
import domain.LottoPlay;
import domain.User;
import java.util.List;
import service.LottoMachineService;
import service.UserService;
import valid.Task;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView(new InputConvertor());
    private final OutputView outputView = new OutputView();
    private LottoPlay lottoPlay;

    private final UserService userService = new UserService();
    private final LottoMachineService lottoMachineService = new LottoMachineService();

    public void run() {
        initLottoPlay();
        playLotto();
    }

    private void initLottoPlay(){
        User user = initUser();
        LottoMachine lottoMachine = initLottoMachine();
        this.lottoPlay = new LottoPlay(user, lottoMachine);
    }

    private void playLotto() {
        lottoPlay.drawLottos();
        userService.updateRateOfReturn(lottoPlay.getUser());
        outputView.outputWinningStatistics(lottoPlay.getRankResult().getRankResult());
        outputView.outputRateOfReturn(lottoPlay.getUser().getRateOfReturn());
    }

    private User initUser() {
        User user = Task.reTryTaskUntilSuccessful(() -> userService.init(inputView.inputPurchaseAmount()));
        userService.issueLotto(user);
        outputView.outputPurchaseLottoAmount(user.getLottos());
        return user;
    }

    private LottoMachine initLottoMachine() {
        List<Integer> winningNumbers = Task.reTryTaskUntilSuccessful(() -> inputView.inputWinningNumbers());
        int bonusNumber = Task.reTryTaskUntilSuccessful(() -> inputView.inputBonusNumber());
        return lottoMachineService.initLottoMachine(winningNumbers, bonusNumber);
    }
}
