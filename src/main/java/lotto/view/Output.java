package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printPurchasedLottoNumbers(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto: lottos){
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static Map<WinningRank, Integer> initializeEnumList(){
        Map<WinningRank, Integer> resultOfLottoAsEnum = new HashMap<>();
        for(WinningRank result: WinningRank.values()){
            resultOfLottoAsEnum.put(result, 0);
        }
        return resultOfLottoAsEnum;
    }

    public static Map<WinningRank, Integer> collectResult(List<WinningRank> resultList){
        Map<WinningRank, Integer> resultOfLottoAsEnum = initializeEnumList();

        for(WinningRank result: resultList){
            resultOfLottoAsEnum.put(result, resultOfLottoAsEnum.get(result) + 1);
        }
        return resultOfLottoAsEnum;
    }

    public static int calculateEarningRate(Map<WinningRank, Integer> result, int purchaseAmount){
        int totalPrizeMoney = 0;
        for (Map.Entry<WinningRank, Integer> entry : result.entrySet()) {
            totalPrizeMoney += entry.getValue() * entry.getKey().getPrizeMoneyAmount();
        }
        return totalPrizeMoney;
    }

    public static void printResult(Map<WinningRank, Integer> result, int purchaseAmount){
        int totalPrizeMoney = calculateEarningRate(result, purchaseAmount);

        double earningRate = totalPrizeMoney/purchaseAmount;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(WinningRank.FIFTHPLACE.getnumberOfCorrectNumber() + "개 일치 (" + WinningRank.FIFTHPLACE.getPrizeMoneyAmount() +") - "+result.get(WinningRank.FIFTHPLACE)+"개 일치");
        System.out.println(WinningRank.FOURTHPLACE.getnumberOfCorrectNumber() + "개 일치 (" + WinningRank.FOURTHPLACE.getPrizeMoneyAmount() +") - "+result.get(WinningRank.FOURTHPLACE)+"개 일치");
        System.out.println(WinningRank.THIRDPLACE.getnumberOfCorrectNumber() + "개 일치 (" + WinningRank.THIRDPLACE.getPrizeMoneyAmount() +") - "+result.get(WinningRank.THIRDPLACE)+"개 일치");
        System.out.println(WinningRank.SECONDPLACE.getnumberOfCorrectNumber() + "개 일치 (" + WinningRank.SECONDPLACE.getPrizeMoneyAmount() +") - "+result.get(WinningRank.SECONDPLACE)+"개 일치");
        System.out.println(WinningRank.FIRSTPLACE.getnumberOfCorrectNumber() + "개 일치 (" + WinningRank.FIRSTPLACE.getPrizeMoneyAmount() +") - "+result.get(WinningRank.FIRSTPLACE)+"개 일치");
        System.out.println("총 수익률은" + earningRate + "% 입니다.");
    }
}
