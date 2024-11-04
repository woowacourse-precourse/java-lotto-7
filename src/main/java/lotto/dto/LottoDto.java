package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {
    private List<Integer> lotto;

    public LottoDto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public void setLotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    @Override
    public String toString() {
        return lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
