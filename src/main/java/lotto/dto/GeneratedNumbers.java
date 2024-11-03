package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class GeneratedNumbers {
    private final List<Lotto> generatedNumbers;

    public GeneratedNumbers(List<Lotto> LottoTicket) {
        generatedNumbers = new ArrayList<>(LottoTicket);
    }

    public List<Lotto> getGeneratedNumbers() {
        return generatedNumbers;
    }
}
