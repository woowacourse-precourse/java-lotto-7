package controller;

import lotto.LottoList;
import lotto.LottoResult;
import lotto.PurchaseCount;
import lotto.WinningNumbers;
import service.LottoService;
import view.LottoView;

public class LottoController {
    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void buyLotto() {
        // Step 1: 구매한 로또 개수 확인
        PurchaseCount purchaseCount = getPurchasedLottoCount();
        printPurchasedLottoCount(purchaseCount);

        // Step 2: 로또 구매 및 출력
        LottoList lottoList = purchaseLottos(purchaseCount.getPurchaseCount());
        displayPurchasedLottoNumbers(lottoList);

        // Step 3: 당첨 번호 입력 받기
        WinningNumbers winningNumbers = getWinningNumbers();

        // Step 4: 당첨 결과 확인 및 출력
        checkLottoResult(winningNumbers, lottoList);
    }

    private PurchaseCount getPurchasedLottoCount() {
        String purchaseAmount = lottoView.inputPurchaseAmount();
        return lottoService.getCount(purchaseAmount);
    }

    private String printPurchasedLottoCount(PurchaseCount purchaseCount) {
        return lottoView.printPurchasedLottoCountFromView(purchaseCount);
    }

    private LottoList purchaseLottos(int purchaseCount) {
        return lottoService.generateLottos(purchaseCount);
    }

    private void displayPurchasedLottoNumbers(LottoList lottoList) {
        lottoView.printPurchasedLottoNumbersFromView(lottoList.getLottoList());
    }

    private WinningNumbers getWinningNumbers() {
        String winningNumbers = lottoView.inputWinningNumbers();
        String bonusNumber = lottoView.inputBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void checkLottoResult(WinningNumbers winningNumbers, LottoList lottoList) {
        LottoResult lottoResult = lottoService.getMatchingResult(winningNumbers, lottoList);
        lottoView.printMatchingResult(lottoResult, lottoList.size());
    }
}
