package lotto.Controller;

import lotto.Messages.ErrorMessage;
import lotto.Lotto;
import lotto.Model.MyResults;
import lotto.Model.WinningDetails;
import lotto.Model.MyInfo;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {
    private MyInfo myInfo;

    public LottoController() {
        myInfo = new MyInfo();
    }

    public void run() {
        WinningDetails winningDetails = new WinningDetails();
        gainPurchaseAmount();
        myInfo.setLottoCount(myInfo.getLottoCount());
        myInfo.setMyLottos(Lotto.sortLottoList(myInfo.getLottoCount()));
        myInfo.setAnswerLotto(gainWinningInput());
        myInfo.setBonusNumber(gainBonusInput(myInfo.getAnswerLotto()));
        List<MyResults> myResults = WinningDetails
                .saveMyGrades(myInfo.getMyLottos(), myInfo.getAnswerLotto(), myInfo.getBonusNumber());
        winningDetails.sumUpGrades(myResults);
        OutputView.printResults(winningDetails);
        myInfo.setRevenue(gainMyRevenue(winningDetails));
        myInfo.setMyReturn(gainReturn(myInfo.getPurchasePrice(), myInfo.getRevenue()));
        OutputView.printReturn(myInfo.getMyReturn());
    }

    public void gainPurchaseAmount() {
        boolean isValid = false;
        int purchasePrice = 0;
        while (!isValid) {
            try {
                OutputView.printPurchaseAmount();
                purchasePrice = InputView.readPurchaseAmount();
                InputView.checkPurchaseRange(purchasePrice);
                this.countLotto(purchasePrice);
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        this.myInfo.setPurchasePrice(purchasePrice);
    }


    public void countLotto(Integer purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIV.getError());
        }
        OutputView.printBlank();
        OutputView.printCount(lottoCount);
        this.myInfo.setLottoCount(lottoCount);
    }

    public Lotto gainWinningInput() {
        Lotto answer = null;
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printWinning();
                answer = InputView.readWinningNum();
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.WIN_INPUT.getError());
            }
        }
        OutputView.printBlank();
        return answer;
    }

    public int gainBonusInput(Lotto answer) {
        int bonus = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                OutputView.printBonus();
                bonus = InputView.readBonus(answer);
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.BONUS.getError());
            }
        }
        OutputView.printBlank();
        return bonus;
    }


    public int gainMyRevenue(WinningDetails grades) {
        int revenue = 0;
        revenue += grades.getThird() * 5000;
        revenue += grades.getFourth() * 50000;
        revenue += grades.getFifth() * 1500000;
        revenue += grades.getFifthBonus() * 30000000;
        revenue += grades.getSixth() * 2000000000;
        return revenue;
    }

    public double gainReturn(int purchasePrice, int revenue) {
        double myReturn = (double) revenue / (double) purchasePrice * 100;
        return Math.round(myReturn * 100) / 100.0;
    }
}
