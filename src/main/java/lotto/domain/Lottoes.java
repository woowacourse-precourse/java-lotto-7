package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.ConstantVariable;

public class Lottoes {
    private final List<Lotto> lottoes = new ArrayList<>();

    public static Lottoes from(Money money) {
        return new Lottoes(money);
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    private Lottoes(Money money) {
        int lottoCount = money.getValue() / ConstantVariable.LOTTO_PRICE.value();

        while (lottoCount-- > 0) {
            lottoes.add(createLotto());
        }
    }

    private Lotto createLotto() {
        List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .toList();

        return new Lotto(lottoNums);
    }
}
