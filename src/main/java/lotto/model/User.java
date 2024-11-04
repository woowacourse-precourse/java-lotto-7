package lotto.model;

import lotto.model.enums.Prize;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<List<Integer>> lottos;
    private final Map<Prize, Integer> results;

    public User() {
        this.lottos = new ArrayList<>();
        this.results = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            this.results.put(prize, 0);
        }
    }

    public void addLotto(List<Integer> lotto) {
        this.lottos.add(lotto);
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }

    public void addResult(Prize prize) {
        if (prize != null) {
            this.results.put(prize, this.results.get(prize) + 1);
        }
    }

    public Map<Prize, Integer> getResults() {
        return this.results;
    }
}