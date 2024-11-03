package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto() {
        this.numbers =new ArrayList<>(generateLottoNumbers());
        validate(numbers);
    }

    public Lotto(List<Integer> integers) {
        this.numbers = integers;
        validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    private Set<Integer> generateLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        Random rand = new Random();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(rand.nextInt(45)+1);
        }
        return lottoNumbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number-> number<1 || numbers.size()>45)){
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 1과 45사이여야 합니다."));
        }
        if (numbers.stream().distinct().count()!=numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
