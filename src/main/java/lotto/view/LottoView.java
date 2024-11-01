package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.util.CustomStringUtils;
import lotto.util.SingletonObjectProvider;

public class LottoView {

    private final InputView inputView;
    private final LottoController lottoController;

    public LottoView() {
        this.inputView = SingletonObjectProvider.getSingletonObject(InputView.class);
        this.lottoController = SingletonObjectProvider.getSingletonObject(LottoController.class);
    }

    public void startLottoProgram() {
        Money money = inputView.inputMoney();

        Lottoes lottoes = lottoController.createLottoes(money);
        CustomStringUtils.printLottoesStatus(lottoes);

        Lotto lotto = inputView.inputOwnLotto();
        int bonusNumber = inputView.inputBonusNumber();

    }
}