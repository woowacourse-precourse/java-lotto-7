package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoResult;

public class OutputView {
    private final String PURCHASE_LOTTO_MESSGAE = "%d개를 구매했습니다.";
    private final String LOTTO_RESULT_STATISTICS_MESSAGE = "당첨 통계 \n---";
    private final String MATCH_LOTTO_MESSAGE = "%s개 일치 (%s원) - %d개";
    private final String MATCH_BONUS_MESSAGE = "%s개 일치, 보너스 볼 일치 (%s원) - %d개";
    private final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";
    private final String LOTTO_NUMBER_START = "[";
    private final String LOTTO_NUMBER_END = "]";
    private final String COMMA_STRING = ", ";


    public void printPurchaseLottoMessage(Integer count){
        String purchaseMessage = String.format(PURCHASE_LOTTO_MESSGAE, count);
        System.out.println(purchaseMessage);
    }

    public void printLottoNumber(List<Integer> numbers){
        String numbersInFormat = String.join(COMMA_STRING, numbers.stream()
                .map(String::valueOf)
                .toList());

        String lottoNumber = LOTTO_NUMBER_START + numbersInFormat + LOTTO_NUMBER_END;
        System.out.println(lottoNumber);
    }

    public void printLottoResults(List<LottoResult> results){
        System.out.println(LOTTO_RESULT_STATISTICS_MESSAGE);
        List<LottoResult> resultValues = Arrays.stream(LottoResult.values())
                .filter(result -> !result.equals(LottoResult.NO_MATCH))
                .collect(Collectors.toList())
                .reversed();

        for(LottoResult result : resultValues){
            Integer count = Math.toIntExact(results.stream()
                    .filter(number -> number == result)
                    .count());

            printLottoResult(result, count);
        }
    }

    private void printLottoResult(LottoResult result,Integer count){
        Integer matchCount = result.getMatchCount();
        String priceText = result.getPriceText();

        if(result == LottoResult.FIVE_MATCH_BONUS){
            printMatchBonusResult(matchCount,priceText,count);
            return;
        }

        printMatchLottoResult(matchCount, priceText,count);
    }

    private void printMatchLottoResult(Integer count, String amount, Integer quantity){
        String result = String.format(MATCH_LOTTO_MESSAGE, count, amount, quantity);
        System.out.println(result);
    }

    private void printMatchBonusResult(Integer count, String amount, Integer quantity){
        String result = String.format(MATCH_BONUS_MESSAGE, count, amount, quantity);
        System.out.println(result);
    }

    public void printRateOfReturn(String returns){
        String rateOfReturn = String.format(RATE_OF_RETURN_MESSAGE, returns);
        System.out.println(rateOfReturn);
    }

}
