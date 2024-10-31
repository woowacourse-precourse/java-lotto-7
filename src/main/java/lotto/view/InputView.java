package lotto.view;

import static lotto.constant.LottoConstant.LOTTO_NUM_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.validator.LottoValidator;

public class InputView {

    LottoValidator validator = new LottoValidator();

    public String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] winningNumberInput = Console.readLine().split(LOTTO_NUM_DELIMITER);
        List<Integer> winningLotto = convertArrayToList(winningNumberInput);

        Lotto winningLottoTicket = new Lotto(winningLotto);
        validator.duplicateNumValidator(winningLottoTicket);

        return winningLottoTicket;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> convertArrayToList(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String number: array) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
