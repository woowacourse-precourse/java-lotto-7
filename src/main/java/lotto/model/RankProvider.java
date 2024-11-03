package lotto.model;

public interface RankProvider {

    String notation(WinningResult result);

    Long totalPrize(WinningResult result);

}
