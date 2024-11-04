package lotto.util;

import lotto.BonusNumber;
import lotto.LottoDrawResult;
import lotto.LottoPurchaseDetails;
import lotto.constant.LottoGrade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.constant.Amount.EMPTY_VALUE;
import static lotto.constant.Amount.PLUS_MATCHED_COUNT;
import static lotto.constant.Amount.ZERO;
import static lotto.constant.LottoGrade.ALL_MATCHED;
import static lotto.constant.LottoGrade.BONUS_MATCHED;
import static lotto.constant.LottoGrade.FIVE_MATCHED;
import static lotto.constant.LottoGrade.FOUR_MATCHED;
import static lotto.constant.LottoGrade.THREE_MATCHED;

public class LottoResultAggregator {

    private final Map<LottoGrade, Integer> lottoGradeMap = new HashMap<>();


    public Map<LottoGrade, Integer> aggregateLottoResults(LottoDrawResult lottoDrawResult, LottoPurchaseDetails lottoPurchaseDetails, int purchaseAmount) {

        initializeDefaultLottoGrade();

        List<List<Integer>> lottoTicketList = lottoPurchaseDetails.getLottoTickets();

        BonusNumber bonusNumber = lottoDrawResult.getBonusNumber();

        List<Integer> winningLotto = lottoDrawResult.getWinningLotto();

        for (int i = 0; i < lottoTicketList.size(); i++) {

            HashSet<Integer> lottoTicketSet = createLottoTicketSet(lottoTicketList, i);

            int matchedCount = countMatchedNumber(lottoTicketSet, winningLotto, ZERO.getValue());

            allMatched(lottoTicketSet, winningLotto);

            bonusNumberMatched(matchedCount, lottoTicketSet, matchedCount);

            fiveMatched(matchedCount, lottoTicketSet, bonusNumber);

            fourMatched(matchedCount);

            threeMatched(matchedCount);

        }

        return lottoGradeMap;
    }

    private HashSet<Integer> createLottoTicketSet(List<List<Integer>> lottoTicketList, int lottoTicketNumber) {
        return new HashSet<>(lottoTicketList.get(lottoTicketNumber));
    }

    private int countMatchedNumber(HashSet<Integer> lottoTicketSet, List<Integer> winningLotto, int matchedCount) {
        for (int i = 0; i < lottoTicketSet.size(); i++) {
            if (lottoTicketSet.contains(winningLotto.get(i))) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    private void allMatched(Set<Integer> lottoTicketSet, List<Integer> winningLotto) {
        if (lottoTicketSet.containsAll(winningLotto)) {
            updateMatchedInfo(ALL_MATCHED, lottoGradeMap);
            return;
        }
    }

    private void bonusNumberMatched(int matchedCount, Set<Integer> lottoTicketSet, int bonusNumber) {
        if (matchedCount == FIVE_MATCHED.getMatched() && lottoTicketSet.contains(bonusNumber)) {
            updateMatchedInfo(BONUS_MATCHED, lottoGradeMap);
            return;
        }
    }

    private void fiveMatched(int matchedCount, Set<Integer> lottoTicketSet, BonusNumber bonusNumber) {
        if (matchedCount == FIVE_MATCHED.getMatched()) {
            updateMatchedInfo(FIVE_MATCHED, lottoGradeMap);
            return;
        }
    }

    private void fourMatched(int matchedCount) {
        if (matchedCount == FOUR_MATCHED.getMatched()) {
            updateMatchedInfo(FOUR_MATCHED, lottoGradeMap);
            return;
        }
    }

    private void threeMatched(int matchedCount) {
        if (matchedCount == THREE_MATCHED.getMatched()) {
            updateMatchedInfo(THREE_MATCHED, lottoGradeMap);
            return;
        }
    }

    private void updateMatchedInfo(LottoGrade lottoGrade, Map<LottoGrade, Integer> lottoGradeMap) {
        lottoGradeMap.put(lottoGrade, lottoGradeMap.getOrDefault(lottoGrade, EMPTY_VALUE.getValue()) + PLUS_MATCHED_COUNT.getValue());
    }

    private void initializeDefaultLottoGrade() {
        lottoGradeMap.put(THREE_MATCHED, EMPTY_VALUE.getValue());
        lottoGradeMap.put(FOUR_MATCHED, EMPTY_VALUE.getValue());
        lottoGradeMap.put(FIVE_MATCHED, EMPTY_VALUE.getValue());
        lottoGradeMap.put(BONUS_MATCHED, EMPTY_VALUE.getValue());
        lottoGradeMap.put(ALL_MATCHED, EMPTY_VALUE.getValue());
    }
}
