package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine().trim();
        validateAmountInput(amountInput);

        int amount = Integer.parseInt(amountInput);
        int lottoCount = amount / 1000;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = issueLotto();
            lottoList.add(lotto);
            lotto.display();
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningLottoInput = Console.readLine()
                .trim()
                .split(",");
    }

    private static void validateAmountInput(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        if (Integer.parseInt(amountInput) % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 1000원 단위 이상이어야 합니다.");
        }
    }

    private static Lotto issueLotto() {
        List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomLottoNumbers);
    }
}
