package lotto.service;

import static lotto.constant.Message.BACK_MESSAGE;
import static lotto.constant.Message.FRONT_MESSAGE;
import static lotto.constant.Message.OUTPUT_DELIMITER;
import static lotto.domain.UserLotto.getRandomLottoNumbers;
import static lotto.utils.MakeRandomNumbers.makeRandomLottoNumbers;
import static lotto.view.OutputView.getPrintLottoCountMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.UserLotto;

public class LottoCreateService {

    public static void createUserLotto(Integer moneyCount) {
        UserLotto userLotto = new UserLotto(moneyCount);
        createLottoNumbers(moneyCount);
        printLottoNumbers(moneyCount);
        //여기서 로또 갯수 계산도 할 수 있게 하자
    }

    private static void createLottoNumbers(Integer moneyCount) {
        for (int i = 0; i < moneyCount; i++) {
            getRandomLottoNumbers().add(new Lotto(makeRandomLottoNumbers()));
        }
    }

    public static void printLottoNumbers(Integer moneyCount) {
        getPrintLottoCountMessage(moneyCount);
        for (int i = 0; i < moneyCount; i++) {
            getLottoNumbers(getRandomLottoNumbers().get(i));
        }
        System.out.println(" ");
    }

    public static void getLottoNumbers(Lotto lotto) {
        List<Integer> printLotto = lotto.getNumbers();
        String PrintLottoNumbers = FRONT_MESSAGE + printLotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(OUTPUT_DELIMITER)) + BACK_MESSAGE;

        System.out.println(PrintLottoNumbers);

    }


}
