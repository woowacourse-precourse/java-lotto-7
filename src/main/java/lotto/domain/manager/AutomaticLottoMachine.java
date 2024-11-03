package lotto.domain.manager;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.lang.String.format;
import static lotto.domain.constant.LottoConstraintProperties.FIXED_LOTTO_SIZE;
import static lotto.domain.constant.LottoConstraintProperties.LIMITED_NUMBER_OF_AUTOMATIC_LOTTO_ISSUED;
import static lotto.domain.constant.LottoConstraintProperties.LOTTO_PRICE_UNIT;
import static lotto.domain.constant.LottoConstraintProperties.MAXIMUM_NUMBER_VALUE;
import static lotto.domain.constant.LottoConstraintProperties.MINIMUM_NUMBER_VALUE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.model.Lotto;

public class AutomaticLottoMachine {

    private static final String ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE = "[ERROR] %d 원 단위의 금액을 입력해야 합니다.";
    private static final String ERROR_LIMITED_IN_SIZE = "[ERROR] 인당 최대 %d 개 까지만 구입 가능합니다.";

    private final List<Lotto> lottos;

    public AutomaticLottoMachine(int amount) {
        verifyAmount(amount);
        int quantity = calculateQuantity(amount);
        verifyLimitSize(quantity);
        this.lottos = issueAutomatic(quantity);
    }

    public int getQuantity() {
        return lottos.size();
    }

    public int getAmount() {
        return lottos.size() * LOTTO_PRICE_UNIT;
    }

    public Stream<Lotto> getLottos() {
        return this.lottos.stream();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()));
    }

    private List<Lotto> issueAutomatic(int quantity) {
        Set<List<Integer>> uniqueLottos = new HashSet<>();

        return Stream.generate(() -> {
                    List<Integer> automaticLotto = getUniqueLotto(uniqueLottos);
                    uniqueLottos.add(automaticLotto);
                    return automaticLotto;
                })
                .limit(quantity)
                .map(Lotto::new)
                .toList();
    }

    private static List<Integer> getUniqueLotto(Set<List<Integer>> uniqueLottos) {
        List<Integer> automaticLotto;
        do {
            automaticLotto = pickUniqueNumbersInRange(MINIMUM_NUMBER_VALUE, MAXIMUM_NUMBER_VALUE, FIXED_LOTTO_SIZE);
        } while (uniqueLottos.contains(automaticLotto));

        return automaticLotto;
    }

    private void verifyAmount(int amount) {
        verifyPositive(amount);
        verifyPriceUnit(amount);
    }

    private int calculateQuantity(int amount) {
        return amount / LOTTO_PRICE_UNIT;
    }

    private void verifyLimitSize(int quantity) {
        boolean isExceed = LIMITED_NUMBER_OF_AUTOMATIC_LOTTO_ISSUED < quantity;
        if (isExceed) {
            throw new IllegalArgumentException(format(ERROR_LIMITED_IN_SIZE, LIMITED_NUMBER_OF_AUTOMATIC_LOTTO_ISSUED));
        }
    }

    private void verifyPositive(int amount) {
        boolean isNegativeOrZero = amount <= 0;
        if (isNegativeOrZero) {
            throw new IllegalArgumentException(format(ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE, LOTTO_PRICE_UNIT));
        }
    }

    private void verifyPriceUnit(int amount) {
        boolean isNotLottoPurchaseUnit = amount % LOTTO_PRICE_UNIT != 0;
        if (isNotLottoPurchaseUnit) {
            throw new IllegalArgumentException(format(ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE, LOTTO_PRICE_UNIT));
        }
    }
}
