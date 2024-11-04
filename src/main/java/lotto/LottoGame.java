package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int numberOfPurchase;
    private List<Lotto> userLottos;
    private Lotto winningLotto;
    private int bonusNumber;
    private int priseMoney = 0;

    public void start() {
        try {
            numberOfPurchase = InputHandler.getPurchaseAmountFromUser();
            userLottos = generateLottos(numberOfPurchase);
            printLottos();

            winningLotto = InputHandler.getWinningNumberFromUser();
            bonusNumber = InputHandler.getBonusNumberFromUser();

            winningStatistics();
            WinningRank.printStatics();
            printRateOfReturn();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> generateLottos(int numberOfPurchase) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfPurchase; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private void printLottos() {
        System.out.println(userLottos.size() + "개를 구매했습니다.");
        userLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private void winningStatistics() {
        for (Lotto lotto : userLottos) {
            long matchCount = lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean checkIncludeBonus = lotto.getNumbers().contains(bonusNumber);
            WinningRank winningRank = WinningRank.valueOfMatchCount(matchCount, checkIncludeBonus);
            winningRank.addMatchingLottoNumbers();
            priseMoney += winningRank.getPrizeMoney();
        }
    }

    private void printRateOfReturn() {
        double rateOfReturn = (double) priseMoney / (numberOfPurchase * InputValidator.TICKET_PRICE) * 100;
        System.out.printf("총 수익률은 %s%%입니다.%n", rateOfReturn);
    }
}
