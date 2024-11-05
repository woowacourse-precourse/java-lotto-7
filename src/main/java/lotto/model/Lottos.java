package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static Lottos instance;
    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(List<List<Integer>> numbers, int numberOfLottos) {
        saveLottos(numbers);
        validateLottoNumber(numberOfLottos);
    }

    private void saveLottos(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            lottos.add(new Lotto(number));
        }
    }

    public void validateLottoNumber(int numberOfLottos) {
        if (lottos.size() != numberOfLottos) {
            throw new IllegalArgumentException(String.format("[Error] 로또의 개수는 %d개여야 합니다.", numberOfLottos));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos getInstance(List<List<Integer>> numbers, int numberOfLottos) {
        if (instance == null) {
            instance = new Lottos(numbers, numberOfLottos);
        }
        return instance;
    }
}
