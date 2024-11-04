package lotto.model;

import static lotto.utils.Constants.SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import lotto.utils.ErrorMessage;

public class LottoManager {
    private final List<Lotto> lottos;

    public LottoManager() {
        lottos = new ArrayList<>();
    }

    public List<Integer> addLotto() {
        List<Integer> drawNumbers = drawLottoNumbers();
        lottos.add(new Lotto(drawNumbers));
        return new ArrayList<>(drawNumbers);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int size() {
        return lottos.size();
    }

    private List<Integer> drawLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto generateCustomLotto(String number) {
        List<Integer> numbers = splitNumber(number);
        return new Lotto(numbers);
    }

    private List<Integer> splitNumber(String number) {
        return Arrays.stream(number.split(SEPARATOR))
                .map(Integer::parseInt)
                .peek(num -> validateNumberInRange(num))
                .collect(Collectors.toList());
    }

    public void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
