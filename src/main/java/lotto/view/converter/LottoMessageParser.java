package lotto.view.converter;

import java.util.List;
import lotto.common.NumberParser;
import lotto.domain.Lotto;

public class LottoMessageParser implements MessageParser<Lotto> {

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private final static String NUMBER_SEPARATOR_TO_MESSAGE = ", ";
    private final static String NUMBER_SEPARATOR_TO_OBJECT = ",";

    @Override
    public List<String> toMessages(List<Lotto> targets) {
        return targets.stream().map(this::toMessage).toList();
    }

    @Override
    public List<Integer> toNumbers(String message) {
        List<String> numbersString = List.of(message.split(NUMBER_SEPARATOR_TO_OBJECT));
        List<Integer> numbers = numbersString.stream()
                .map(NumberParser::toInt)
                .toList();


    }

    private String toMessage(Lotto lotto) {
        List<String> lottoNumbers = lotto.getNumbers().stream().
                map(String::valueOf)
                .toList();

        String lottoMessage = String.join(NUMBER_SEPARATOR_TO_MESSAGE, lottoNumbers);
        return LEFT_BRACKET + lottoMessage + RIGHT_BRACKET;
    }
}
