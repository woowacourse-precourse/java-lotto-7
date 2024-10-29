package lotto;

import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;

import java.util.List;
import java.util.Map;

public class LottoManager {

    private final LottoRequestReader lottoRequestReader;
    private final LottoResponseWriter lottoResponseWriter;
    private final LottoMachine lottoMachine;
    private final LottoPrice lottoPrice;

    public LottoManager(LottoRequestReader lottoRequestReader, LottoResponseWriter lottoResponseWriter, LottoMachine lottoMachine, LottoPrice lottoPrice) {
        this.lottoRequestReader = lottoRequestReader;
        this.lottoResponseWriter = lottoResponseWriter;
        this.lottoMachine = lottoMachine;
        this.lottoPrice = lottoPrice;
    }

    public void run() {
        int purchaseMoney = lottoRequestReader.getPurchaseMoney();

        int lottoCount = purchaseMoney / lottoPrice.getPrice();
        for (int i = 0; i < lottoCount; i++) {
            lottoMachine.buyLotto();
        }

        List<Lotto> buyingLottos = lottoMachine.getBuyingLottos();
        lottoResponseWriter.responseLottoPurchase(buyingLottos);

        List<Integer> winningLottoNumbers = lottoRequestReader.getLottoNumbers();
        int bonusNumber = lottoRequestReader.getBonusNumber();

        Lotto lotto = new Lotto(winningLottoNumbers);
        Map<LottoPrize, Integer> lottoPrizeResult = lottoMachine.calculatePrize(lotto, bonusNumber);

        lottoResponseWriter.responseLottoPrize(purchaseMoney, lottoPrizeResult);
    }
}
