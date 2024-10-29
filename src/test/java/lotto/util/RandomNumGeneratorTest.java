package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumGeneratorTest {

    @Test
    void 숫자_생성_개수_테스트() {
        //given
        NumGenerator randomNumGenerator = new RandomNumGenerator();

        //when
        List<Integer> nums = randomNumGenerator.generate();

        //then
        assertEquals(nums.size(),6);
    }

    @Test
    void 숫자_생성_중복_테스트() {
        //given
        NumGenerator randomNumGenerator = new RandomNumGenerator();

        //when
        List<Integer> nums = randomNumGenerator.generate();
        HashSet<Integer> set = new HashSet<>();

        //then
        for (Integer num : nums) {
            assertTrue(set.add(num));
        }
    }

    @Test
    void 숫자_생성_범위_테스트() {
        //given
        NumGenerator randomNumGenerator = new RandomNumGenerator();

        //when
        List<Integer> nums = randomNumGenerator.generate();

        //then
        for (Integer num : nums) {
            assertTrue(1 <= num && num <= 45);
        }
    }
}