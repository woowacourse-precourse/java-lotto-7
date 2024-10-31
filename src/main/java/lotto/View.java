package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.Application.*;

public class View {

    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATICS = "당첨 통계\n---";
    public static final String COMMA = ",";
    public static final String BLANK = "";

    private Integer purchasePrice;
    private Integer lottoCount;
    private Lotto answer;
    private String rawWinningInput;

    public Integer getPurchaseAmount(){
        Integer purchasePrice = 0;
        try {
            System.out.println(LOTTO_AMOUNT_PHRASE);
            String rawPurchasePrice = Console.readLine();
            purchasePrice = parseInt(rawPurchasePrice);
            this.lottoCount = this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            return getPurchaseAmount();
        }
        return purchasePrice;
    }

    public Integer countLotto(Integer input){
        Integer lottoCount = input/1000;
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어지는 숫자로만 기입해주세요.");
        }
        System.out.println(lottoCount + LOTTO_COUNT_PHRASE);
        return lottoCount;
    }

    public static void printLotto(Lotto lotto){
        String joinString = "[";
        joinString = String.join(", ", lotto.getNumbers().toString());
        joinString = joinString + "]";
        System.out.println(joinString);
    }

    public Lotto getWinningInput(){
        System.out.println(LOTTO_WINNING_INPUT);
        String rawWinningInput = Console.readLine();
        try {
            Lotto answer = new Lotto(Arrays.asList(rawWinningInput.split(COMMA)).stream()
                    .map(Application::parseInt)
                    .collect(Collectors.toList()));
        }
        catch (IllegalArgumentException e){
            return getWinningInput();
        }
        this.answer = answer;
        return answer;
    }

    public Integer getBonusInput(){
        System.out.println(LOTTO_BONUS_INPUT);
        String rawBonus  = Console.readLine();
        Integer bonus = 0;
        try{
            bonus = parseInt(rawBonus);
            checkBonus(bonus, answer);
            checkRange(bonus);
        }
        catch (IllegalArgumentException e){
            return getBonusInput();
        }
        return bonus;
    }

    public Integer getLottoCount(){
        return this.lottoCount;
    }

    public Integer getPurchasePrice(){
        return this.purchasePrice;
    }
}
