package lotto.view.converter;

import java.util.ArrayList;
import java.util.List;
import lotto.view.converter.validator.LottoInputValidator;

public class LottoInputConverter {

    private final LottoInputValidator lottoInputValidator;

    public LottoInputConverter() {
        this.lottoInputValidator = new LottoInputValidator();
    }

    public int convertMoney(String input) {
        lottoInputValidator.validateMoney(input);
        return Integer.parseInt(input);
    }

    public List<Integer> convertNumbers(String input) {
        String[] split = input.split(",");

        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            lottoInputValidator.validateNumberFromString(s);
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public int convertBonusNumber(String input) {
        lottoInputValidator.validateNumberFromString(input);
        return Integer.parseInt(input);
    }


}
