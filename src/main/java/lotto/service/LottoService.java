package lotto.service;

import lotto.config.LottoSettings;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private static final int TICKET_PRICE = LottoSettings.TICKET_PRICE.getValue();

    private final LottoReport lottoReport;
    private final List<LottoScore> purchasedLotto;
    private final int purchaseAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoService(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchasedLotto = LottoMachine.purchaseLottoTickets(purchaseAmount, TICKET_PRICE);
        this.lottoReport = new LottoReport(purchaseAmount);
    }

    public void runLottoSimulation() {
        for (LottoScore lottoScore : purchasedLotto) {
            calculateMatch(lottoScore);
            updateReport(lottoScore);
        }
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers.getNumbers();
    }

    private void calculateMatch(LottoScore lottoScore) {
        for (int number : lottoScore.getLottoNumbers()) {
            if (winningNumbers.contains(number)) {
                lottoScore.increaseNumberMatch();
            }
            if (bonusNumber == number) {
                lottoScore.increaseBonusMatch();
            }
        }
    }

    private void updateReport(LottoScore lottoScore) {
        int numberMatch = lottoScore.getNumberMatch();
        int bonusMatch = lottoScore.getBonusMatch();
        lottoReport.updateReport(numberMatch, bonusMatch);
    }

    public void printLottoNumbers() {
        String purchaseCount = Integer.toString(purchaseAmount / TICKET_PRICE);
        List<Integer> numbers;

        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (LottoScore lottoScore: purchasedLotto) {
            numbers = new ArrayList<>(lottoScore.getLottoNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public void printLottoResults() {
        lottoReport.printReport();
    }
}
