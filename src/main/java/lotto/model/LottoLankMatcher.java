package lotto.model;

@FunctionalInterface
public interface LottoLankMatcher {

    boolean matchRank(int numberMatchCount, boolean bonusNumberMatch);
}
