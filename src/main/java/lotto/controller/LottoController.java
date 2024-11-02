package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.Arrays.stream;
import static lotto.utils.Parser.parseBonusNumber;
import static lotto.utils.Parser.parsePurchaseAmount;
import static lotto.utils.Parser.parseWinningNumbers;
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
import lotto.model.WinningNumbers;

public class LottoController {
    private static final int PURCHASE_UNIT = 1000;

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = issueLottos(purchaseAmount);
        printPurchasedLottos(lottos);
        WinningNumbers winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        List<MatchingRecord> matchingRecords = stream(Rank.values()).map(MatchingRecord::new).toList();
        getStatistics(matchingRecords, lottos, winningNumbers, bonusNumber);
        printWinningStatistics(matchingRecords);
        double wholeCashPrize = calculateWholeCashPrize(matchingRecords);
        printEarningsRate(((wholeCashPrize / (double) purchaseAmount) * 100));
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = parsePurchaseAmount(askPurchaseAmount());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbersUnvalidated = parseWinningNumbers(askWinningNumbers());
                WinningNumbers winningNumbers = new WinningNumbers(winningNumbersUnvalidated);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                int bonusNumber = parseBonusNumber(askBonusNumber());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> issueLottos(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount / PURCHASE_UNIT)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, 6))).toList();
    }

    private double calculateWholeCashPrize(List<MatchingRecord> matchingRecords) {
        int wholeCashPrize = 0;
        for (MatchingRecord matchingRecord : matchingRecords) {
            if (matchingRecord.getLottoQuantity() > 0) {
                wholeCashPrize += matchingRecord.getRank().getPrizeMoney() * matchingRecord.getLottoQuantity();
            }
        }
        return wholeCashPrize;
    }

    private void getStatistics(List<MatchingRecord> matchingRecords, List<Lotto> lottos, WinningNumbers winningNumbers,
                               int bonusNumber) {
        for (Lotto lotto : lottos) {
            Integer count = (int) lotto.getNumbers().stream()
                    .filter(i -> winningNumbers.getWinningNumbers().contains(i)).count();
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
