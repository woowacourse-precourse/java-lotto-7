package lotto.service;

import java.util.List;
import lotto.common.Prompts;
import lotto.view.InputView;

public class InputParser {
    public static int parsePrice() {
        String rawPrice = InputView.requirePrice();
        int price = Integer.parseInt(rawPrice);
        return price;
    }

    public static List<Integer> parseLottoNumbers() {
        String rawLottoNumbers = InputView.requireLottoNumbers();
        List<String> lottoNumbers = List.of(rawLottoNumbers.split(Prompts.INPUT_DELIMITER));
        List<Integer> convertedLottoNumbers = List.of();

        for (String lottoNumber : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(lottoNumber));
        }

        return convertedLottoNumbers;
    }

    public static int parseBonusNumber() {
        String rawBonusNumber = InputView.requireBonusNumber();
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        return bonusNumber;
    }
}
