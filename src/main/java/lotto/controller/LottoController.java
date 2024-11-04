package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Match;
import lotto.service.LottoCompany;
import lotto.service.LottoMachine;
import lotto.view.OutputView;
import lotto.view.message.SystemMessage;

public class LottoController {

    private final LottoCompany lottoCompany = new LottoCompany();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<Lotto> lotteries = lottoMachine.getLotteries();
        outputView.printLotteries(lotteries);
        Lotto lotto = lottoCompany.setWinningNumber();
        lottoCompany.setBonusNumber(lotto);
        List<Match> matches = lottoCompany.getWinningStatics(lotteries);
        outputView.printStatics(SystemMessage.PRINT_STATICS.getMessage(), matches);
        outputView.printROI(lottoCompany.calculateROI(matches));
    }
}
