package lotto.model.rank;

public interface RankDeterminer<T> {
    Rank determine(T input);
}
