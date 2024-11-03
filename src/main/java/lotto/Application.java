package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseNum;
        int winningNum;
        int bonusNum;

        purchaseNum = getPurchaseNum();
        Lotto[] lottos = new Lotto[purchaseNum];

        System.out.println("purchaseNum" + "개를 구매했습니다.");
        for(int i = 0; i < purchaseNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
        }
        winningNum = getWinningNum();
        bonusNum = getBonusNum();
    }

    public static int getPurchaseNum() {
        System.out.println("구입금액을 입력해 주세요.");
        int sum = Integer.parseInt(Console.readLine());

        if(sum % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.");
        }
        return sum / 1000;
    }

    public static int getWinningNum() {

    }

}
