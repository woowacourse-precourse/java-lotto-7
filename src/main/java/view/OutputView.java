package view;

import domain.LottoResult;
import lotto.Lotto;
import service.LottoService;

import java.util.List;

public class OutputView {
    LottoService lottoService;

    public OutputView(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void printPurchaseMsg(LottoResult result) {
        System.out.println(result.getTotalLottos() + Messages.AMOUNT_PURCHASE_MSG.getMessage());
        List<Lotto> purchasedLottos = result.getPurchasedLottos();
    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(numbers.size() - 1) + "]");
    }

    // 3-0 , 4-1 , 5-2, 6-3
    public void showResult(LottoResult lottoResult) {
        System.out.println(Messages.TOTAL_WINNING_MSG.getMessage());
        int[] result = new int[5];
        for (Lotto lotto : lottoResult.getPurchasedLottos()) {
            int equal = lottoService.getResult(lottoResult, lotto);
            boolean isBonus = lottoService.getBonus(lottoResult.getBonusNumber(), lotto);
            lottoService.setResult(equal, result, isBonus);
        }
        printBonusAndEqual(result);
        printRatio(result, lottoResult.getPurchaseAmount());
    }

    private void printRatio(int[] result, int cost) {
        int profit = lottoService.getRatio(result);
        double ratio = (double) profit / cost * 100;
        String formattedRatio = String.format("%,.1f%%", ratio);
        System.out.println(Messages.RATIO_FRONT_MSG.getMessage() + formattedRatio + Messages.RATIO_LAST_MSG.getMessage());
    }

    private void printBonusAndEqual(int[] result) {
        String[] values = {"5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000"};
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                printBonus(i + 2, result[i], values[i]);
                continue;
            }
            if (i == 4) {
                printEqual(i + 2, result[i], values[i]);
                continue;
            }
            printEqual(i + 3, result[i], values[i]);
        }
    }

    private void printBonus(int idx, int num, String value) {
        System.out.println(idx + Messages.TOTAL_BONUS_FRONT_MSG.getMessage() + value + Messages.TOTAL_MIDDLE_MSG.getMessage() + num + Messages.TOTAL_LAST_MSG.getMessage());
    }

    private void printEqual(int idx, int num, String value) {
        System.out.println(idx + Messages.TOTAL_FRONT_MSG.getMessage() + value + Messages.TOTAL_MIDDLE_MSG.getMessage() + num + Messages.TOTAL_LAST_MSG.getMessage());
    }


}
