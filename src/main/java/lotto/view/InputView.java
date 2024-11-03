package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.StringToLongConverter;
import lotto.converter.LottoConverter;
import lotto.exception.Validator;

public class InputView {
    private static InputView inputView;

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

    public List<Long> enterWinningLottery() {
        System.out.println(SystemMessage.ENTER_WINNING_LOTTERY);
        try {
            StringToLongConverter stringToLongConverter = new StringToLongConverter(Console.readLine());
            LottoConverter lottoConverter = new LottoConverter(stringToLongConverter.getResult());
            return lottoConverter.getLottoNumbers();
        } catch (IllegalArgumentException e) {
            return enterWinningLottery();
        }
    }

    public int enterBonusLottery() {
        return 0;
    }

    public void close() {
        Console.close();
    }
}
