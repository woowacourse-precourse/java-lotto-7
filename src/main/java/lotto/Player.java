package lotto;

import static lotto.LottoRule.LOTTO_PRICE;
import static lotto.LottoRule.WINNING_PRIZE_TABLE;

import java.util.ArrayList;
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
    private String[] winningPlaceDescriptionFormats = {
        "",
        "6개 일치 (2,000,000,000원) - %d개\n",
        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
        "5개 일치 (1,500,000원) - %d개\n",
        "4개 일치 (50,000원) - %d개\n",
        "3개 일치 (5,000원) - %d개\n",
    };

    public void buyLottos(int purchaseAmount) {
        evaluated = false;
        lottos.clear();
        this.purchaseAmount = purchaseAmount;
        lottoAmount = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(machine.issue());
        }
    }

    public String getLottoDescription() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.describe() + "\n");
        }
        return sb.toString();
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

    public String getWinningResult() {
        if (!evaluated)
            throw new IllegalStateException("[ERROR] 로또 추첨을 하지 않았습니다.");

        StringBuilder sb = new StringBuilder();
        for (int i = 5; i > 0; i--) {
            sb.append(String.format(winningPlaceDescriptionFormats[i], winningCounts[i]));
        }
        return sb.toString();
    }

    public float getRateOfReturn() {
        if (!evaluated)
            throw new IllegalStateException("[ERROR] 로또 추첨을 하지 않았습니다.");

        return ((float)totalPrize / purchaseAmount) * 100;
    }

    public int getLottoAmount() {
        return this.lottoAmount;
    }
}
