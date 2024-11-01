package lotto.domain.lottomachine;

import lotto.exception.ExceptionMessage;

import java.util.List;

public class ManualLottoGenerator implements NumberGenerator {

    private final List<List<Integer>> lottos;
    private int currentIndex = 0;


    public ManualLottoGenerator(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    @Override
    public List<Integer> generateNumbers() {
        if (currentIndex >= lottos.size()) {
            throw new IllegalStateException(ExceptionMessage.NO_MORE_LOTTO.getMessage());
        }
        return lottos.get(currentIndex++);
    }
}
