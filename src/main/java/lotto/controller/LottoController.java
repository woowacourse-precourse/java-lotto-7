package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.Arrays.stream;
import static lotto.view.InputView.askBonusNumber;
import static lotto.view.InputView.askPurchaseAmount;
import static lotto.view.InputView.askWinningNumbers;
import static lotto.view.OutputView.printEarningsRate;
import static lotto.view.OutputView.printPurchasedLottos;
import static lotto.view.OutputView.printWinningStatistics;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.MatchingRecord;
import lotto.model.Rank;

public class LottoController {
    private static final int PURCHASE_UNIT = 1000;
    private static final String DELIMITER = ",";
    private int wholeCashPrize = 0;

    public void run() {
        int purchaseAmount = Integer.parseInt(askPurchaseAmount());
        List<Lotto> lottos = IntStream.range(0, purchaseAmount / PURCHASE_UNIT)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, 6))).toList();
        printPurchasedLottos(lottos);
        List<Integer> winningNumbers = stream(askWinningNumbers().split(DELIMITER, -1)).map(Integer::parseInt).toList();
        int bonusNumber = Integer.parseInt(askBonusNumber());
        List<MatchingRecord> matchingRecords = stream(Rank.values()).map(MatchingRecord::new).toList();
        getStatistics(matchingRecords, lottos, winningNumbers, bonusNumber);
        printWinningStatistics(matchingRecords);
        for (MatchingRecord matchingRecord : matchingRecords) {
            if (matchingRecord.getLottoQuantity() > 0) {
                wholeCashPrize += matchingRecord.getRank().getPrizeMoney() * matchingRecord.getLottoQuantity();
            }
        }
        printEarningsRate((((double) wholeCashPrize / (double) purchaseAmount) * 100));
    }

    private void getStatistics(List<MatchingRecord> matchingRecords, List<Lotto> lottos, List<Integer> winningNumbers,
                               int bonusNumber) {
        // lotto 배열을 순회하면서 일치하는 숫자 검증하고, bonus 숫자 매칭 확인하고 MatchingRecord의 lottoQuantity 증가시키기
        for (Lotto lotto : lottos) {
            Integer count = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            if (count.equals(6)) {
                matchingRecords.get(4).increaseLottoQuantity();
            } else if (count.equals(5) && lotto.getNumbers().contains(bonusNumber)) {
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
