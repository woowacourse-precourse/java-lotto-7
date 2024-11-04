package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.common.Constants;
import lotto.common.Prompts;
import lotto.view.InputView;

public class InputParser {

    private final InputView inputView;

    public InputParser (InputView inputView) {
        this.inputView = inputView;
    }

    public int parsePrice() {
        String rawPrice = inputView.requirePrice();
        return Integer.parseInt(rawPrice);
    }

    public List<Integer> parseLottoNumbers() {
        String rawLottoNumbers = inputView.requireLottoNumbers();
        List<String> lottoNumbers = List.of(rawLottoNumbers.split(Prompts.INPUT_DELIMITER));
        List<Integer> convertedLottoNumbers = new ArrayList<>();

        for (String lottoNumber : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(lottoNumber));
        }

        return convertedLottoNumbers;
    }

    public int parseBonusNumber() {
        String rawBonusNumber = inputView.requireBonusNumber();
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        return bonusNumber;
    }
}
