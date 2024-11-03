package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {


    /**
     * "1,2"을 ,로 split했을때 1과 2로 잘분리되는 지 확인하는 학습테스트 구현
     *  "1"을 ,로 split했을때 1만 포함하는 배열이 반환되는지에 대한 학습테스트 구현
     */


    @Test
    void split테스트(){
        String value = "1,2";
        String[] split = value.split(",");
        assertThat(split).contains("1", "2");
    }


    @Test
    void split단위테스트(){
        String value = "1";
        String[] split = value.split(",");
        assertThat(split).containsExactly("1");
    }







}
