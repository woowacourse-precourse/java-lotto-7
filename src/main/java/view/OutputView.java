package view;

import factory.ResultFactory;
import java.util.Map;
import model.Lotto;
import model.Amount;
import model.LottoAmount;
import model.LottoCollection;
import model.Prize;

public class OutputView {

    private static final String PRINT_LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_RESULT_MESSAGE = "당첨 통계" + System.lineSeparator() + "___";
    private static final String PRINT_CORRECT_THREE = "3개 일치 (5,000원) - ";
    private static final String PRINT_CORRECT_FOUR = "4개 일치 (50,000원) - ";
    private static final String PRINT_CORRECT_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String PRINT_CORRECT_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_CORRECT_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String PRINT_EARNING_RATE_MESSAGE_FRONT = "총 수익률은 ";
    private static final String PRINT_EARNING_RATE_MESSAGE_BACK = "%입니다.";

    public OutputView() {

    }

    public void printLottoAmount(LottoAmount lottoAmount) {
        System.out.println(System.lineSeparator() + lottoAmount.getCount() + PRINT_LOTTO_AMOUNT_MESSAGE);
    }

    public void printLottos(LottoCollection lottoCollection) {
        for (Lotto lotto : lottoCollection.getLottos()) {
            System.out.println(lotto);
        }
    }

    public void printResult(ResultFactory resultFactory, Amount amount) {
        StringBuilder sb = new StringBuilder();
        Map<Prize, Integer> result = resultFactory.getResult();
        float earningRate = resultFactory.getEarningRate(amount);

        /*
        sb.append(System.lineSeparator());
        sb.append(PRINT_RESULT_MESSAGE).append(System.lineSeparator());
        sb.append(PRINT_CORRECT_THREE).append(result.get(5)).append(System.lineSeparator());
        sb.append(PRINT_CORRECT_FOUR).append(result.get(4)).append(System.lineSeparator());
        sb.append(PRINT_CORRECT_FIVE).append(result.get(3)).append(System.lineSeparator());
        sb.append(PRINT_CORRECT_FIVE_BONUS).append(result.get(2)).append(System.lineSeparator());
        sb.append(PRINT_CORRECT_SIX).append(result.get(1)).append(System.lineSeparator());
        sb.append(PRINT_EARNING_RATE_MESSAGE_FRONT).append(String.format("%.1f",earningRate)).append(PRINT_EARNING_RATE_MESSAGE_BACK);

        System.out.println(sb);
         */
        System.out.println();
        System.out.println(PRINT_RESULT_MESSAGE);
        System.out.println(PRINT_CORRECT_THREE + result.get(5) + "개");
        System.out.println(PRINT_CORRECT_FOUR + result.get(4) + "개");
        System.out.println(PRINT_CORRECT_FIVE + result.get(3) + "개");
        System.out.println(PRINT_CORRECT_FIVE_BONUS + result.get(2) + "개");
        System.out.println(PRINT_CORRECT_SIX + result.get(1) + "개");
        System.out.println(PRINT_EARNING_RATE_MESSAGE_FRONT + String.format("%.1f", earningRate)
            + PRINT_EARNING_RATE_MESSAGE_BACK);
    }
}
