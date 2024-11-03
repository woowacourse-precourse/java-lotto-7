package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.view.LottoInfoMessages;

public class LottoService {
    ValidationService validationService = ValidationService.createValidationService();
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

    public List<Set<Integer>> generateManualNumberSet(int manualAmount) {
        List<Set<Integer>> manualNumberList = new ArrayList<>();
        while (manualAmount>0){
            manualNumberList.add(validationService.validateCorrectManualNumber(manualAmount));
            manualAmount--;
        }
        return manualNumberList;
    }
}
