package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.MatchingRecord;
import lotto.model.WinningNumbers;

public class LottoStatistics {
    public static double calculateWholeCashPrize(List<MatchingRecord> matchingRecords) {
        int wholeCashPrize = 0;
        for (MatchingRecord matchingRecord : matchingRecords) {
            if (matchingRecord.getLottoQuantity() > 0) {
                wholeCashPrize += matchingRecord.getRank().getPrizeMoney() * matchingRecord.getLottoQuantity();
            }
        }
        return wholeCashPrize;
    }

    public static void getStatistics(List<MatchingRecord> matchingRecords, List<Lotto> lottos,
                                     WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            Integer count = (int) lotto.getNumbers().stream()
                    .filter(i -> winningNumbers.getWinningNumbers().contains(i)).count();
            if (count.equals(6)) {
                matchingRecords.get(4).increaseLottoQuantity();
            } else if (count.equals(5) && lotto.getNumbers().contains(bonusNumber.getBonusNumber())) {
                matchingRecords.get(3).increaseLottoQuantity();
            } else if (count.equals(5)) {
                matchingRecords.get(2).increaseLottoQuantity();
            } else if (count.equals(4)) {
                matchingRecords.get(1).increaseLottoQuantity();
            } else if (count.equals(3)) {
                matchingRecords.get(0).increaseLottoQuantity();
            }
        }
    }
}
