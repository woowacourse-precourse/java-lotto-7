package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.common.Constants;
import lotto.common.Prompts;
import lotto.dto.LottoPurchaseDTO;
import lotto.model.Lotto;
import lotto.util.Validator;
import lotto.view.InputView;

public class InputParser {
    private final InputView inputView;
    private final Validator validator;

    public InputParser (InputView inputView, Validator validator) {
        this.inputView = inputView;
        this.validator = validator;
    }

    public int parsePrice() {
        String rawPrice = inputView.requirePrice();
        validator.isInputPriceValid(rawPrice);
        return Integer.parseInt(rawPrice);
    }

    public int calculateLottoCount(int price) {
        return price / Constants.LOTTO_PRICE;
    }

    public List<Integer> parseLottoNumbers() {
        String rawLottoNumbers = inputView.requireLottoNumbers();
        List<String> lottoNumbers = List.of(rawLottoNumbers.split(Prompts.INPUT_DELIMITER));
        List<Integer> convertedLottoNumbers = new ArrayList<>();

        for (String lottoNumber : lottoNumbers) {
            validator.isLottoNumberValid(lottoNumber);
            convertedLottoNumbers.add(Integer.parseInt(lottoNumber));
        }

        validator.isLottoNumberDuplicated(convertedLottoNumbers);
        return convertedLottoNumbers;
    }

    public int parseBonusNumber() {
        String rawBonusNumber = inputView.requireBonusNumber();
        validator.isBonusNumberValid(rawBonusNumber);
        validator.isBonusNumberDuplicated(rawBonusNumber, parseLottoNumbers());
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        return bonusNumber;
    }

    public LottoPurchaseDTO lottoPurchaseDTO() {
        int parsedPrice = parsePrice();
        int lottoCount = calculateLottoCount(parsedPrice);
        List<Integer> parsedLottoNumbers = parseLottoNumbers();
        int parsedBonusNumber = parseBonusNumber();

        return new LottoPurchaseDTO(parsedPrice, lottoCount, parsedLottoNumbers, parsedBonusNumber);
    }
}
