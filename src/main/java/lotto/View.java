package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Application.parseInt;

public class View {

    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATICS = "당첨 통계\n---";
    public static final String COMMA = ",";
    public static final String BLANK = "";

    public static Integer getPurchaseAmount(){
        try {
            System.out.println(LOTTO_AMOUNT_PHRASE);
            String rawPurchasePrice = Console.readLine();
            Integer purchasePrice = parseInt(rawPurchasePrice);
            return purchasePrice;
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 오직 숫자로 이루어져야 합니다.");
            getPurchaseAmount();
        }
        return null;
    }


}
