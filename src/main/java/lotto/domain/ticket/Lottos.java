package lotto.domain.ticket;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class Lottos {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR_NULL = "[ERROR] 로또 목록이 null일 수 없습니다.";

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        validateNull(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos create(int count) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            generatedLottos.add(createSingleLotto());
        }
        return new Lottos(generatedLottos);
    }

    private static Lotto createSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER,
                MAX_NUMBER,
                LOTTO_SIZE
        );
        return new Lotto(numbers);
    }

    private void validateNull(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
    }

    public void forEach(Consumer<Lotto> action) {
        lottos.forEach(action);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getCount() {
        return lottos.size();
    }
}