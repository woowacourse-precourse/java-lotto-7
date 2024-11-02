package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        // TODO: 프로그램 구현
        // 임의의 구입 금액을 설정하여 테스트
        int purchaseAmount = 5000; // 5,000원이면 로또 5장을 발행해야 함
        List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);

        System.out.println(purchasedLottos.size() + "개의 로또를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println("Lotto Numbers: " + lotto.getNumbers());
        }
    }
}
