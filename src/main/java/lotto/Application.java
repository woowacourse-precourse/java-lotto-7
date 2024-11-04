package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static int buyLottoMoney = 0;
    private static int cntLotto = 0;
    private static int bonusNum = 0;
    private static double totalSum = 0;
    private static int matchNum = 0;
    private static boolean matchBonus = false;
    private static InputView input;
    private static OutputView output;
    public static List<Lotto> lottos = new ArrayList<>();  // 로또 객체 리스트
    public static int[] perRankCount = {0, 0, 0, 0, 0, 0};
    private static Prize prize;

    public static void main(String[] args) {
        // 로또 구매
        buyLottoMoney = buyLotto();
        System.out.println();

        // 금액에 따른 개수 도출
        cntLotto = buyLottoMoney / 1000;
        output.printCntLotto(cntLotto);

        // 로또 랜덤하게 생성
        randomizePublish();
        System.out.println();

        // 당첨 번호 입력
        Lotto winLotto = input.enterWinNum();
        System.out.println();

        // 보너스 번호 입력
        bonusNum = input.enterBonusNum();

        // 당첨 확인 과정
        for (Lotto lotto : lottos) {
            checkLotto(lotto, winLotto);
        }

        // 당첨 결과 출력
        output.printResultPrize();

        // 총 수익률
        output.printRevenue(totalSum, buyLottoMoney);
    }

    private static int buyLotto() {
        try {
            return input.buyLotto();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
        }
        return 0;
    }

    private static void randomizePublish() {
        for (int i = 0; i < cntLotto; i++) {
            Lotto randLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(randLotto);
            System.out.println(randLotto.toString());
        }
    }

    private static void calculateCntAndSum(Prize prize) {
        perRankCount[prize.getRank()]++;
        totalSum += prize.money();
    }

    private static void checkLotto(Lotto lotto, Lotto winLotto) {
        matchNum = lotto.cntMatchingNumbers(winLotto);  // 당첨 숫자 개수
        matchBonus = lotto.getNumbers().contains(bonusNum); // 보너스 숫자 맞는지 여부
        prize = null;
        if (matchNum == 5 && matchBonus) {
            prize = prize.BONUS;
            calculateCntAndSum(prize);
        }
        if (matchNum >= 3 && prize == null) {
            prize = Prize.checkByMatchNum(matchNum);
            calculateCntAndSum(prize);
        }
    }
}
