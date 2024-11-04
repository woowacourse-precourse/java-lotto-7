package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.request.LottoMoneyRequest;
import lotto.dto.response.LottoCalculateResponse;
import lotto.dto.response.LottoNumResponseList;

public class LottoView {
    public void runLotto(LottoController lottoController) {
        Money money = money();
        LottoNumResponseList lottoList = lottoController.createLotto(new LottoMoneyRequest(money.getValue()));
        lottoNum(lottoList);

        Lotto lottoAnswer = lottoAnswer();
        int bonusNum = bonusLottoNum();

        LottoCalculateResponse answer
                = lottoController.compareLotto(lottoAnswer, bonusNum, lottoList.lottoList(), money);
        OutputView.printLottoResult(answer);
    }

    private Money money() {
        Money money = InputView.moneyInput();
        OutputView.printMoney(money);

        return money;
    }

    private void lottoNum(LottoNumResponseList lottoList) {
        OutputView.printLottoNum(lottoList);
    }

    private Lotto lottoAnswer() {
        return InputView.lottoAnswerNumInput();
    }

    private int bonusLottoNum() {
        return InputView.lottoBonusNumInput();
    }
}
