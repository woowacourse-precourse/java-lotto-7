package lotto.dto;

import java.util.List;
import lotto.Lotto;

public class LottoResponseDTO {
    private final List<Integer> number;

    public LottoResponseDTO(Lotto lotto) {
        this.number = lotto.getNumbers();
    }

    public List<Integer> getNumber() {
        return number;
    }

    @Override
    public String toString() {
        String output = number.stream()
                .map(Object::toString)
                .reduce((n1, n2) -> String.join(", ", n1, n2))
                .orElseThrow(() -> new RuntimeException("구매된 로또가 없습니다."));
        return "[" + output + "]";
    }
}
