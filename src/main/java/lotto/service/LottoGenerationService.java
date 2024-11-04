package lotto.service;

import lotto.dto.LottoDTO;
import lotto.model.Lotto;
import lotto.constants.LottoConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerationService {

    public List<LottoDTO> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LottoConstants.LOTTO_PRICE;
        List<LottoDTO> lottoDTOs = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER,
                    LottoConstants.MAX_LOTTO_NUMBER,
                    LottoConstants.LOTTO_NUMBER_COUNT
            );
            Lotto lotto = new Lotto(numbers);
            LottoDTO lottoDTO = new LottoDTO(lotto.getNumbers());
            lottoDTOs.add(lottoDTO);
        }
        return lottoDTOs;
    }
}