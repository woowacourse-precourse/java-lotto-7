package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.dto.request.LottoCalculateRequest;
import lotto.dto.request.LottoGenerateRequest;
import lotto.dto.response.LottoCalculateResponse;
import lotto.util.SingletonObjectProvider;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoController lottoController;

    public LottoView() {
        this.inputView = SingletonObjectProvider.getSingletonObject(InputView.class);
        this.outputView = SingletonObjectProvider.getSingletonObject(OutputView.class);
        this.lottoController = SingletonObjectProvider.getSingletonObject(LottoController.class);
    }

    public void startLottoProgram() {
        Money money = inputView.inputMoney();

        Lottoes lottoes = lottoController.createLottoes(LottoGenerateRequest.from(money)).lottoes();
        outputView.printLottoesStatus(lottoes);

        Lotto lotto = inputView.inputOwnLotto();
        int bonusNumber = inputView.inputBonusNumber(lotto);

        LottoCalculateResponse result =
                lottoController.calculateLotto(LottoCalculateRequest.of(lottoes, lotto, bonusNumber, money));

        outputView.printLottoResult(result);
    }
}