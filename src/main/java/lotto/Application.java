package lotto;

import lotto.View.Controller;
import lotto.View.OutputView;

import java.util.*;

import static java.lang.Math.round;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        //구입금액과 몇 개 샀는지 처리
        Integer purchasePrice = controller.gainPurchaseAmount();
        Integer lottoCount = controller.getLottoCount();
        //로또 발급 후 정렬 및 프린트
        List<Lotto> myLottos = Lotto.sortLottoList(lottoCount);
        //당첨 번호 및 보너스 번호 입력
        Lotto answer = controller.getWinningInput();
        Integer bonus = controller.gainBonusInput(answer);
        //각 로또 별 내 결과 저장
        List<MyResult> resultList = WinningDetails.saveMyGrades(myLottos, answer, bonus);
        WinningDetails winningDetails = new WinningDetails();
        winningDetails = winningDetails.sumUpGrades(resultList);
        OutputView.printResults(winningDetails);
        Integer revenue = MyResult.getMyRevenue(winningDetails);
        OutputView.printReturn(purchasePrice, revenue);
    }


}
