package lotto.service;
import lotto.domain.AutoLotto;
import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import static lotto.domain.rule.LottoRules.AUTO_LOTTO_PRICE;
import static lotto.domain.message.LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO;

public class LottoService {

    public List<AutoLotto> createAutoLottosByLottoPrice(int totalLottoPrice) {
        List<AutoLotto> autoLottos = new ArrayList<>();
        validateLottoPrice(totalLottoPrice);
        int autoLottoCount = totalLottoPrice / AUTO_LOTTO_PRICE.getValue();
        for (int i = 0; i < autoLottoCount; i++) {
            autoLottos.add(Lotto.createRandomLotto());
        }
        return autoLottos;
    }

    // 테스트 해야함
    private void validateLottoPrice(int totalLottoPrice) {
        if(isNotValidateLottoPrice(totalLottoPrice)){
            throw new IllegalArgumentException(INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
        }
    }

    // 0이 들어오거나, 로또 가격에 나누어떨어지지 않는 경우 -> 하나라도 걸리면 자동 로또 못 만들음
    private boolean isNotValidateLottoPrice(int totalLottoPrice) {
        return isZeroLottoPrice(totalLottoPrice) || !(isDivisibleByLottoPrice(totalLottoPrice));
    }

    private boolean isZeroLottoPrice(int totalLottoPrice) {
        return totalLottoPrice == 0;
    }

    private boolean isDivisibleByLottoPrice(int totalLottoPrice) {
        return totalLottoPrice % AUTO_LOTTO_PRICE.getValue() == 0;
    }
}
