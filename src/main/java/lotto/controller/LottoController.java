package lotto.controller;

import lotto.model.Lotto;
import lotto.model.MyLottoInfo;
import lotto.model.WinningLotto;
import lotto.dto.BonusNumberDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.WinningLotteryDto;
import lotto.utils.CheckLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private MyLottoInfo myLottoInfo;
    private WinningLotto winningLotto;

    public void purchase(){
        PurchaseAmountDto dto = InputView.inputPurchaseAmount();
        myLottoInfo = MyLottoInfo.from(dto);
        outputPurchaseInfo();
    }

    public void winnings(){
        WinningLotteryDto winningLotteryDto = InputView.inputWinningLottery();
        BonusNumberDto bonusNumberDto = InputView.inputBonusNumber();
        winningLotto = WinningLotto.from(winningLotteryDto, bonusNumberDto);
    }

    public void result(){
        myLottoInfo.getMyLotteries().forEach(lotto ->
                myLottoInfo.lottoResult(
                        CheckLotto.countEqualLottoNumbers(lotto, winningLotto.getWinningLotto().getNumbers()),
                        CheckLotto.checkContainsBonusNumber(lotto, winningLotto.getBonusNumber())
                )
        );
    }

    private void outputPurchaseInfo() {
        OutputView.outputLottoPurchaseAmount(myLottoInfo.getPurchaseLottoCount());
        OutputView.outputPurchaseLotto(myLottoInfo.getMyLotteries());
    }
}
