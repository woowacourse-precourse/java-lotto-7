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
        System.out.println();
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
        int attempts = 0;
        final int maxAttempts = 3; // 최대 시도 횟수

        while (!isValid && attempts < maxAttempts) {
            try {
                OutputView.printPurchaseAmount();
                purchasePrice = InputView.readPurchaseAmount();
                isValid = true; // 입력이 유효할 경우 루프 종료
                this.countLotto(purchasePrice);
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals(ErrorMessage.NOT_DIV.getError())) {
                    OutputView.printError(ErrorMessage.NOT_DIV.getError());
                } else {
                    OutputView.printError(ErrorMessage.ONLY_NUMBER.getError());
                }
                attempts++; // 시도 횟수 증가
                if (attempts == maxAttempts) {
                    System.out.println("[ERROR] 최대 시도 횟수를 초과했습니다. 프로그램을 종료합니다.");
                    System.exit(1); // 프로그램 종료 또는 다른 적절한 처리
                }
            }
        }
        this.myInfo.setPurchasePrice(purchasePrice);
    }




    public void countLotto(Integer purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        if (purchasePrice % 1000 != 0) {
            //OutputView.printError(ErrorMessage.NOT_DIV.getError());
            throw new IllegalArgumentException(ErrorMessage.NOT_DIV.getError());
        }
        OutputView.printBlank();
        OutputView.printCount(lottoCount);
        this.myInfo.setLottoCount(lottoCount);
    }

    public Lotto gainWinningInput() {
        Lotto answer = null;
        boolean isValid = false;
        int attempts = 0;
        final int maxAttempts = 3; // 최대 시도 횟수

        while (!isValid && attempts < maxAttempts) {
            try {
                OutputView.printWinning();
                answer = InputView.readWinningNum();
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.WIN_INPUT.getError());
                attempts++; // 시도 횟수 증가
                if (attempts == maxAttempts) {
                    System.out.println("[ERROR] 최대 시도 횟수를 초과했습니다. 프로그램을 종료합니다.");
                    System.exit(1); // 프로그램 종료 또는 다른 적절한 처리
                }
            }
        }
        OutputView.printBlank();
        return answer;
    }

    public int gainBonusInput(Lotto answer) {
        int bonus = 0;
        boolean isValid = false;
        int attempts = 0;
        final int maxAttempts = 3; // 최대 시도 횟수

        while (!isValid && attempts < maxAttempts) {
            try {
                OutputView.printBonus();
                bonus = InputView.readBonus(answer);
                isValid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.BONUS.getError());
                attempts++; // 시도 횟수 증가
                if (attempts == maxAttempts) {
                    System.out.println("[ERROR] 최대 시도 횟수를 초과했습니다. 프로그램을 종료합니다.");
                    System.exit(1); // 프로그램 종료 또는 다른 적절한 처리
                }
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
