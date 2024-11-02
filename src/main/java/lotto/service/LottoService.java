package lotto.service;

import lotto.model.Lotto;
import lotto.dto.LottoRequestDto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static Lotto createLotto(LottoRequestDto lottoRequestDto) {
        String[] numbers = lottoRequestDto.getLottoNumbers().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            lottoNumbers.add(num);
        }
        return new Lotto(lottoNumbers);
    }
}
