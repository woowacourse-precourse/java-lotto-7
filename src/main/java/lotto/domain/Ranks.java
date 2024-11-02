package lotto.domain;

import java.util.List;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int count() {
        return ranks.size();
    }
}
