package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private int findLottoRank(long matchingCount, int bonusNumber) {
        boolean hasBonusMatch = numbers.contains(bonusNumber);

        if (matchingCount == 6) {
            return 1;
        }
        if (matchingCount == 5 && hasBonusMatch) {
            return 2;
        }
        if (matchingCount == 5) {
            return 3;
        }
        if (matchingCount == 4) {
            return 4;
        }
        if (matchingCount == 3) {
            return 5;
        }

        return 0;
    }

    public List<Integer> findMatchNumber(List<List<Integer>> lotto, int bonusNumber) {
        List<Integer> duplicateCountList = new ArrayList<>();
        Set<Integer> set = new HashSet<>(numbers);

        for (List<Integer> numbers : lotto) {
            long duplicateCount = numbers.stream()
                    .filter(set::contains)
                    .count();

            duplicateCountList.add(findLottoRank(duplicateCount, bonusNumber));
        }

        return duplicateCountList;
    }

    public List<Integer> findMatchNumberCount(List<Integer> duplicateCountList) {

        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (int number : duplicateCountList) {
            result.set(number, result.get(number) + 1);
        }

        return result;
    }

    public int totalPrizeMoney(List<Integer> matchNumberCount) {
        int totalPrize = 0;

        for (int i = 1; i < matchNumberCount.size(); i++) {
            LottoPrizeMoney prize = LottoPrizeMoney.fromRank(i);
            int count = matchNumberCount.get(i);

            if (count > 0) {
                totalPrize += count * prize.getPrizeMoney();
            }
        }

        return totalPrize;
    }

    public double earningRate(int totalPrize, int totalInvestment) {

        return ((double) totalPrize / totalInvestment) * 100;
    }

//    public static void main(String[] args) {
//        LottoPublication lottoPublication = new LottoPublication();
//
//        int PRICE = 1000;
//        int lottoPurchase = convertStringToInt(InputView.lottoPurchase());
//        int count = theNumberOfLotto(lottoPurchase, PRICE);
//        System.out.println();
//        System.out.println(count + "개를 구매했습니다.");
//        printLotto(lottoPublication.totalLotto(count));
//
//        System.out.println();
//        List<Integer> numbers = convertStringToList(InputView.lottoCastLotsLot());
//        Lotto lotto = new Lotto(numbers);
//
//        System.out.println();
//        int bonusNumber = convertStringToInt(InputView.bonusNumber());
//
//        List<Integer> findMatchNumberCount = lotto.findMatchNumberCount(
//                lotto.findMatchNumber(lottoPublication.totalLotto(count), bonusNumber));
//
//        System.out.println();
//        System.out.println("당첨 통계");
//        System.out.println("---");
//        printWinningStatistics(findMatchNumberCount);
//
//        int totalPrizeMoney = lotto.totalPrizeMoney(findMatchNumberCount);
//        double earningRate = lotto.earningRate(totalPrizeMoney, lottoPurchase);
//
//        printEarningRate(earningRate);
//    }
}
