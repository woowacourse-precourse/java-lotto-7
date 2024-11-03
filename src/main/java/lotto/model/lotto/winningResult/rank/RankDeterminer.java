package lotto.model.lotto.winningResult.rank;

public interface RankDeterminer<T> {
    Rank determine(T input);
}
