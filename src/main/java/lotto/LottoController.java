package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        // 구입 금액 입력
        PriceInput priceInput = new PriceInput();
        int price = priceInput.inputPrice();

        // 랜덤 로또 번호 출력
        LottoNumbersPrint lottoNumbersPrint = new LottoNumbersPrint();
        List<List<Integer>> lottoNumberLists = lottoNumbersPrint.printLottoNumbers(price);

        // 당첨 번호 입력 받기
        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        Lotto lotto = winningNumbersInput.inputNumbers();

        // 보너스 번호 입력 받기
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        int bonusNumber = bonusNumberInput.inputBonusNumber(lotto.getNumbers());

        // 당첨 결과 계산
        LottoCompare lottoCompare = new LottoCompare();
        List<Integer> result = lottoCompare.compareLottoNumbers(lotto.getNumbers(), lottoNumberLists, bonusNumber);
        Map<WinningType, Integer> counts = lottoCompare.storeNumbers(result);

        // 당첨 내역 출력
        WinningDetailsDisplay winningDetailsDisplay = new WinningDetailsDisplay();
        winningDetailsDisplay.printWinningDetails(counts);
        winningDetailsDisplay.printRate(price, counts);
    }
}
