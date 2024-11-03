package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toLottoNumberList(numbers);
    }

    public String represent() {
        return numbers.stream()
            .map(LottoNumber::toString)
            .collect(Collectors.joining(", ", "[", "]"));
    }

    private static List<LottoNumber> toLottoNumberList(List<Integer> numbers) {
        return numbers.stream()
            .sorted()
            .map(LottoNumber::valueOf).toList();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers.stream().map(LottoNumber::toInteger).toList());
    }

    // TODO: 에러 메시지가 6개 이상일 때 enum 으로 관리!
    // TODO: 추후 메서드 분리
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
