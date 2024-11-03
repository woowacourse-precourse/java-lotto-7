package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.StringToLongConverter;
import lotto.converter.LottoConverter;
import lotto.exception.Validator;

public class InputView {
    private static InputView inputView;
    private LottoConverter lottoConverter;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public long enterPaymentForLottery() {
        System.out.println(SystemMessage.ENTER_PAYMENT_FOR_LOTTERY);
        return Validator.inputValid(Console.readLine());
    }

    public List<Integer> enterWinningLottery() {
        System.out.println(SystemMessage.ENTER_WINNING_LOTTERY);
        try {
            StringToLongConverter stringToLongConverter = new StringToLongConverter(Console.readLine());
            lottoConverter = new LottoConverter(stringToLongConverter.getResult());
            return lottoConverter.getLottoNumbers();
        } catch (IllegalArgumentException e) {
            return enterWinningLottery();
        }
    }

    public int enterBonusLottery() {
        System.out.println(SystemMessage.ENTER_BONUS_LOTTERY);
        try {
            lottoConverter = new LottoConverter(Console.readLine());
            return lottoConverter.getBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            return enterBonusLottery();
        }
    }

    public void close() {
        Console.close();
    }
}
