package lotto.function.purchase;

import java.util.List;
import lotto.domain.Lotto;
import lotto.function.purchase.processor.LottoListPrintProcessor;
import lotto.function.purchase.processor.LottoListSaveProcessor;
import lotto.function.purchase.processor.PurchasableCountCalculateProcessor;
import lotto.function.purchase.processor.PurchaseAmountInputProcessor;

public class LottoPurchase {

    private final PurchaseAmountInputProcessor purchaseAmountInputProcessor;
    private final LottoListPrintProcessor lottoListPrintProcessor;
    private final LottoListSaveProcessor lottoListSaveProcessor;
    private final PurchasableCountCalculateProcessor purchasableCountCalculateProcessor;

    public LottoPurchase(
            PurchaseAmountInputProcessor purchaseAmountInputProcessor,
            LottoListPrintProcessor lottoListPrintProcessor,
            LottoListSaveProcessor lottoListSaveProcessor,
            PurchasableCountCalculateProcessor purchasableCountCalculateProcessor
    ) {
        this.purchaseAmountInputProcessor = purchaseAmountInputProcessor;
        this.lottoListPrintProcessor = lottoListPrintProcessor;
        this.lottoListSaveProcessor = lottoListSaveProcessor;
        this.purchasableCountCalculateProcessor = purchasableCountCalculateProcessor;
    }

    public void run() {
        int purchaseAmount = purchaseAmountInputProcessor.inputPurchaseAmount();
        int purchasableCount = purchasableCountCalculateProcessor.calculatePurchasableCount(
                purchaseAmount);
        List<Lotto> generatedLottoList = lottoListSaveProcessor.saveLottoList(purchasableCount);
        lottoListPrintProcessor.printLottoList(generatedLottoList);
    }

}
