package lotto.view;

public class OutputView {
    public static final String REQUEST_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final  String REQUEST_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printRequest(String requestMessage){
        System.out.println(requestMessage);
    }
}
