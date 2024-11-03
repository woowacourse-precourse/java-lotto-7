package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoView {
    private int LOTTO_PRICE;

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            LOTTO_PRICE = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자여야 합니다.");
        }
        return LOTTO_PRICE;
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(List<Grade> grades) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;
        int totalPrize = 0;
        for (Grade grade : grades) {
            if (grade == Grade.FIRST) {
                first++;
            } else if (grade == Grade.SECOND) {
                second++;
            } else if (grade == Grade.THIRD) {
                third++;
            } else if (grade == Grade.FOURTH) {
                fourth++;
            } else if (grade == Grade.FIFTH) {
                fifth++;
            }
            totalPrize += grade.getPrize();
        }
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");

        System.out.println("총 수익률은 " +  (double) totalPrize / LOTTO_PRICE * 100 + "%입니다.");
    }
}
