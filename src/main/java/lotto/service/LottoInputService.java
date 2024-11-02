package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoPurchaseMoney;
import lotto.processor.InputProcessor;
import lotto.processor.LottoBonusNumberInputProcessor;
import lotto.processor.LottoInputProcessor;
import lotto.processor.LottoPurchaseMoneyInputProcessor;
import lotto.view.LottoView;

import static lotto.message.InputMessage.*;

public class LottoInputService {

    private final LottoView lottoView;
    private final InputProcessor<Lotto> lottoInputProcessor;
    private final InputProcessor<LottoBonusNumber> lottoBonusNumberInputProcessor;
    private final InputProcessor<LottoPurchaseMoney> lottoPurchaseMoneyInputProcessor;

    public LottoInputService(LottoView lottoView) {
        this.lottoView = lottoView;
        this.lottoInputProcessor = new LottoInputProcessor();
        this.lottoBonusNumberInputProcessor = new LottoBonusNumberInputProcessor();
        this.lottoPurchaseMoneyInputProcessor = new LottoPurchaseMoneyInputProcessor();
    }

    public LottoPurchaseMoney inputLottoPurchaseMoney() {
        lottoView.print(INPUT_LOTTO_PURCHASE_MONEY);
        return lottoView.input(lottoPurchaseMoneyInputProcessor);
    }

    public Lotto inputLottoJackPot() {
        lottoView.printLine(INPUT_LOTTO_JACKPOT);
        return lottoView.input(lottoInputProcessor);
    }

    public LottoBonusNumber inputLottoBonusNumber() {
        lottoView.printLine(INPUT_LOTTO_BONUS_NUMBER);
        return lottoView.input(lottoBonusNumberInputProcessor);
    }
}
