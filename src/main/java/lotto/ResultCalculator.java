package lotto;

import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    List<StringBuilder> output;
    List<Integer> matchCountOutput;
    List<Integer> moneyOutput;
    List<Integer> rankCounter;

    ResultCalculator() {
        output = new ArrayList<>();
        matchCountOutput = new ArrayList<>();
        rankCounter = new ArrayList<>();
        moneyOutput = new ArrayList<>();
    }
    private void generatorMatchCountBase() {
        matchCountOutput.add(3);
        matchCountOutput.add(4);
        matchCountOutput.add(5);
        matchCountOutput.add(5);
        matchCountOutput.add(6);
    }

    private void generatorMoneyBase() {
        moneyOutput.add(5000);
        moneyOutput.add(50000);
        moneyOutput.add(1500000);
        moneyOutput.add(30000000);
        moneyOutput.add(2000000000);
    }
    private void generatorRankBase() {
        rankCounter.add(0);
        rankCounter.add(0);
        rankCounter.add(0);
        rankCounter.add(0);
        rankCounter.add(0);
    }

    private void generateBaseOutput() {
        for(int loop = 0; loop < matchCountOutput.size(); ++loop) {
            StringBuilder stringBuilder = new StringBuilder(matchCountOutput.get(loop).toString());
            if(loop == 3) {
                stringBuilder.append("개 일치, 보너스 볼 일치 (");
                stringBuilder.append(String.format("%,d", moneyOutput.get(loop)));
                output.add(stringBuilder);
                continue;
            }
            stringBuilder.append("개 일치 (");
            stringBuilder.append(String.format("%,d", moneyOutput.get(loop)));
            output.add(stringBuilder);
        }
    }



    private void calculateRank(List<Lotto> lottoNumbers, List<Integer> winNumber, int bonusNumber) {
        for (Lotto lottoNumber : lottoNumbers) {
            int matchCount = lottoNumber.calculateMatchCount(winNumber);
            if(matchCount < 3) continue;
            if (matchCount == 6 || (matchCount == 5 && lottoNumber.findMatchBonusNumber(bonusNumber))) {
                rankCounter.set(matchCount - 2, rankCounter.get(matchCount - 2) + 1);
                continue;
            }
            rankCounter.set(matchCount - 3, rankCounter.get(matchCount - 3) + 1);
        }
    }

    private void printRank() {
        System.out.println("\n당첨 통계\n" + "---");
        for(int loop = 0; loop < 5; ++loop) {
            System.out.print(output.get(loop) + "원) - ");
            System.out.println(rankCounter.get(loop).toString() + "개");
        }
    }

    private void printStatistic(int count) {
        long totalMoney = 0;
        for(int loop = 0; loop < 5; ++loop) {
            totalMoney += (Long.valueOf(moneyOutput.get(loop)) * rankCounter.get(loop));
        }
        String result = String.format("%.1f", ((double) totalMoney / (count * 1000)) * 100);
        System.out.println("총 수익률은 "+ result +"%입니다.");
    }

    public void calculateResult(List<Lotto> lottoNumbers, List<Integer> winNumber, int bonusNumber) {
        generatorMoneyBase();
        generatorMatchCountBase();
        generatorRankBase();
        generateBaseOutput();

        calculateRank(lottoNumbers, winNumber, bonusNumber);
        printRank();
        printStatistic(lottoNumbers.size());
    }
}
