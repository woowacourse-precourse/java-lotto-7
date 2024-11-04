package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.generator.LottoGenerator;

public class LottoService {
    private static final int MATCHED_LIST_LENGTH = 5;
    private static final int BONUS_CHECK_NUMBER = 3;
    private static final int THREE_MATCHED = 0;
    private static final int FOUR_MATCHED = 1;
    private static final int FIVE_MATCHED = 2;
    private static final int FIVE_BONUS_MATCHED = 3;
    private static final int SIX_MATCHED = 4;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
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

    public List<Set<Integer>> generateManualNumberSet(int manualAmount, String manualMode) {
        List<Set<Integer>> manualNumberList = new ArrayList<>();
        while (manualAmount > 0) {
            manualNumberList.add(validationService.validateCorrectManualNumber(manualAmount, manualMode));
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

    public List<Set<Integer>> getTotalLottoList(List<Set<Integer>> manualLottoList, List<Set<Integer>> autoLottoList) {
        List<Set<Integer>> totalLottoList = new ArrayList<>();
        totalLottoList.addAll(autoLottoList);
        totalLottoList.addAll(manualLottoList);
        return totalLottoList;
    }

    public List<int[]> calculateMatched(List<Set<Integer>> totalLottoList, List<Set<Integer>> winnerLotto,
                                        int bonusNumber) {
        List<int[]> matchedList = new ArrayList<>();
        for (Set<Integer> set : totalLottoList) {
            Set<Integer> checkSet = new HashSet<>(set);
            checkSet.retainAll(winnerLotto.getFirst());
            if (checkSet.size() == BONUS_CHECK_NUMBER && set.contains(bonusNumber)) {
                int[] matched = addMatched(BONUS_CHECK_NUMBER);
                matchedList.add(matched);
            }
            if (checkSet.size() == SIX) {
                int[] matched = addMatched(SIX_MATCHED);
                matchedList.add(matched);
            }
            if (checkSet.size() == FIVE) {
                int[] matched = addMatched(FIVE_MATCHED);
                matchedList.add(matched);
            }
            if (checkSet.size() == FOUR) {
                int[] matched = addMatched(FOUR_MATCHED);
                matchedList.add(matched);
            }
            if (checkSet.size() == THREE) {
                int[] matched = addMatched(THREE_MATCHED);
                matchedList.add(matched);
            }
        }
        return matchedList;
    }

    private int[] addMatched(int bonusCheckNumber) {
        int[] matched = new int[MATCHED_LIST_LENGTH];
        matched[bonusCheckNumber]++;
        return matched;
    }
}
