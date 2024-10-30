package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        boolean allInRange = numbers.stream()
                .allMatch(n -> n >= LottoConstant.LOTTO_NUMBER_MIN && n <= LottoConstant.LOTTO_NUMBER_MAX);
        if (!allInRange){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
        HashSet<Integer> checkNumbersCount = new HashSet<>(numbers);
        if (checkNumbersCount.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복값 입력은 불가능합니다.");
        }
    }

    public void lottoNumbersPrint(){
        String result = "[" +
                this.numbers.stream().
                        map(String::valueOf).
                        collect(Collectors.joining(", "))
                + "]";
        System.out.println(result);
    }
}
