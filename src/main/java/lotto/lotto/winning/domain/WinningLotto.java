package lotto.lotto.domain.winning.domain;

import lotto.constant.Separator;
import lotto.lotto.domain.Lotto;
import lotto.util.Convertor;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }
    public static WinningLotto of(String input) {
        List<Integer> lotto = Convertor.splitByList(input);
        return new WinningLotto(new Lotto(lotto));
    }
    @Override
    public String toString() {
        return lotto.info().stream().map(String::valueOf)
                .collect(Collectors.joining(Separator.COMMA));
    }
    public boolean isContain(int number) {
        return lotto.isContains(number);
    }
}
