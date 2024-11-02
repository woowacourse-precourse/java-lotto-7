package lotto.dto.output;

import lotto.domain.ResultLotto;

import java.util.Arrays;
import java.util.List;

public class ResultLottosDto {
    private final List<String> results;

    public ResultLottosDto() {
        this.results = Arrays.stream(ResultLotto.values()).map(this::transformDto).toList();
    }

    public List<String> getResults() {
        return results.stream().toList();
    }

    private String transformDto(ResultLotto resultLotto) {
        return transformWinLottoRank(resultLotto) +
                "(" + resultLotto.getLottoAmount() + "원) - " +
                resultLotto.getCount() + "개";
    }

    private String transformWinLottoRank(ResultLotto resultLotto) {
        if(resultLotto.getWinLottoNumberCount() == 5 && resultLotto.getBonusNumber() == 1) {
            return resultLotto.getWinLottoNumberCount() + "개 일치, 보너스 볼 일치 ";
        }
        return resultLotto.getWinLottoNumberCount() + "개 일치 ";
    }
}
