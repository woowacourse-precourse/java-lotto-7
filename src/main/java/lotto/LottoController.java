package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputHandler inputHandler;
    private final View view;
    private final LottoService lottoService;

    public LottoController(InputHandler inputHandler, LottoService lottoService, View view) {
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
        this.view = view;
    }

    public void run() {
        Integer count = getAmountFromUser();
        WinLotto winLotto = getWinningNumber();
        Lottos lottos = createLottos(count);
        displayLottos(count, lottos);
        calculateTotalPrize(lottos, winLotto, count);
    }

    public void calculateTotalPrize(Lottos lottos, WinLotto winLotto, Integer count) {
        List<Rank> ranks = lottoService.calculateWinnings(lottos, winLotto);
        Map<Rank, Integer> rankFrequency = rankCounter(ranks);
        double revenue = lottoService.calculateRevenue(ranks, count * 1000);
        view.total(rankFrequency);
        view.revenue(revenue);
    }

    public Map<Rank, Integer> rankCounter(List<Rank> ranks) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        for (Rank rank : ranks) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    public void displayLottos(Integer count, Lottos lottos) {
        view.count(count);
        view.lottos(lottos);
    }

    public Integer getAmountFromUser() {
        Integer amount = inputHandler.handleAmount();
        return amount/1000;
    }

    public WinLotto getWinningNumber() {
        Lotto winNumberLotto = inputHandler.handleWinNumbers();
        return inputHandler.handleBonusNumber(winNumberLotto);
    }

    public Lottos createLottos(Integer count) {
        return lottoService.createLottos(count);
    }
}
