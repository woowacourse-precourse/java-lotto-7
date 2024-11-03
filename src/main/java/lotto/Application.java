package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import static lotto.LottoConstants.*;

public class Application {
    public static void main(String[] args) {
        // 금액 입력 및 로또 구매
        int budget = getValidBudget();
        int lottoCount = getValidLottoCount(budget);
        List<Lotto> purchasedLottos = purchaseLotto(lottoCount);

        // 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = getValidWinningNumbers();
        Lotto winningLotto = getValidWinningLotto(winningNumbers);

        //int bonusNumber = getValidBonusNumber(winningLotto);
        System.out.println("보너스 번호를 입력해 주세요.");


        System.out.println("당첨 통계");
        System.out.println("---");
        //printWinningStatistics();  // TODO : 당첨 통계 처리
    }

    private static int getValidBudget() {
        while (true) {
            try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
        }
        }
    }

    private static int getValidLottoCount(int budget) {
        while (true) {
            try {
                LottoGenerator lottoGenerator = new LottoGenerator();
                int lottoCount = lottoGenerator.getLottoCount(budget);
                System.out.println(lottoCount + "개를 구매했습니다.");
                return lottoCount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                budget = getValidBudget();
            }
        }
    }

    private static List<Lotto> purchaseLotto(int lottoCount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoGenerator.generateLotto();
            System.out.println(lotto.getSortedLottoNumbers());
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    private static List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumberInput = Console.readLine();
                return WinningNumberParser.parse(winningNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto getValidWinningLotto(List<Integer> winningNumbers) {
        while (true) {
            try {
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers = getValidWinningNumbers();
            }
        }
    }

}
