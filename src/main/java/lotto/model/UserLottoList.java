package lotto.model;

import static java.util.stream.IntStream.range;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoNumberGenerator;

public class UserLottoList {

    private final int number;
    private final List<Lotto> lottoList;

    public UserLottoList(int number) {
        this.number = number;
        this.lottoList = generateNumberOfLotto(number);
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
