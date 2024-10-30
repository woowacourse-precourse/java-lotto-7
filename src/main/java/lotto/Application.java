package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputMoney();
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> purchasedLottos = issueLottos(purchaseAmount / LOTTO_PRICE);
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        purchasedLottos.forEach(System.out::println);
    }

    private static int inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int money = Integer.parseInt(Console.readLine());
                validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + " 구입 금액은 1,000원 단위여야 합니다.");
            }
        }
    }

    private static void validateMoney(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> issueLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
