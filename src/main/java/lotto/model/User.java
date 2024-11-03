package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<List<Integer>> lottos;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(List<Integer> lotto) {
        this.lottos.add(lotto);
    }
}
