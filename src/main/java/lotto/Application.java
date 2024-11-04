package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input_text = "";
        int purchaseAmount = 0;
        int bonusNum = 0;
        List<Integer> winningNums = new ArrayList<>();
        List<Lotto> lottos = new ArrayList<Lotto>();
        int[] winningResult = new int[6];

        InputHandler inputHandler = new InputHandler();
        LottoWinningChecker winningChecker;

        while (true) {
            try {
                // 구매 금액 입력 안내 메시지 출력
                input_text = Console.readLine();
                purchaseAmount = inputHandler.readPurchaseAmount(input_text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lottos.add(new Lotto(nums));
        }

        // 구매한 로또 번호 출력

        while (true) {
            try {
                // 당첨 번호 입력 안내 메시지 출력
                input_text = Console.readLine();
                winningNums = inputHandler.readWinningNumbers(input_text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                // 보너스 번호 입력 안내 메시지 출력
                input_text = Console.readLine();
                bonusNum = inputHandler.readBonusNumber(input_text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        winningChecker = new LottoWinningChecker(winningNums, bonusNum);

        for (Lotto lotto : lottos) {
            int winningGrade = winningChecker.getWinningGrade(lotto);
            winningResult[winningGrade] += 1;
        }

        // 당첨 통계 출력
    }
}
