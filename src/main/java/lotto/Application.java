package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = 0;
        int money = Integer.parseInt(Console.readLine());
        try {
            if (money <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다.");
            }
            if (money < 1000 || money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
            }
            lottoCount = money / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String lottoNumber = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        String[] eachNumbers = lottoNumber.split(",");

        for (String number : eachNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자로 입력해야 합니다.");
        }

        int[] matchCounts = new int[8];

        for (Lotto lotto : lottos) {
            int matches = 0;
            boolean hasBonus = false;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matches++;
                }
                if (number == bonusNumber) {
                    hasBonus = true;
                }
            }
            if (matches == 5 && hasBonus) {
                matchCounts[7]++;
            }
            if (matches >= 3) {
                matchCounts[matches]++;
            }
        }

        long totalMoney = matchCounts[3] * 5_000L + matchCounts[4] * 50_000L +
                matchCounts[5] * 1_500_000L + matchCounts[7] * 30_000_000L + matchCounts[6] * 2_000_000_000L;

        double returnRate = totalMoney * 100.0 / money;
    }
}
