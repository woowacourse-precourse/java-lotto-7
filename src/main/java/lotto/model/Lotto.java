package lotto.model;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final String NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 번호가 있습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(){
        numbers = new ArrayList<>();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
        if(hasDuplicate(numbers)){
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    public void printLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sortedNumbers.size(); i++) {
            sb.append(sortedNumbers.get(i));
            if (i != sortedNumbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public LottoPrizeMoney judgeWinning(List<Integer> numbers, List<Integer> winningNumber, int luckyNumber) {
        int correct = countCorrect(numbers, winningNumber);
        if (correct == 6) {
            return LottoPrizeMoney.FIRST;
        } else if (correct == 5) {
            return numbers.contains(luckyNumber) ? LottoPrizeMoney.SECOND: LottoPrizeMoney.THIRD;
        } else if (correct == 4) {
            return LottoPrizeMoney.FOURTH;
        } else if (correct == 3) {
            return LottoPrizeMoney.FIFTH;
        }
        return LottoPrizeMoney.MISS;
    }

    private int countCorrect(List<Integer> numbers, List<Integer> winningNumber) {
        List<Integer> tmpNumbers = new ArrayList<>(numbers);
        tmpNumbers.retainAll(winningNumber);
        return tmpNumbers.size();
    }

    public float calculateEarningRate(int purchaseAmount, int countFirst, int countSecond, int countThird, int countFourth, int countFifth) {
        int totalPrize = LottoPrizeMoney.FIRST.getPrizeMoney() * countFirst
                + LottoPrizeMoney.SECOND.getPrizeMoney() * countSecond
                + LottoPrizeMoney.THIRD.getPrizeMoney() * countThird
                + LottoPrizeMoney.FOURTH.getPrizeMoney() * countFourth
                + LottoPrizeMoney.FIFTH.getPrizeMoney() * countFifth;
        return (float) totalPrize / (purchaseAmount * 1000) * 100;
    }


    private boolean hasDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() != list.size();
    }
}
