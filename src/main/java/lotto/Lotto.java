package lotto;

import static lotto.domain.ExceptionType.ILLEGAL_ARGUMENT;
import static lotto.domain.MAGIC_NUMBER.SIZE;
import static lotto.domain.MAGIC_NUMBER.START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Handler;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 예외 처리
    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE.getMagicNumber()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<List<Integer>> responseLottoCounts(int request) {
        List<List<Integer>> model = new ArrayList<>();
        Handler handler = new Handler(request);
        for (int i = 0; i < request; i++) {
            List<Integer> generated = handler.generateLotto();
            model.add(generated);
        }
        return model;
    }
    /**
     8. 사용자가 잘못된 값을 입력할 경우 예외 처리
     *       1. 예외 발생 원인을 명확히 전달하는 유형 사용
     *       2. 예1) 입력 가능 범위를 초과한 경우 IllegalArgumentException 예외 처리하며 로또 구매 가능 금액 문구를 출력하고 정상 문구 재입력을 요청
     *       3. 예2) 문자열이 포함된 값을 입력한 경우 NumberFormatException 예외 처리로 에러 메시지를 출력하고 정상 값 재입력을 요청
     */


}
