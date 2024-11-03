package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoDto {

    private final List<Integer> lotteries;

    private LottoDto(List<Integer> lotteries) {
        this.lotteries = lotteries;
    }

    public static List<LottoDto> toDto(List<Lotto> lotteries) {
        return lotteries.stream()
                .map(LottoDto::from)
                .toList();
    }

    private static LottoDto from(final Lotto lotto) {
        List<Integer> lotteries = new ArrayList<>(lotto.getNumbers());
        Collections.sort(lotteries);

        return new LottoDto(List.copyOf(lotteries));
    }

    public List<Integer> getLottoNumber() {
        return List.copyOf(lotteries);
    }
}
