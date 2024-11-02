package lotto.dto.output;

import lotto.domain.ResultLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static lotto.domain.Lotto.LOTTO_BONUS_COUNT;
import static lotto.domain.Lotto.LOTTO_BONUS_RANK_COUNT;

public class ResultLottosDto {
    private static final String LOTTO_AMOUNT_START = "(";
    private static final String LOTTO_AMOUNT_END = "원) - ";
    private static final String COUNT = "개";
    private static final String BONUS_VIEW = "개 일치, 보너스 볼 일치 ";
    private static final String LOTTO_COUNT = "개 일치 ";

    private final List<String> results;

    public ResultLottosDto() {
        this.results = Arrays.stream(ResultLotto.values()).map(this::transformDto).toList();
    }

    public List<String> getResults() {
        return results.stream().toList();
    }

    private String transformDto(ResultLotto resultLotto) {
        return transformWinLottoRank(resultLotto) +
                LOTTO_AMOUNT_START +
                formatWithCommas(resultLotto.getLottoAmount()) +
                LOTTO_AMOUNT_END +
                resultLotto.getCount() +
                COUNT;
    }

    private String transformWinLottoRank(ResultLotto resultLotto) {
        if (Objects.equals(resultLotto.getWinLottoNumberCount(), LOTTO_BONUS_RANK_COUNT) &&
                Objects.equals(resultLotto.getBonusNumber(), LOTTO_BONUS_COUNT)) {
            return resultLotto.getWinLottoNumberCount() + BONUS_VIEW;
        }
        return resultLotto.getWinLottoNumberCount() + LOTTO_COUNT;
    }

    private String formatWithCommas(int number) {
        return String.format("%,d", number);
    }
}
