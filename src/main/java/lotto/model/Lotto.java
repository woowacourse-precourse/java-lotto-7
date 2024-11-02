package lotto.model;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(){
        numbers = new ArrayList<>();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void printLottoNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder("[");
        for(int i  =0; i < numbers.size(); i++){
            sb.append(numbers.get(i));
            if(i != numbers.size() - 1){
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
        int correct = 0;
        for (Integer number : numbers) {
            if (winningNumber.contains(number)) {
                correct++;
            }
        }
        return correct;
    }

    public double calculateEarningRate(int purchaseAmount, int countFirst, int countSecond, int countThird, int countFourth, int countFifth){
        return (double) (LottoPrizeMoney.FIRST.getPrizeMoney()*countFirst
                + LottoPrizeMoney.SECOND.getPrizeMoney()*countSecond
                + LottoPrizeMoney.THIRD.getPrizeMoney()*countThird
                + LottoPrizeMoney.FOURTH.getPrizeMoney()*countFourth
                + LottoPrizeMoney.FIRST.getPrizeMoney()*countFifth)
                / (purchaseAmount*10);
    }


}
