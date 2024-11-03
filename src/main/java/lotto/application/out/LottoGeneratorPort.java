package lotto.application.out;

import lotto.domain.core.Lotto;

/**
 * 로또 번호 생성을 위한 포트 인터페이스.
 */
public interface LottoGeneratorPort {

    /**
     * 로또 번호를 생성합니다.
     *
     * @return 생성된 로또 정보
     */
    Lotto generate();
}
