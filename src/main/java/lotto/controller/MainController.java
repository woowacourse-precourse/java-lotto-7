package lotto.controller;

import java.util.List;
import lotto.domain.CustomLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStatistics;
import lotto.view.InputView;
import lotto.view.LottoDto;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Integer price = inputView.scanPrice();
        LottoMachine lottoMachine = new LottoMachine(new CustomLottoGenerator());
        List<Lotto> purchasedLottos = lottoMachine.generateLottos(price);
        outputView.printPurchasedLottoList(purchasedLottos.stream()
                .map(LottoDto::createLottoDto)
                .toList());

        Lotto winningLotto = new Lotto(inputView.scanWinningLotto()
                .getNumbers());
        Integer bonusNumber = inputView.scanBonusNumber(new LottoDto(winningLotto.getNumbers()));
        outputView.printLottoStatistics(
                LottoStatistics.createLottoStatisticsDto(
                        LottoStatistics.calcStatistics(purchasedLottos, winningLotto, bonusNumber))
        );
    }
}
