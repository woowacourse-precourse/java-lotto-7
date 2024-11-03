package lotto.view.output.message;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoMessageGenerator {

    public static final String PURCHASED_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    public static final String NUMBER_DELIMITER = ", ";
    public static final String NUMBERS_PREFIX = "[";
    public static final String NUMBERS_SUFFIX = "]";

    public String getPurchaseQuantityMessage(int quantity) {
        return String.format(PURCHASED_QUANTITY_FORMAT, quantity);
    }

    public String getSortedNumbersMessage(Lotto purchasedLotto) {
        List<LottoNumber> numbers = purchasedLotto.getNumbers();
        Collections.sort(numbers);

        StringJoiner stringJoiner = new StringJoiner(NUMBER_DELIMITER, NUMBERS_PREFIX, NUMBERS_SUFFIX);
        numbers.stream()
                .map(this::getStringValue)
                .forEach(stringJoiner::add);

        return stringJoiner.toString();
    }

    private String getStringValue(LottoNumber number) {
        return String.valueOf(number.number());
    }

}
