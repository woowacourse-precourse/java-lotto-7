package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGame lottoGame = new LottoGame();
        try {
            int amount = lottoGame.getPurchaseAmount();
            List<Lotto> lottos = lottoGame.generateLottos(amount);
            System.out.println(amount / 1000 + "개를 구매했습니다.");
            lottos.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
