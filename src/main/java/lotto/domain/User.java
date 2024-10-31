package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class User {
    private String input;
    private int numOfLottos;
    private List<Lotto> lottos;

    public User(String input, int numOfLottos, List<Lotto> lottos) {
        this.input = input;
        this.numOfLottos = numOfLottos;
        this.lottos = lottos;
    }
}
