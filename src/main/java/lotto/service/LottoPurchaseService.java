package lotto.service;

import static lotto.constant.ApplicationConstants.LOTTO_NUMBER_COUNT;
import static lotto.constant.ApplicationConstants.LOTTO_RANGE_MAX;
import static lotto.constant.ApplicationConstants.LOTTO_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.enums.ErrorMessage;

public class LottoPurchaseService {

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX,
                        LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public List<Lotto> purchaseLottos(int lottoAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
        return purchasedLottos;
    }

    public List<Integer> splitLottoNumber(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

}
