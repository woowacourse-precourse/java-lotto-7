package lotto;

import static lotto.LottoRule.LOTTO_PRICE;
import static lotto.LottoRule.WINNING_PRIZE_TABLE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Player
 */
public class Player {

    private List<Lotto> lottos = new ArrayList<>();
    private LottoMachine machine = new LottoMachine();
    private int[] winningCounts = new int[6];
    private int totalPrize = 0;
    private int purchaseAmount = 0;
    private int lottoAmount = 0;
    private boolean evaluated = false;

    public void buyLottos(int purchaseAmount) {
        evaluated = false;
        lottos.clear();
        this.purchaseAmount = purchaseAmount;
        lottoAmount = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(machine.issue());
        }
    }

    public void evalutateLottos(List<Integer> winningNumbers, int bonusNumber) {
        if (lottos.size() == 0)
            throw new IllegalStateException("[ERROR] 로또를 구매하지 않았습니다.");

        totalPrize = 0;
        winningCounts = new int[6];
        for (Lotto lotto : lottos) {
            int place = lotto.getPlace(winningNumbers, bonusNumber);
            winningCounts[place] += 1;
        }
        for (int i = 1; i < 6; i++) {
            totalPrize += winningCounts[i] * WINNING_PRIZE_TABLE[i];
        }
        evaluated = true;
    }

    public float getRateOfReturn() {
        if (!evaluated)
            throw new IllegalStateException("[ERROR] 로또 추첨을 하지 않았습니다.");

        return ((float)totalPrize / purchaseAmount) * 100;
    }

    public int getLottoAmount() {
        return this.lottoAmount;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int[] getWinningCounts() {
        return winningCounts.clone();
    }
}
