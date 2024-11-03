package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final Number bonusNumber;

    public WinningNumbers(Lotto winningLotto,Number bonus){
        this.winningLotto = winningLotto;
        this.bonusNumber = bonus;
    }

    public Reward getReward(List<Number> numbers){
        boolean bonus = numbers.contains(this.bonusNumber);
        int count = (int) winningLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();

        return Reward.getRank(count,bonus);
    }

    private static List<Integer> lineToNumbers(String line) {
        String[] splitLine = line.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : splitLine) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

}
