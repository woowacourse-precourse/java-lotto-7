package lotto.view;

public class OutPutView implements OutPutViewInterface {

    private OutPutView() {
        throw new IllegalStateException("OutPutView is utility class");
    }

    public static final OutPutViewInterface INSTANCE = new OutPutView();

    @Override
    public void printMessageWithNewLine(String message) {
        printMessage(message);
        printNewLine();
    }

    @Override
    public void printMessagesWithNewLine(String... messages) {
        printMessages(messages);
        printNewLine();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }

    private void printMessages(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
