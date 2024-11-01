package lotto.view;

import lotto.model.Lotto;
import lotto.model.User;

import java.util.List;

import static lotto.Constants.NEW_LINE;
import static lotto.utils.Utils.*;
import static lotto.message.OutputMessage.*;
public class OutputView {

    public static void printBuyLottos(User user){
        print(NEW_LINE);
        print(OUTPUT_BUY_LOTTOS.getFormatMessage(user.getBuyLottoCount()));
        for(Lotto lotto : user.getLottos()){
            print(lotto.getNumbers().toString());
        }
    }
}
