package lotto.view.converter;

import java.util.List;
import lotto.domain.Lotto;

public class LottoMessageConverter implements MessageConverter<Lotto> {

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private final static String NUMBER_SEPARATOR = ", ";

    @Override
    public List<String> convert(List<Lotto> targets) {
        return targets.stream()
                .map(this::toMessage)
                .toList();
    }

    private String toMessage(Lotto lotto) {
        List<String> lottoNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .toList();

        String lottoMessage = String.join(NUMBER_SEPARATOR, lottoNumbers);
        return LEFT_BRACKET + lottoMessage + RIGHT_BRACKET;
    }
}
