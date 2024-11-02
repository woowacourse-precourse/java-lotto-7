package lotto.view;

import java.util.List;
import java.util.stream.Stream;
import lotto.utils.ConstantMessage.GuideMessage;

public class OutputView {
    static final char startPhrase = '[';
    static final char endCharPhrase = ']';
    static final String separatorPhrase = ", ";

    public void printGuide(GuideMessage guideMessage) {
        System.out.println(guideMessage);
    }

    public void printLottoNumber(List<Integer> lottoNumbers) {
        String[] lottoOutput = Stream.of(lottoNumbers).map(String::valueOf).toArray(String[]::new);
        String result = String.join(separatorPhrase, lottoOutput);
        System.out.print(result);
    }


}
