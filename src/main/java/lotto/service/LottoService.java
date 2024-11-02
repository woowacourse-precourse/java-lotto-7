package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.dto.LottoRequestDto;
import lotto.model.LottoInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public static LottoInfo createLottoInfo(LottoRequestDto lottoRequestDto) {
        List<Integer> lottoNumbers = parseLottoNumbers(lottoRequestDto.getLottoNumbers());
        int bonusNumber = Integer.parseInt(lottoRequestDto.getBonusNumber());
        int amounts = parsePurchaseAmount(lottoRequestDto.getPurchaseAmount());

        return new LottoInfo(lottoNumbers, bonusNumber, amounts);
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

    private static int parsePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }
}
