package lotto;

import InputOutput.InputView;

import java.util.*;

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

    public static List<List<Integer>> createLottoTickets(int ticket) {
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticket; i++) {
            List<Integer> randomNumbers = InputView.random();
            Collections.sort(randomNumbers);
            lottoTickets.add(randomNumbers);
        }
        return lottoTickets;
    }
}