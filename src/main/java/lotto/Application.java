package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static int credit;
    public static int pieces;
    public static List<Lotto> lottos = new ArrayList<>();
    public static List<Integer> winningNumbers = new ArrayList<>();
    public static int bonusNumber;

    public static int[] matchCount = new int[8];

    public static long revenue;
    public static double revenueRate;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구입 금액 입력
        credit = InputHandler.getCredit();
        pieces = InputHandler.getPieces(credit);

        // 로또 생성
        System.out.println();
        System.out.println(pieces + "개를 구매했습니다.");
        publishLotto();
        OutputHandler.printPurchasedLottos(lottos);

        // 당첨 번호와 보너스 번호 입력
        System.out.println();
        winningNumbers = InputHandler.getWinningNumbers();
        System.out.println();
        bonusNumber = InputHandler.getBonusNumber();

        // 당첨 결과 출력
        System.out.println();
        for (Lotto lotto : lottos) {
            matchTest(lotto);
        }

        // 결과 출력
        calculateRevenue();
        calculateRevenueRate();
        OutputHandler.printResult(matchCount, revenueRate);
    }

    public static void publishLotto() throws IllegalArgumentException {
        for (int i = 0; i < pieces; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public static void matchTest(Lotto lotto) {
        List<Integer> intersection = new ArrayList<>(winningNumbers);
        intersection.retainAll(lotto.getNumbers());
        if( intersection.size() == 5 && bonusMatchTest(lotto)) {
            matchCount[7]++;
        }
        matchCount[intersection.size()]++;
    }

    public static boolean bonusMatchTest(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static void calculateRevenue() {
        revenue = matchCount[3] * 5000;
        revenue += matchCount[4] * 50000;
        revenue += matchCount[5] * 1500000;
        revenue += matchCount[7] * 30000000;
        revenue += matchCount[6] * 2000000000;
    }

    public static void calculateRevenueRate() {
        revenueRate = Math.round((double) revenue / credit * 100 * 100) / 100.0;
    }
}
