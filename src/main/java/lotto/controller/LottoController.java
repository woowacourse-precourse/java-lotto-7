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
import lotto.model.BonusNumber;
import lotto.model.Deposit;
import lotto.model.Lotto;
import lotto.model.MatchingRecord;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

public class LottoController {
    public void run() {
        Deposit deposit = getPurchaseAmount();
        List<Lotto> lottos = issueLottos(deposit.getNumberOfLottoes());
        printPurchasedLottos(lottos);
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        List<MatchingRecord> matchingRecords = stream(Rank.values()).map(MatchingRecord::new).toList();
        getStatistics(matchingRecords, lottos, winningNumbers, bonusNumber);
        printWinningStatistics(matchingRecords);
        double wholeCashPrize = calculateWholeCashPrize(matchingRecords);
        printEarningsRate(((wholeCashPrize / (double) deposit.getPurchaseAmount()) * 100));
    }

    private Deposit getPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = parsePurchaseAmount(askPurchaseAmount()); // 정수화된 구입 금액
                return new Deposit(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = parseWinningNumbers(askWinningNumbers());
                return new WinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                return new BonusNumber(winningNumbers, parseBonusNumber(askBonusNumber()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> issueLottos(int numberOfLottoes) {
        return IntStream.range(0, numberOfLottoes)
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
                               BonusNumber bonusNumber) {
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
