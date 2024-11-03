package lotto.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<List<Integer>> lottos;
    private final Map<Rule, Integer> results;

    public User() {
        this.lottos = new ArrayList<>();
        this.results = new LinkedHashMap<>();
        for (Rule rule : Rule.values()) {
            this.results.put(rule, 0);
        }
    }

    public void addLotto(List<Integer> lotto) {
        this.lottos.add(lotto);
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }

    public void addResult(Rule rule) {
        if (rule != null) {
            this.results.put(rule, this.results.get(rule) + 1);
        }
    }

    public Map<Rule, Integer> getResults() {
        return this.results;
    }
}