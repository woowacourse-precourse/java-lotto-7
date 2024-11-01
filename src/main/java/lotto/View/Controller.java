package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Messages.ErrorMessage;
import lotto.Messages.StateMessage;
import lotto.WinningDetails;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.View.InputView.*;

public class Controller {

    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String DELIMITER = ",";
    public static final String NUM = "개";

    private Integer lottoCount;

    public Integer gainPurchaseAmount(){
        Integer purchasePrice = 0;
        try {
            OutputView.printPurchaseAmount();
            purchasePrice = InputView.readPurchaseAmount();
            OutputView.printBlank();
            this.lottoCount = this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            System.out.println(ErrorMessage.ONLY_NUMBER.getError());
            return gainPurchaseAmount();
        }
        return purchasePrice;
    }

    public Integer countLotto(Integer input){
        Integer lottoCount = input/1000;
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIV.getError());
        }
        System.out.println(lottoCount + LOTTO_COUNT_PHRASE);
        return lottoCount;
    }

    public static void printLotto(Lotto lotto){
        System.out.println(lotto.getNumbers());
    }

    public Lotto getWinningInput(){
        System.out.println(LOTTO_WINNING_INPUT);
        String rawWinningInput = Console.readLine();
        System.out.println();
        Lotto answer;
        try {
            answer = new Lotto(Arrays.asList(rawWinningInput.split(DELIMITER)).stream()
                    .map(InputView::parseInt)
                    .collect(Collectors.toList()));
        }
        catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.WIN_INPUT.getError());
            return getWinningInput();
        }
        return answer;
    }

    public Integer gainBonusInput(Lotto answer){
        System.out.println(LOTTO_BONUS_INPUT);
        String rawBonus  = Console.readLine();
        System.out.println();
        Integer bonus = 0;
        try{
            bonus = parseInt(rawBonus);
            checkBonus(bonus, answer);
            checkRange(bonus);
        }
        catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.BONUS.getError());
            return gainBonusInput(answer);
        }
        return bonus;
    }

    public Integer getLottoCount(){
        return this.lottoCount;
    }
}
