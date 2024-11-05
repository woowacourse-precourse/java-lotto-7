package lotto.message;

public class MessagePrinter {

    private MessagePrinter() {}

    public static void printMessage(LottoMessage lottoMessage) {
        System.out.println(lottoMessage.getMessage());
    }
}
