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
    public static final String THREE = "3개 일치 (5,000원) - ";
    public static final String FOUR = "4개 일치 (50,000원) - ";
    public static final String FIVE = "5개 일치 (1,500,000원) - ";
    public static final String FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String SIX = "6개 일치 (2,000,000,000원) - ";
    public static final String NUM = "개";

    private Integer lottoCount;

    public Integer getPurchaseAmount(){
        Integer purchasePrice = 0;
        try {
            System.out.println(LOTTO_AMOUNT_PHRASE);
            String rawPurchasePrice = Console.readLine();
            System.out.println();
            purchasePrice = parseInt(rawPurchasePrice);
            this.lottoCount = this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            System.out.println(ErrorMessage.ONLY_NUMBER.getError());
            return getPurchaseAmount();
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
            answer = new Lotto(Arrays.asList(rawWinningInput.split(COMMA)).stream()
                    .map(Application::parseInt)
                    .collect(Collectors.toList()));
        }
        catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.WIN_INPUT.getError());
            return getWinningInput();
        }
        return answer;
    }

    public Integer getBonusInput(Lotto answer){
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
            return getBonusInput(answer);
        }
        return bonus;
    }

    public void printResults(WinningDetails grades){
        System.out.println(WIN_STATICS);
        System.out.println(THREE + grades.getThird() + NUM);
        System.out.println(FOUR + grades.getFourth() + NUM);
        System.out.println(FIVE + grades.getFifth() + NUM);
        System.out.println(FIVE_BONUS +grades.getFifthBonus() + NUM);
        System.out.println(SIX + grades.getSixth() + NUM);
    }

    public Integer getLottoCount(){
        return this.lottoCount;
    }
}
