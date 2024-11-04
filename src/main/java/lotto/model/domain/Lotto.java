package lotto.model.domain;

import static lotto.config.LottoConfig.LOTTO_SIZE;

import java.util.List;
import lotto.config.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    // Lotto의 규격에 맞는지 검증하는 메소드
    //사용자가 입력한 당첨 번호와 참가자가 입력한 당첨 번호가 형식에 맞는지 확인 하는 메소드
    //들어온 숫자가 1~45인지 확인, 숫자가 6개 들어왔는지 확인, 중복된 수가 있는지 확인
    public static void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if(numbers.stream().anyMatch(number -> number <1 || number > 45)){
            //stream.anyMatch()를 활용하여 1~45인지 확인
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            // distinct()를 활용해 중복 요소를 제거한 갯수가 다르면 에러 발생
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public int getMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}