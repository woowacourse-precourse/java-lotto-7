package view;

public class OutputView {

    public void showPrompt(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println("에러: " + message);  // 에러 메시지 앞에 "에러:" 추가로 더 명확히
    }
}
