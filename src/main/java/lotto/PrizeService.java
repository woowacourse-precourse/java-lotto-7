package lotto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeService {

    public Map<LottoRate, Integer> servicePrize(List<Lotto> lottos, List<Integer> lottoNumbers, int bonusNumber) {
        Map<LottoRate, Integer> prize = new HashMap<>();

        calculatePrize(lottos, lottoNumbers, bonusNumber, prize);

        return prize;
    }

    private static void calculatePrize(List<Lotto> lottos, List<Integer> lottoNumbers, int bonusNumber, Map<LottoRate, Integer> prize) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(lottoNumbers::contains)
                    .count();

            boolean bonusMatched = lotto.getNumbers().contains(bonusNumber);

            LottoRate rate = LottoRate.match(matchCount, bonusMatched);

            prize.put(rate, prize.getOrDefault(rate, 0) + 1);
        }
    }

    public double calculateReturnValue(Map<LottoRate, Integer> prize, int lottoMoney){
        double returnValue = prize.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize()*entry.getValue())
                .sum();

        return (returnValue / lottoMoney) * 100;
    }


}
