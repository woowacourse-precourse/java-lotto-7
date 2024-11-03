package lotto.view.output.message;

public class RateOfReturnMessageGenerator {

    private static final String RATE_FORMAT = "%,.1f%%";
    private static final String RATE_OF_RETURN_MESSAGE_FORMAT = "총 수익률은 " + RATE_FORMAT + "입니다.";

    public String getMessage(double rateOfReturn) {
        return String.format(RATE_OF_RETURN_MESSAGE_FORMAT, rateOfReturn);
    }

}
