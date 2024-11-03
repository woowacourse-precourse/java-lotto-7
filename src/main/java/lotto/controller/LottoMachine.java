package lotto.controller;

import java.util.List;
import lotto.dto.LottoResultDto;
import lotto.dto.ReceiptAndLottoDto;
import lotto.dto.entity.Lotto;
import lotto.dto.entity.WinningLotto;
import lotto.service.LottoGenerateManager;
import lotto.service.LottoPurchaseManager;
import lotto.service.LottoResultManager;
import lotto.view.InputOutputManager;

public class LottoMachine {
    private InputOutputManager inputOutputManager;
    private LottoPurchaseManager lottoPurchaseManager;
    private LottoGenerateManager lottoGenerateManager;
    private LottoResultManager lottoResultManager;

    public LottoMachine(InputOutputManager inputOutputManager, LottoPurchaseManager lottoPurchaseManager,
                        LottoGenerateManager lottoGenerateManager, LottoResultManager lottoResultManager) {
        this.inputOutputManager = inputOutputManager;
        this.lottoPurchaseManager = lottoPurchaseManager;
        this.lottoGenerateManager = lottoGenerateManager;
        this.lottoResultManager = lottoResultManager;
    }

    public void start() {
        ReceiptAndLottoDto receiptAndLottoDto = purchaseLottos();
        WinningLotto winningLotto = generateWinningLotto();
        checkLottoResult(receiptAndLottoDto, winningLotto);
    }

    private ReceiptAndLottoDto purchaseLottos() {
        int purchaseAmount = inputOutputManager.receivePurchaseAmount();
        int numberOfLotto = lottoPurchaseManager.checkNumberOfLotto(purchaseAmount);
        inputOutputManager.printLottoCount(numberOfLotto);

        List<Lotto> lottos = lottoPurchaseManager.provideLottos(numberOfLotto);
        inputOutputManager.printLottoNumbers(lottos);

        return lottoPurchaseManager.provideResultDto(purchaseAmount, lottos);
    }

    private WinningLotto generateWinningLotto() {
        List<Integer> winningNumbers = inputOutputManager.receiveWinningNumbers();
        int bonusNumber = inputOutputManager.receiveBonusNumber();

        return lottoGenerateManager.provideWinningLotto(winningNumbers, bonusNumber);
    }


    private void checkLottoResult(ReceiptAndLottoDto receiptAndLottoDto, WinningLotto winningLotto) {
        LottoResultDto lottoResultDto = lottoResultManager.checkLottoResult(receiptAndLottoDto, winningLotto);
        inputOutputManager.printLottoResult(lottoResultDto);
    }
}
