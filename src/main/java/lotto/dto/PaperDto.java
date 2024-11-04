package lotto.dto;

import java.util.Arrays;
import java.util.List;

public class PaperDto {
    List<Integer> lotto;

    public PaperDto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public String toString() {
        return Arrays.toString(lotto.toArray());
    }
}
