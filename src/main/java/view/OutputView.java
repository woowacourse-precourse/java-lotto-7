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
    private static final String PRINT_CORRECT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String PRINT_CORRECT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PRINT_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
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
        Map<Prize, Integer> result = resultFactory.getResult();
        float earningRate = resultFactory.getEarningRate(amount);

        System.out.println();
        System.out.println(PRINT_RESULT_MESSAGE);
        for(Map.Entry<Prize,Integer> prizeEntry : result.entrySet()){
            System.out.println(getPrintResultMessage(prizeEntry));
        }
        System.out.println(String.format(PRINT_EARNING_RATE_MESSAGE,earningRate));
    }

    private String getPrintResultMessage(Map.Entry<Prize,Integer> prizeEntry){
        Prize prize = prizeEntry.getKey();
        int winCount = prizeEntry.getValue();
        String result="";
        if(prize == Prize.SECOND){
            return String.format(PRINT_CORRECT_BONUS_MESSAGE
                ,prize.getMatchCount()
                ,String.format("%,d",prize.getMoney())
                ,winCount);
        }
        if(prize != Prize.ZERO) {
            return String.format(PRINT_CORRECT_MESSAGE
                , prize.getMatchCount()
                , String.format("%,d", prize.getMoney())
                , winCount);
        }
        return result;
    }
}
