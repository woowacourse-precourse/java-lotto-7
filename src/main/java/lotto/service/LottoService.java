package lotto.service;

import java.util.List;
import lotto.view.LottoInfoMessages;

public class LottoService {
    public int countMatches(List<Integer> winnerNumbers, List<Integer> numbers) {
        winnerNumbers.retainAll(numbers);
        return winnerNumbers.size();
    }

    private LottoService() {

    }

    public static LottoService createLottoService() {
        return new LottoService();
    }

    public int calculateChange(int pay) {
        return pay % 1000;
    }

    public int calculateAmount(int pay) {
        return pay / 1000;
    }

    public void printNoticeBuyAmount(int amount, int change) {
        System.out.println(
                amount + LottoInfoMessages.NOTICE_BUY_AMOUNT_START.text()
                        + change + LottoInfoMessages.NOTICE_BUY_AMOUNT_END.text());
    }
}
