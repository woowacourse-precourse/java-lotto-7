package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstants;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public List<Lotto> createLottos(Money money) {
        validateMoney(money);
        return IntStream.range(0, money.getLottoCount())
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_LOTTO_NUMBER,
                LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.LOTTO_NUMBER_SIZE
        ));
    }

    private void validateMoney(Money money) {
        if (money == null) {
            throw new IllegalStateException("금액이 초기화되지 않았습니다.");
        }
    }
}
