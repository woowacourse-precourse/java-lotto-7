package lotto.model;

import static lotto.model.Lotto.createLottos;
import static lotto.model.Lotto.getLottoPrice;
import static lotto.model.Lotto.getLottoSize;
import static lotto.model.Lotto.getMaxNumber;
import static lotto.model.Lotto.getMinNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.ErrorMessage;
import lotto.dto.MoneyDTO;

public class LottoSeller {

    public List<Lotto> sell(final MoneyDTO moneyDTO) {
        validateUnit(moneyDTO.money());
        List<List<Integer>> rawNumbers = createRawLottoNumbers(moneyDTO);
        return createLottos(rawNumbers);
    }

    private void validateUnit(final Long money) {
        if (isMultipleOfPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_IS_MULTIPLE_1000.getMessage());
        }
    }

    private List<List<Integer>> createRawLottoNumbers(MoneyDTO moneyDTO) {
        List<List<Integer>> rawNumbers = IntStream.range(0, getQuantity(moneyDTO))
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(getMinNumber(), getMaxNumber(), getLottoSize()))
                .toList();
        return rawNumbers;
    }

    private boolean isMultipleOfPrice(Long money) {
        return money % getLottoPrice() != 0;
    }

    private int getQuantity(MoneyDTO moneyDTO) {
        return (int) (moneyDTO.money() / getLottoPrice());
    }
}
