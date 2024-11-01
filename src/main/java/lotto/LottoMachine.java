package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int BUY_AMOUNT_MIN_VALUE = Lotto.PRICE;
    public static final int BUY_AMOUNT_MAX_VALUE = (Integer.MAX_VALUE / Lotto.PRICE) * Lotto.PRICE;
    private static final String FORMATTED_MIN_VALUE = NumberFormat.getInstance().format(BUY_AMOUNT_MIN_VALUE);
    private static final String FORMATTED_MAX_VALUE = NumberFormat.getInstance().format(BUY_AMOUNT_MAX_VALUE);
    public static final String RANGE_ERROR_MESSAGE =
            "로또 구입 금액은 " + FORMATTED_MIN_VALUE + "부터 " + FORMATTED_MAX_VALUE + "까지의 숫자여야 합니다.";
    public static final String NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE = "로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public List<Lotto> getLottos(int buyAmount) {
        validateBuyAmount(buyAmount);

        int lottoCount = buyAmount / Lotto.PRICE;
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> getLotto())
                .toList();

        return lottos;
    }

    public Lotto getLotto() {
        List<Integer> lottoNumbers = getRandomLottoNumbers();

        return new Lotto(lottoNumbers);
    }

    private List<Integer> getRandomLottoNumbers() {
        return pickUniqueNumbersInRange(
                LottoNumber.MIN_VALUE,
                LottoNumber.MAX_VALUE,
                Lotto.NUMBER_SIZE
        );
    }

    private void validateBuyAmount(int buyAmount) {
        validateBuyAmountRange(buyAmount);
        validateBuyAmountDivisibleLottoPrice(buyAmount);
    }

    private void validateBuyAmountRange(int buyAmount) {
        if (buyAmount < BUY_AMOUNT_MIN_VALUE || buyAmount > BUY_AMOUNT_MAX_VALUE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateBuyAmountDivisibleLottoPrice(int buyAmount) {
        if (buyAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE);
        }
    }
}
