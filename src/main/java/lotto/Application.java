package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.view.InputView;

public class Application {

    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        long totalCost;
        while (true) {
            try {
                totalCost = inputView.inputTotalCost();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> purchased = new ArrayList<>();
        for (int i = 0; i < totalCost/1000; i++) {
            purchased.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        System.out.printf("\n%,d개를 구매했습니다.\n", purchased.size());
        for (Lotto lotto : purchased) {
            System.out.println(lotto.getLottoNumbers());
        }

        List<Integer> winningNumber;
        while (true) {
            try {
                winningNumber = inputView.inputWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                bonusNumber = inputView.inputBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Map<LottoRank, Integer> winningLottoCount = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : purchased) {
            List<Integer> lottoNumber = lotto.getLottoNumbers();
            int count = (int) lottoNumber.stream().filter(winningNumber::contains).count();
            boolean hasBonusNumber = lottoNumber.contains(bonusNumber);
            LottoRank rank = LottoRank.checkRank(count, count == 5 && hasBonusNumber);
            winningLottoCount.merge(rank, 1, Integer::sum);
        }

        System.out.println("\n당첨 통계\n---");
        long totalRewards = 0L;
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }
            System.out.printf("%d개 일치", rank.getSameNumberCount());
            if (rank.isSecondRank()) {
                System.out.print(", 보너스 볼 일치");
            }
            totalRewards += rank.getReward()*winningLottoCount.getOrDefault(rank, 0);
            System.out.printf(" (%,d원) - %,d개\n", rank.getReward(), winningLottoCount.getOrDefault(rank, 0));
        }
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", totalRewards*100.0/totalCost);
    }
}
