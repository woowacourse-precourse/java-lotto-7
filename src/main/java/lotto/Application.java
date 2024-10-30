package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        String lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();

        int lottoCount = Integer.parseInt(lottoPurchaseMoney) / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        
    }
}
