package lotto.model;

public interface RankProvider {

    String provide(WinningResult result);

    Long totalPrize(WinningResult result);

}
