package lotto.model;

import java.util.List;
import java.util.Map;

public class Purchase {
    private Integer price;
    private Integer lottoCount;
    private List<Lotto> lottos;
    private List<WinningStandard> winningStandards;
    private List<WinningResult> winningResults;
    private Map<Integer, Integer> winningResultsStatics;
}
