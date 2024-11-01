package lotto;

/*
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
 */

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int PRICE_PER_TICKET = 1000;
    private static final int MATCH_3_REWARD = 5000;
    private static final int MATCH_4_REWARD = 50000;
    private static final int MATCH_5_REWARD = 1500000;
    private static final int MATCH_5_BONUS_REWARD = 30000000;
    private static final int MATCH_6_REWARD = 2000000000;

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        int numberOfTickets = amount / 1000;

        System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoNumbers);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String win = Console.readLine();
        String[] numberStrings = win.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            winNumbers.add(Integer.parseInt(numberString));
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        int bonusNumber = Integer.parseInt(bonus);
        int n = 0;
        double d = 1.25;

        //당첨 검사 로직
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + n + "개");
        System.out.println("4개 일치 (50,000원) - " + n + "개");
        System.out.println("5개 일치 (1,500,000원) - " + n + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + n + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + n + "개");
        System.out.println("총 수익률은 " + d + "%입니다.");
    }
}
