package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoPurchaseMoney;
import lotto.processor.InputProcessor;
import lotto.processor.LottoBonusNumberProcessor;
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
        this.lottoBonusNumberInputProcessor = new LottoBonusNumberProcessor();
        this.lottoPurchaseMoneyInputProcessor = new LottoPurchaseMoneyInputProcessor();
    }

    public LottoPurchaseMoney inputLottoPurchaseMoney() {
        lottoView.print(INPUT_PURCHASE_MONEY);
        return lottoView.input(lottoPurchaseMoneyInputProcessor);
    }

    public Lotto inputJackPotLotto() {
        lottoView.println(INPUT_JACKPOT_LOTTO);
        return lottoView.input(lottoInputProcessor);
    }

    public LottoBonusNumber inputLottoBonusNumber() {
        lottoView.println(INPUT_BONUS_NUMBER);
        return lottoView.input(lottoBonusNumberInputProcessor);
    }
}
