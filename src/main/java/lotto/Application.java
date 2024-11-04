package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.view.InputView;
import lotto.view.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int amount = InputView.readPurchaseAmount();
            int count = amount / 1000;

            List<Lotto> lottos = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                lottos.add(new Lotto(numbers));
            }

            OutputView.printPurchaseCount(count);
            OutputView.printLottos(lottos);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
