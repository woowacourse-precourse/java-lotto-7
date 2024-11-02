package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.lang.String.format;
import static lotto.domain.constant.LottoConstraint.FIXED_LOTTO_SIZE;
import static lotto.domain.constant.LottoConstraint.LIMITED_NUMBER_OF_AUTOMATIC_LOTTO_ISSUED;
import static lotto.domain.constant.LottoConstraint.LOTTO_PRICE_UNIT;
import static lotto.domain.constant.LottoConstraint.MAXIMUM_NUMBER_VALUE;
import static lotto.domain.constant.LottoConstraint.MINIMUM_NUMBER_VALUE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutomaticLottoMachine {

    public static final String ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE = "[ERROR] %d 원 단위의 금액을 입력해야 합니다.";
    public static final String ERROR_LIMITED_IN_SIZE = "[ERROR] 인당 최대 %d 개 까지만 구입 가능합니다.";

    private final List<Lotto> lottos;

    public AutomaticLottoMachine(int amount) {
        verifyAmount(amount);
        int quantity = calculateQuantity(amount);
        verifyLimitSize(quantity);
        this.lottos = issueAutomatic(quantity);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private List<Lotto> issueAutomatic(int quantity) {
        return Stream.generate(
                        () -> pickUniqueNumbersInRange(MINIMUM_NUMBER_VALUE, MAXIMUM_NUMBER_VALUE, FIXED_LOTTO_SIZE))
                .limit(quantity)
                .map(Lotto::new)
                .toList();
    }

    private void verifyAmount(int amount) {
        verifyPositive(amount);
        verifyPriceUnit(amount);
    }

    private int calculateQuantity(int amount) {
        return amount / LOTTO_PRICE_UNIT;
    }

    private static void verifyLimitSize(int quantity) {
        boolean isExceed = LIMITED_NUMBER_OF_AUTOMATIC_LOTTO_ISSUED < quantity;
        if (isExceed) {
            throw new IllegalArgumentException(format(ERROR_LIMITED_IN_SIZE, LIMITED_NUMBER_OF_AUTOMATIC_LOTTO_ISSUED));
        }
    }

    private static void verifyPositive(int amount) {
        boolean isNegativeOrZero = amount <= 0;
        if (isNegativeOrZero) {
            throw new IllegalArgumentException(format(ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE, LOTTO_PRICE_UNIT));
        }
    }

    private static void verifyPriceUnit(int amount) {
        boolean isNotLottoPurchaseUnit = amount % LOTTO_PRICE_UNIT != 0;
        if (isNotLottoPurchaseUnit) {
            throw new IllegalArgumentException(format(ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE, LOTTO_PRICE_UNIT));
        }
    }

    public int getQuantity() {
        return lottos.size();
    }
}
