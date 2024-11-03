package lotto.Controller;

import lotto.Messages.ErrorMessage;
import lotto.Model.Lotto;
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
        int purchasePrice = 0;
        try {
            OutputView.printPurchaseAmount();
            purchasePrice = InputView.readPurchaseAmount();
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(ErrorMessage.NOT_DIV.getError())) {
                OutputView.printError(ErrorMessage.NOT_DIV.getError());
                gainPurchaseAmount(); return;
            }
            OutputView.printError(ErrorMessage.ONLY_NUMBER.getError());
            gainPurchaseAmount(); return;
        }
        this.countLotto(purchasePrice);
        this.myInfo.setPurchasePrice(purchasePrice);
    }


    public void countLotto(Integer purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        if (purchasePrice % 1000 != 0) {
            OutputView.printError(ErrorMessage.NOT_DIV.getError());
            throw new IllegalArgumentException(ErrorMessage.NOT_DIV.getError());
        }
        OutputView.printBlank();
        OutputView.printCount(lottoCount);
        this.myInfo.setLottoCount(lottoCount);
    }

    public Lotto gainWinningInput() {
        Lotto answer;
        OutputView.printWinning();
        try {
            answer = InputView.readWinningNum();
        } catch (IllegalArgumentException e) {
            OutputView.printError(ErrorMessage.WIN_INPUT.getError());
            return gainWinningInput();
        }
        OutputView.printBlank();
        return answer;
    }

    public int gainBonusInput(Lotto answer) {
        int bonus = 0;
        OutputView.printBonus();
        try {
            bonus = InputView.readBonus(answer);
        } catch (IllegalArgumentException e) {
            OutputView.printError(ErrorMessage.BONUS.getError());
            return gainBonusInput(answer);
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
