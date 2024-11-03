package lotto.view;

public class OutputView {
    private static OutputView instance;
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT_HEADER_MESSAGE = "당첨 통계\n---\n";

    private OutputView() {
    }

    public static synchronized OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printPurchaseInput(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printLottos(Integer lottoCount, String lottosString){
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, lottoCount));
        System.out.println(lottosString);
    }
}
