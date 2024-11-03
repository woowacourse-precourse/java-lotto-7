package lotto.view;

import lotto.Lotto;
import lotto.prize.Prize;
import java.util.List;
import java.util.Map;
import lotto.model.CalculatePrize;

public class OutputView{
    public static void buyMessage(int quantity){
        System.out.println(String.format("%d개를 구매했습니다.", quantity));
    }
    public static void printLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
    }
    public static void output(List<Lotto> lottoList, Lotto prizeNum, int bonusNum, int inputAmount){
        System.out.println("당첨 통계\n---");
        CalculatePrize calculatePrize = new CalculatePrize(prizeNum, bonusNum);
        Map<Prize, Integer> prizeCount = calculatePrize.countAllMatches(lottoList);
        for (Prize prize : Prize.values()){
            int count = prizeCount.getOrDefault(prize, 0);
            if (prize != Prize.NONE){
                System.out.println(String.format(prize.getMessage(), count));
            }
        }
        int total = prizeCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();
        System.out.printf("총 수익률은 %.1f%%입니다.", ((double) total / inputAmount) * 100) ;
    }
}