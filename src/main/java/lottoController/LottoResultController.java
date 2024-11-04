package lottoController;

import lotto.Lotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoResultController {
    private final int PROFIT_RANK_1 = 2000000000;
    private final int PROFIT_RANK_2 = 30000000;
    private final int PROFIT_RANK_3 = 1500000;
    private final int PROFIT_RANK_4 = 50000;
    private final int PROFIT_RANK_5 = 5000;

    private static Lotto winningNumber;
    private static int bonusNumber;
    private static int[] rankCount = new int[5];
    GenerateLottoController generateLottoController = new GenerateLottoController();

    public void showLottoResult() {
        saveWinningNumber(InputView.inputWinningNumber());
        saveBonusNumber(InputView.inputBonusNumber());
        checkLottoResult();
    }

    public void saveWinningNumber(String inputWinningNumber) {
        String[] stringWinningNumber = inputWinningNumber.split(",");
        List<Integer> validWinningNumber = new ArrayList<>();

        try {
            for (String number : stringWinningNumber) {
                validWinningNumber.add(Integer.parseInt(number));
            }
            winningNumber = new Lotto(validWinningNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERORR] 숫자만 입력 가능 합니다.");
        }
    }

    public void saveBonusNumber(String inputBonusNumber) {
        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);

            if (bonusNumber > 45 || bonusNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            ArrayList<Integer> invalidNumbers = new ArrayList<>(winningNumber.getNumbers());
            if (invalidNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
            }

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkLottoResult() {
        List<Lotto> lottoList = generateLottoController.getLottoList();

        for (Lotto lotto : lottoList) {
            saveRank(decideRank(lotto));
        }

        float profitRate = calculateProfitRate();

        OutputView.printResult(rankCount, profitRate);
    }

    public int decideRank(Lotto lotto) {
        long winningCount = winningNumber.getNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number)).count();

        if (winningCount < 3) return -1;

        if (winningCount == 3) return 4;

        if (winningCount == 4) return 3;

        if (winningCount == 5) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public void saveRank(int rank) {
        if (rank >= 0) rankCount[rank]++;
    }

    public float calculateProfitRate() {
        int lottoPrice = generateLottoController.getLottoPrice();
        int totalProfit = getTotalProfit();

        return (float) totalProfit / (float) lottoPrice * 100;
    }

    public int getTotalProfit() {
        int totalProfit = 0;

        for (int i = 0; i < rankCount.length; i++) {
            totalProfit += getRankProfit(i) * rankCount[i];
        }
        return totalProfit;
    }

    public int getRankProfit(int rank) {
        if (rank == 4) {
            return PROFIT_RANK_5;
        }
        if (rank == 3) {
            return PROFIT_RANK_4;
        }
        if (rank == 2) {
            return PROFIT_RANK_3;
        }
        if (rank == 1) {
            return PROFIT_RANK_2;
        }
        if (rank == 0) {
            return PROFIT_RANK_1;
        }
        return 0;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
