package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottoResult;
import lotto.model.budget.Budget;
import lotto.model.win.Prize;
import lotto.model.win.WinningNumbers;

public class LottoGame {
    private final Budget budget;
    private final LottoManager lottoManager;

    public LottoGame(Budget budget) {
        this.budget = budget;
        this.lottoManager = new LottoManager();
        init();
    }

    protected void init() {
        int affordableCount = budget.getCount();
        lottoManager.addLotteries(affordableCount);
    }

    public List<Lotto> getItems() {
        Stream<Lotto> stream = lottoManager.getStream();
        return stream.toList();
    }

    public LottoResult play(WinningNumbers winningNumbers) {

        List<Prize> prizes = new ArrayList<>();
        Stream<Lotto> lottoStream = lottoManager.getStream();

        lottoStream.forEach(lotto -> {
            Prize prize = winningNumbers.compare(lotto);
            prizes.add(prize);
        });

        return LottoResult.builder()
                .budget(budget)
                .addAllPrize(prizes)
                .build();
    }

}
