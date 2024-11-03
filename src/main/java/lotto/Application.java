package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = getAmount();
        int lottoCount = amount /1000;

        System.out.println(lottoCount + " 개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(generateRandomLottoNumbers());
            System.out.println(lotto.getNumbers());
        }

        Lotto winningLotto = new Lotto();

        //구매한 로또 번호와 당첨 번호 비교, 당첨 결과 확인
    }

    public static int getAmount() {
        String inputAmount = Console.readLine();
        return validateAmountValue(inputAmount);
    }

    private static int validateAmountValue(String inputAmount) {
        try {
            int amount = Integer.parseInt(inputAmount);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 타입입니다.");
        }

    }

    private static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
