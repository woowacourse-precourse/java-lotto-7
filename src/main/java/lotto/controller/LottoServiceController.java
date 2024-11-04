package lotto.controller;

import lotto.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinRecord;
import lotto.domain.WinningLotto;
import lotto.utility.Utils;
import lotto.view.ResultOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoServiceController {
    private final List<Lotto> userLottos;
    private final ResultOutput resultOutput = new ResultOutput();
    private PurchaseAmount purchaseAmount;
    private WinningLotto winningLotto;
    private WinRecord winRecord;


    public LottoServiceController() {
        purchaseAmount = PurchaseAmount.getPurchaseAmount();
        userLottos = createUserLottos(purchaseAmount.getPurchaseCount());
    }


    private List<Lotto> createUserLottos(int purchaseCount) {
        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            userLottos.add(new Lotto
                    (Utils.getRandomNumbers
                            (Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_NUMBER_COUNT)));
        }
        userLottos = Collections.unmodifiableList(userLottos);
        return userLottos;
    }

    private List<Integer> getWinningSummary() {
        List<Integer> winningSummary = new ArrayList<>();
        for (Lotto userLotto : userLottos) {
            winningSummary.add(getWinningCount
                    (userLotto.getLottoNumbers()));
        }
        return winningSummary;
    }

    private int getWinningCount(List<Integer> userLotto) {
        List<Integer> checkDuplication = new ArrayList<>(userLotto);
        checkDuplication.retainAll(winningLotto.getLottoNumbers());
        return checkDuplication.size();
    }

    private double getTotalYield() {
        BigDecimal totalPurchaseAmount = new BigDecimal(purchaseAmount.getPurchaseAmountValue());
        BigDecimal totalWinningPrize = new BigDecimal(winRecord.getTotalWinningPrize());
        BigDecimal result = totalWinningPrize.divide(totalPurchaseAmount, 3, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        return result.doubleValue();
    }


    public void displayUserLottos() {
        resultOutput.displayPurchaseCount(purchaseAmount.getPurchaseCount());
        for (Lotto userLotto : userLottos) {
            resultOutput.displayUserLotto(userLotto.getLottoNumbers());
        }
    }

    public void displayWinRecord() {
        winningLotto = WinningLotto.getWinningLotto();
        winRecord = WinRecord.getWinRecord(getWinningSummary());
        resultOutput.displayWinRecord(winRecord.getWinRecordCounts());
    }

    public void displayTotalYield() {
        resultOutput.displayTotalYield(getTotalYield());
    }
}
