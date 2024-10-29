package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class User {

    private int lottoCount;
    private ArrayList<Lotto> lottos = new ArrayList<>();

    public User() {
        this.lottoCount = getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    private static int getLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = Integer.parseInt(input);

        if (!validatePurchaseAmount(purchaseAmount)) {
            return getLottoCount();
        }

        try {
            return purchaseAmount / 1000;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            return getLottoCount();
        }
    }

    private static boolean validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            return false;
        }
        return true;
    }
}
