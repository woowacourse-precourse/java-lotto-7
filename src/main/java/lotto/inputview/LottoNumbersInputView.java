package lotto.inputview;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.parser.LottoNumbersParser;
import lotto.validator.LottoNumbersValidator;

import java.util.List;

public class LottoNumbersInputView {
    public static Lotto inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            List<Integer> numbers = LottoNumbersParser.parseLottoNumbers(input);
            LottoNumbersValidator.validate(numbers);
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            return inputLottoNumbers();
        } catch (IllegalArgumentException e ){
            System.out.println(e.getMessage());
            return inputLottoNumbers();
        }
    }
}
