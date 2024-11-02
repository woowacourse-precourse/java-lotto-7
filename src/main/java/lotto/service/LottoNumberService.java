package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.InputDTO;
import lotto.dto.Lotto;
import lotto.dto.WinningResultDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoNumberService {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(int money) {
        int lottoCount = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(drawWinningNumbers()));
        }

        return lottos;
    }

    public List<Integer> drawWinningNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int compareWithAllNumbers(InputDTO inputDTO, Lotto lottoDTO) {
        List<Integer> allNumbers = inputDTO.getAllNumbers();
        List<Integer> lottoNumbers = lottoDTO.getLottoNumbers();
        int count = 0;

        for (Integer number : allNumbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
