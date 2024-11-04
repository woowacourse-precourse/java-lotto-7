package lotto.view;

public class OutputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT = "개를 구매했습니다.";

    public void printRequestMoney(){
        System.out.println(INPUT_MONEY);
    }

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + LOTTO_COUNT);
    }
}
