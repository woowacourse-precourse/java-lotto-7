package lotto.Model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import lotto.View.ExceptionMessage;
import lotto.View.OutputView;

public class Lotto {
    private final List<Integer> numbers;
    private static final int PERCENTAGE = 100;
    private static final int TICKET_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        validateOverlap(numbers);
        validateRange(numbers);

    }

    public List<Integer> getLottoNumbers(){ //필드의 numbers값을 사용할 수 있음.
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
          //  ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(EarningRate);
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overlapCheck.add(numbers.get(i));
        }

        if (overlapCheck.size() != 6) {
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int winningNumber = 0; winningNumber < numbers.size(); winningNumber++) {
            if (numbers.get(winningNumber) < MIN_NUMBER || numbers.get(winningNumber) > MAX_NUMBER) {
                ExceptionMessage.rangeException();
                throw new IllegalArgumentException();
            }

        }
    }
    // TODO: 추가 기능 구현
}
