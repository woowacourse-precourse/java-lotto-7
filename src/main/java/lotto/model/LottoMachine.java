package lotto.model;

import static lotto.utils.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constants;
import lotto.utils.ErrorMessages;

public class LottoMachine {

    private final Integer price;
    private final Integer count;
    private final List<Lotto> lottos;

    public LottoMachine(Integer price) {
        validateLottoPrice(price);
        this.price = price;
        this.count = countLotto(price);
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> generateLotto() {
        for (int i = 0; i < count; i++) {
            lottos.add(createRandomLotto());
        }
        return this.lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPrice() {
        return price;
    }

    private void validateLottoPrice(Integer price) {
        validateLottoPriceIsValid(price);
        validateLottoPriceIsPositive(price);
    }

    private void validateLottoPriceIsValid(Integer price) {
        if (price % LOTTO_PRICE_VALIDATE_VALUE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_PRICE);
        }
    }

    private void validateLottoPriceIsPositive(Integer price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_PRICE_IS_POSITIVE);
        }
    }

    private Integer countLotto(Integer price) {
        return price / 1000;
    }

    private Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
