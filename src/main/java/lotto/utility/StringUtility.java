package lotto.utility;

import java.util.Arrays;
import java.util.List;

public class StringUtility {

    private static final String CANNOT_USE_INSTANCE_ERROR_MSG = "해당 유틸리티 클래스를 인스턴스화 할 수 없습니다.";

    public StringUtility(){
        throw new IllegalStateException(CANNOT_USE_INSTANCE_ERROR_MSG);
    }

    public static List<String> splitBySplitter(String s,String splitter){
        return Arrays.stream(s.split(splitter))
                .toList();
    }
}
