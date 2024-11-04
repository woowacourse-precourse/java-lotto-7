package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.PurchaseAmount;

public class Lottos {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBERS = 45;
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";

    private final List<Lotto> lottos;

    public Lottos(PurchaseAmount purchaseAmount) {
        this.lottos = new ArrayList<>();
        generateRandomLottoNumbers(purchaseAmount.getPurchaseAmount());
    }

    public void generateRandomLottoNumbers(final int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER,
                    MAX_LOTTO_NUMBERS,
                    LOTTO_NUMBER_LENGTH
            );
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public String displayLottos() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(displayLottoNumbers(lotto));
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    private String displayLottoNumbers(final Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(PREFIX);
        stringBuilder.append(
                lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(DELIMITER))
        );
        stringBuilder.append(SUFFIX);

        return stringBuilder.toString();
    }
}
