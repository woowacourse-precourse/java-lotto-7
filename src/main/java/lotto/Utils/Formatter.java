package lotto.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import lotto.Domain.Lottos;
import lotto.Messages.OutputMessage;

public class Formatter {

    public static String formatLottoCount(Lottos lottos) {
        return String.format(OutputMessage.PURCHASED_LOTTO_COUNT_MESSAGE.getMessage(), lottos.getLottosCount());
    }

    public static List<String> formatLottos(Lottos lottos) {
        List<String> formattedLottos = new ArrayList<>();

        List<Lotto> lottoList = lottos.getLottoList();
        for (int i = 0; i < lottos.getLottosCount(); i++) {
            formattedLottos.add(formatLotto(lottoList.get(i)));
        }

        return formattedLottos;
    }

    public static String formatLotto(Lotto lotto) {
        StringBuilder result = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();

        result.append(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));

        return result.toString();
    }

}
