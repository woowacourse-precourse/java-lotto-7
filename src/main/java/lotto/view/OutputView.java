package lotto.view;

import java.util.List;
import lotto.dto.EarnedLotto;
import lotto.dto.EarnedLottos;

public class OutputView {
    private static final String LOTTO_INFORMATION_PREFIX = "[";
    private static final String LOTTO_INFORMATION_SUFFIX = "]";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";
    public void printLottoNumbers(EarnedLottos dto) {
        System.out.printf(OutputViewMessage.LOTTO_BUY_COUNT_MESSAGE.getMessage(), dto.lottosDto().size());
        dto.lottosDto().forEach(this::printLottoDto);
    }

    private void printLottoDto(EarnedLotto earnedLotto) {
        StringBuilder sb = new StringBuilder(LOTTO_INFORMATION_PREFIX);
        List<String> list = earnedLotto.numbers().stream().map(String::valueOf).toList();
        sb.append(String.join(LOTTO_NUMBER_SEPARATOR, list));
        sb.append(LOTTO_INFORMATION_SUFFIX);
        System.out.println(sb);
    }
}
