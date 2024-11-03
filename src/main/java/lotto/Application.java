package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int lottoPrice = 1000;

    public static void main(String[] args) {
        int lottoPieces;
        // 예외 처리 때문에 가독성이 너무 안좋다. 리팩토링 할 때 이 부분 고려하기.
        while (true) {
            try {
                String Money = Console.readLine();
                lottoPieces = buyLotto(Money);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> lottos = createLotto(lottoPieces);
        lottosView(lottos);
    }

    public static int buyLotto(final String input) {
        int payment = Integer.parseInt(input);
        validateBuyLotto(payment);
        return payment / lottoPrice;
    }

    public static void validateBuyLotto(final int payment) {
        if (payment % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static List<Lotto> createLotto(final int pieces) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < pieces; i++) {
            List<Integer> randomLottoNum = createLottoNum();
            lottos.add(new Lotto(randomLottoNum));
        }
        return lottos;
    }

    public static List<Integer> createLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void lottosView(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.lottoView();
        }
    }
}
