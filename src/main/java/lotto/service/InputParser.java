package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.common.Constants;
import lotto.common.Prompts;
import lotto.dto.LottoPurchaseDTO;
import lotto.model.Lotto;
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

    public int calculateLottoCount(int price) {
        return price / Constants.LOTTO_PRICE;
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

    public LottoPurchaseDTO lottoPurchaseDTO() {
        int parsedPrice = parsePrice();
        int lottoCount = calculateLottoCount(parsedPrice);
        List<Integer> parsedLottoNumbers = parseLottoNumbers();
        int parsedBonusNumber = parseBonusNumber();

        return new LottoPurchaseDTO(parsedPrice, lottoCount, parsedLottoNumbers, parsedBonusNumber);
    }
}
