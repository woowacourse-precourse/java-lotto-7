package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.dto.LottoRequestDto;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public static WinningLotto createWinningLotto(LottoRequestDto lottoRequestDto) {
        int bonusNumber = Integer.parseInt(lottoRequestDto.getBonusNumber());
        List<Integer> lottoNumbers = parseLottoNumbers(lottoRequestDto.getLottoNumbers());
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    private static List<Integer> parseLottoNumbers(String lottoNumbersInput) {
        String[] numbers = lottoNumbersInput.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }
}
