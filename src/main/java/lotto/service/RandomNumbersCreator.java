package lotto.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class RandomNumbersCreator implements NumbersCreator {

    @Override
    public List<Integer> create() {
        try {
            return Randoms.pickUniqueNumbersInRange(
                    LottoBall.NUMBER_START_INCLUSIVE,
                    LottoBall.NUMBER_END_INCLUSIVE,
                    Lotto.LOTTO_BALL_COUNT
            );
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("로또 번호 자동 생성에 문제가 생겨 프로그램을 종료합니다. 다시 실행해 주세요.");
        }
    }

}
