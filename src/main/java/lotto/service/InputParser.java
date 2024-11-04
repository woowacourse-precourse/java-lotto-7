package lotto.service;

import java.util.List;
import lotto.common.Prompts;
import lotto.view.InputView;

public class InputParser {
    String rawPrice = InputView.requirePrice();
    String rawLottoNumbers = InputView.requireLottoNumbers();
    String rawBonusNumber = InputView.requireBonusNumber();

    public int parsePrice() {
        int price = Integer.parseInt(rawPrice);
        return price;
    }

    public List<Integer> parseLottoNumbers() {
        List<String> lottoNumbers = List.of(rawLottoNumbers.split(Prompts.INPUT_DELIMITER));
        List<Integer> convertedLottoNumbers = List.of();

        for (String lottoNumber : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(lottoNumber));
        }

        return convertedLottoNumbers;
    }

    public int parseBonusNumber() {
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        return bonusNumber;
    }
}
