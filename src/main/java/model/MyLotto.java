package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLotto {
    private final List<Lotto> myLotto;

    public MyLotto(int lottoNum) {
        this.myLotto = Stream.generate(Lotto::new)
                .limit(lottoNum)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<List<Integer>> getMyLotto() {
        return myLotto.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
