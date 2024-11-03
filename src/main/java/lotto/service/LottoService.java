package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.Purchase;
import lotto.model.Lotto;
import lotto.model.MyLotto;
import lotto.view.OutputView;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public MyLotto buyLottos(Purchase purchase) {
        OutputView outputView = new OutputView();

        outputView.printLottoAmount(purchase.getAmount());
        return new MyLotto(makeLottoNumbers(purchase.getAmount()));
    }

    private List<Lotto> makeLottoNumbers(BigInteger amount) {
        OutputView outputView = new OutputView();
        List<Lotto> lottos = new ArrayList<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(amount) < 0; i = i.add(BigInteger.ONE)) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted()
                    .toList();
            outputView.printMyLotto(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }
}
