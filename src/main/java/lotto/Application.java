package lotto;

public class Application {
    static final String DATANAME_AMOUNT = "구입금액을";
    static final String DATANAME_WINNINGNUM = "당첨 번호를";
    static final String DATANAME_BONUSNUM = "보너스 번호를";

    static InputHandler inputHandler = new InputHandler();

    public static void main(String[] args) {
        inputHandler.inputData(DATANAME_AMOUNT);
        //구매 결과 실행
        inputHandler.inputData(DATANAME_WINNINGNUM);
        inputHandler.inputData(DATANAME_BONUSNUM);
        //당첨 통계 실행
    }
}

class InputHandler {
    final String REQUEST_MESSAGE = " 입력해 주세요.";

    public String inputData(String dataName) {
        System.out.println(dataName + REQUEST_MESSAGE);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

}
