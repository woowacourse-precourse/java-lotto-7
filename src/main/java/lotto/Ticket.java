package lotto;

public class Ticket {
    private static final String REQUEST_NON_DUPLICATED_NUMBER = "중복되지 않은 숫자 6개를 입력해주세요.";
    private static final String REQUEST_RIGHT_SIZE_MESSAGE = "숫자 6개를 입력해주세요. 예) 1,2,3,4,5,6";
    private static final int TICKET_SIZE = 6;


    private static void checkTicketSize(int size) {
        if (size != TICKET_SIZE) {
            throw new IllegalArgumentException(REQUEST_NON_DUPLICATED_NUMBER);
        }
    }
}
