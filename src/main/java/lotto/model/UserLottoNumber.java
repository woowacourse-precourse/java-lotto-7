package lotto.model;

import java.util.List;
import lotto.util.Convertor;
import lotto.util.Sorter;
import lotto.util.Splitter;

public class UserLottoNumber {
    private String numbers;

    public UserLottoNumber(String numbers) {
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Sorter.sort(Convertor.arrayToList(Splitter.split(numbers)));
    }
}
