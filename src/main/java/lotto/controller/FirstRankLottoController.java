package lotto.controller;

import java.util.List;
import lotto.helper.ParseHelper;
import lotto.model.FirstRankLotto;
import lotto.service.FirstRankLottoService;
import lotto.view.ErrorView;
import lotto.view.LottoView;

public class FirstRankLottoController {

    private final FirstRankLottoService firstRankLottoService;
    private final ParseHelper parseHelper;

    public FirstRankLottoController() {
        this.firstRankLottoService = new FirstRankLottoService();
        this.parseHelper = new ParseHelper();
    }

    public FirstRankLotto generateFirstRankLotto() {
        List<Integer> firstRankLottoNumbers = generateFirstRankLottoNumbers();
        int bonusNumber = generateBonusNumber(firstRankLottoNumbers);

        return new FirstRankLotto(firstRankLottoNumbers, bonusNumber);
    }

    private List<Integer> generateFirstRankLottoNumbers() {
        List<Integer> firstRankLottoNumbers = null;

        while (firstRankLottoNumbers == null) {
            try {
                String input = LottoView.inputFirstRankNumbers();
                List<Integer> parsedInput = parseHelper.parseIntegerList(input, ",");
                firstRankLottoService.validateNumbers(parsedInput);
                firstRankLottoNumbers = parsedInput;
            } catch (IllegalArgumentException exception) {
                ErrorView.announceError(exception);
            }
        }

        return firstRankLottoNumbers;
    }

    private int generateBonusNumber(List<Integer> firstRankLottoNumbers) {
        Integer bonusNumber = null;

        while (bonusNumber == null) {
            try {
                String input = LottoView.inputBonusNumber();
                int parsedInput = parseHelper.parseInt(input);
                firstRankLottoService.validateBonusNumber(firstRankLottoNumbers, parsedInput);
                bonusNumber = parsedInput;
            } catch (IllegalArgumentException exception) {
                ErrorView.announceError(exception);
            }
        }

        return bonusNumber;
    }
}
