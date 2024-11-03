package lotto.Controller;

import lotto.View.Input;
import lotto.View.Output;
import lotto.Validation.NumberValidation;
import lotto.Validation.BonusValidation;
import lotto.Model.Lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoController {
    private int bonus;

    public List<Integer> GetNumberValidation() {
        while (true) {
            try {
                String NumberInput = Input.GetNumber();
                return NumberValidation(NumberInput);
            } catch (IllegalArgumentException e) {
                Output.ErrorMessage(e);
            }
        }
    }

    public List<Integer> NumberValidation(String MoneyInput) {
        NumberValidation.NumberInputNotNull(MoneyInput);
        String[] ParsedNumberInput= MoneyInput.split(",");
        NumberValidation.NumberIsNumeric(ParsedNumberInput);

        List<Integer> numbers = ConvertList(ParsedNumberInput);
        new Lotto(numbers);
        return numbers;
    }

    private List<Integer> ConvertList(String[] ParsedNumberInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : ParsedNumberInput) {
            numbers.add(Integer.parseInt(string.trim()));
        }
        return numbers;
    }

    public int GetBonusValidation(List<Integer> Numbers) {
        while (true) {
            try {
                String InputBonus = Input.GetBonus();
                bonus = BonusValidation(Numbers, InputBonus);
                break;
            } catch (IllegalArgumentException e) {
                Output.ErrorMessage(e);
            }
        }
        return bonus;
    }

    public int BonusValidation(List<Integer> Numbers, String BonusInput) {
        BonusValidation.BonusInputNotNull(BonusInput);
        BonusValidation.BonusIsNumeric(BonusInput);

        bonus = Integer.parseInt(BonusInput.trim());
        BonusValidation.BonusRange(bonus);
        BonusValidation.BonusNotDuplicate(Numbers, bonus);

        return bonus;
    }
}
