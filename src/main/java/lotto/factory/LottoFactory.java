package lotto.factory;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;

public class LottoFactory {

    private static final LottoFactory instance = new LottoFactory();
    private final LottoNumberGenerator generator = new LottoNumberGenerator();

    // private 생성자로 외부 인스턴스화 차단
    private LottoFactory() {
    }

    // 싱글톤 인스턴스 반환 메서드
    public static LottoFactory getInstance() {
        return instance;
    }

    // LottoService 전용 티켓 생성 메서드
    public Lotto createLotto() {
        List<Integer> numbers = generator.generateNumbers();
        return new Lotto(numbers);
    }
}
