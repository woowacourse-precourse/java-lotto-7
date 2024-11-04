package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = 0;
        try {
            int money = Integer.parseInt(Console.readLine());
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

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumber = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자로 입력해야 합니다.");
        }
    }
}
