package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManager {
    private PurchasedLottos purchasedLottos;
    private Set<Integer> winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;

    public void run() {
        purchaseLotto();
        progressLottoGame();
        announceLottoResult();
    }

    private void purchaseLotto() {
        purchaseAmount = getLottoPurchaseAmount();
        issueLotto();
        OutputView.showPurchasedLottos(purchasedLottos.getPurchasedLottos().stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n")));
    }

    private int getLottoPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmountParser.parse(InputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void issueLotto() {
        List<Lotto> lottos = new ArrayList<>();
        int count = purchaseAmount / LottoConstants.LOTTO_PRICE;

        OutputView.showPurchasedLottosQuantity(count);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER,
                    LottoConstants.MAX_LOTTO_NUMBER,
                    LottoConstants.LOTTO_PICK_SIZE
            ));
            lottos.add(lotto);
        }

        purchasedLottos = new PurchasedLottos(lottos);
    }


    private void progressLottoGame() {
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();

    }

    private Set<Integer> getWinningNumbers() {
        while (true) {
            try {
                return WinningNumbersParser.parse(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return BonusNumberParser.parse(InputView.readBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void announceLottoResult() {

        int[] rankCounts = new int[5];

        for (Lotto lotto : purchasedLottos.getPurchasedLottos()) {
            int count = 0;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    count++;
                }
            }
            if (count < 5 && !lotto.getNumbers().contains(bonusNumber)) {
                count--;
            }
            if (count >= 2) {
                rankCounts[count - 2]++;
            }
        }


        LottoRank[] ranks = {LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};
        StringBuilder winningStatistics = new StringBuilder();
        long totalPrize = 0;

        for (int i = 0; i < rankCounts.length; i++) {
            LottoRank rank = ranks[i];
            totalPrize += ranks[i].getPrize() * rankCounts[i];
            winningStatistics.append(rank.getMessage() + rankCounts[i] + "개" + "\n");
        }
        double returnRate = (double) totalPrize / purchaseAmount * 100;
        OutputView.announceWinningStatistics(winningStatistics.toString(), returnRate);
    }

}
