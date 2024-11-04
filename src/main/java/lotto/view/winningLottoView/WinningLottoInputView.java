package lotto.view.winningLottoView;

import lotto.util.NumberConverter;
import lotto.util.NumberParserFactory;
import lotto.util.NumberParserWithComma;
import lotto.validator.WinningLottoNumberValidator;
import lotto.view.InputProvider;
import lotto.view.RepeatInput;

import java.util.Set;


public class WinningLottoInputView {

    private final InputProvider inputProvider;
    private final NumberConverter numberConverter;
    private final NumberParserFactory numberParserFactory = new NumberParserFactory();
    private final NumberParserWithComma numberParser = numberParserFactory.createNumberParser();

    public WinningLottoInputView(InputProvider inputProvider, NumberConverter numberConverter){
        this.inputProvider = inputProvider;
        this.numberConverter = numberConverter;
    }

    public Set<Integer> inputWinningLottoNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return RepeatInput.getValidInput(() -> {
            String input = inputProvider.getInput();
            Set<Integer> winningNumbers = numberParser.parseNumbers(input);
            new WinningLottoNumberValidator(winningNumbers).validateAll(); // 유효성 검사
            return winningNumbers;
        });
    }

    public int inputBonusNumbers(Set<Integer> winningLottoNumbers){
        System.out.println("보너스 번호를 입력해 주세요.");
        return RepeatInput.getValidInput(() -> {
            String input = inputProvider.getInput();
            int bonusNumber = numberConverter.convertNumber(input);
            WinningLottoNumberValidator validator = new WinningLottoNumberValidator(winningLottoNumbers);
            validator.validateBonusNumber(bonusNumber);
            return bonusNumber;
        });
    }


}
