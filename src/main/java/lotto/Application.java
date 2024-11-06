package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구입 금액 입력
        InputHandler inputHandler = new InputHandler();
        int credit = inputHandler.getCredit();
        int pieces = inputHandler.getPieces(credit);

        // 로또 생성
        System.out.println();
        System.out.println(pieces + "개를 구매했습니다.");
        LottoDraw lottoDraw = new LottoDraw(pieces);
        lottoDraw.generateLottos();
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printPurchasedLottos(lottoDraw.getLottos());

        // 당첨 번호와 보너스 번호 입력
        System.out.println();
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        System.out.println();
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);
        lottoDraw.setWinningNumbers(winningNumbers, bonusNumber);

        // 당첨 결과 출력
        System.out.println();
        lottoDraw.calculateResults();
        outputHandler.printResult(lottoDraw.getMatchCount(), lottoDraw.getRevenueRate());
    }
}
