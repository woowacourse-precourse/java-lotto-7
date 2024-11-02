package lotto.model;

@FunctionalInterface
public interface LottoLankMatcher {

    boolean matchRank(int matchCount, boolean matchBonus);
}
