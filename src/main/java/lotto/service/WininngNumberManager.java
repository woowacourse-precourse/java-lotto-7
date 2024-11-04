package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.reposi.LottoRepository;
import lotto.valuate.WinnerNumberValidate;

public class WininngNumberManager {

    public void createWinningNumber(String[] inputWinningNumber, LottoRepository lottoRepository) {
        List<Integer> WinningNumber = parsingWinningInput(inputWinningNumber);
        lottoRepository.saveWinningNumbers(new Lotto(WinningNumber));
    }

    private List<Integer> parsingWinningInput(String[] inputWinningNumbers) {
        List<Integer> list_num = Arrays.asList(inputWinningNumbers).stream()
                .map(String::trim)
                .map(this::evaluateWinningNumber)
                .collect(Collectors.toList());
        return list_num;
    }

    private int evaluateWinningNumber(String inputWinningNumber) {
        WinnerNumberValidate.isValidNumber(inputWinningNumber);
        return Integer.parseInt(inputWinningNumber);
    }

    public void createBonusNumber(int bonusNumber, LottoRepository lottoRepository) {
        Bonus bonus = new Bonus(bonusNumber, lottoRepository.getWinningNumbers());
        lottoRepository.saveBonusNumbers(bonus);
    }

}
