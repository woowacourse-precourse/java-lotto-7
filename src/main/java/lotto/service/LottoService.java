package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.generator.LottoGenerator;
import lotto.view.LottoInfoMessages;

public class LottoService {
    ValidationService validationService = ValidationService.createValidationService();
    LottoGenerator lottoGenerator = LottoGenerator.createLottoGenerator();
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

    public List<Set<Integer>> generateAutoNumberSet(int amount) {
        List<Set<Integer>> autoLottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            autoLottoList.add(new HashSet<>(lottoGenerator.getLottoNumbers()));
        }
        return autoLottoList;
    }
}
