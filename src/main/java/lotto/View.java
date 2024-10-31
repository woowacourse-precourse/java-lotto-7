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

    private Integer purchasePrice;
    private Integer lottoCount;

    public Integer getPurchaseAmount(){
        Integer purchasePrice = 0;
        try {
            System.out.println(LOTTO_AMOUNT_PHRASE);
            String rawPurchasePrice = Console.readLine();
            purchasePrice = parseInt(rawPurchasePrice);
            this.lottoCount = this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 1000으로 나누어 떨어지는 숫자로만 기입해주세요.");
            return getPurchaseAmount();
        }
        return purchasePrice;
    }

    public Integer countLotto(Integer input){
        Integer lottoCount = input/1000;
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어 떨어지는 금액을 입력해주세요.");
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

    public Integer getLottoCount(){
        return this.lottoCount;
    }

    public Integer getPurchasePrice(){
        return this.purchasePrice;
    }


}
