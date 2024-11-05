package WinningCaculator;

import java.util.ArrayList;
import java.util.List;

public class Caculator {
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    Winnig winnig = new Winnig();
    RateOnReturn rateOnReturn = new RateOnReturn();
    int five = 0;
    int four = 0;
    int third = 0;
    int second = 0;
    int first = 0;

    public void LottoGenerateNumber(List<Integer> userNumber, List<List<Integer>> randomLottoNumbers, int bonus, int buyLottoAmount) {
        for (List<Integer> randomLottoNumber : randomLottoNumbers) {
            //저장된 로또 번호를 순회하며 당첨 결과 비교
            List<Integer> matchedNumbers = new ArrayList<>(userNumber);
            matchedNumbers.retainAll(randomLottoNumber);
            //보너스 번호와 로또번호 비교
            boolean bonusMatch = randomLottoNumber.contains(bonus);

            int matchCount = matchedNumbers.size();

            //전역 변수에 결과 저장
            if (matchCount == THREE_MATCH) {
                five++;
            } else if (matchCount == FOUR_MATCH) {
                four++;
            } else if (matchCount == FIVE_MATCH) {
                third++;
                if (bonusMatch) {
                    second++;
                }
            } else if (matchCount == SIX_MATCH) {
                first++;
            }
        }
        //당첨 결과 출력
        winnig.LottoWinning(five, four, third, second, first);
        //수익률 출력
        rateOnReturn.RateOnReturnCalculation(five, four, third, second, first, buyLottoAmount);
    }
}
