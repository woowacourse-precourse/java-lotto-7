package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class User {

    private int lottoCount;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private Map<Prize, Integer> prizes = new LinkedHashMap<>();

    public User() {
        this.lottoCount = inputLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    private static int inputLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = Integer.parseInt(input);

        if (!validatePurchaseAmount(purchaseAmount)) {
            return inputLottoCount();
        }

        try {
            return purchaseAmount / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다.");
        }
    }

    private static boolean validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        return true;
    }

    public void showLottoCount() {
        System.out.println(this.lottoCount + "개를 구매했습니다.");
    }

    public void showLottos() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.toString());
        }
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public void setPrize(int matchCount, int bonusMatch) {
        Prize prize = Prize.getPrize(matchCount, bonusMatch);
        prizes.put(prize, prizes.get(prize) + 1);
    }
}
