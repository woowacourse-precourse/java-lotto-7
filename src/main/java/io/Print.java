package io;

public class Print {
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_PRINT_MESSAGE = "개를 구입했습니다.";
    public static final String NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    String message;

    public Print(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
