package lotto.model;

import static java.util.stream.IntStream.range;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoNumberGenerator;

public class UserLottoList {

    private final int count;
    private final List<Lotto> lottoList;

    public UserLottoList(int count) {
        this.count = count;
        this.lottoList = generateNumberOfLotto(count);
    }

    private List<Lotto> generateNumberOfLotto(int number) {
        return range(0, number)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(LottoNumberGenerator.getNumbers());
    }

}
