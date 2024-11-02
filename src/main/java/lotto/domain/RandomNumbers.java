/*
 * 클래스 이름 RandomNumbers
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constant;

import java.util.List;

public class RandomNumbers {

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constant.START_INCLUSIVE, Constant.END_INCLUSIVE, Constant.LOTTO_NUMBER_SIZE);
    }
}
