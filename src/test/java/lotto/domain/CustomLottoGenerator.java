package lotto.domain;

import java.util.List;

public class CustomLottoGenerator implements LottoGenerator{

    private final List<List<Integer>> customNumbers;

    public CustomLottoGenerator(List<List<Integer>> customNumbers){
        this.customNumbers = customNumbers;
    }
    @Override
    public List<Lotto> generateLottos(int count) {
        return customNumbers.stream()
                .map(Lotto::new)
                .toList();
    }
}
