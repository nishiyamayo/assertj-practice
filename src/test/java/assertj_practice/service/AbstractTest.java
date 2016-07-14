package assertj_practice.service;

import assertj_practice.model.Hoge;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbstractTest {

    public static Hoge ACTUAL;

    public static List<Hoge> ACTUAL_LIST = new ArrayList<>();
    public static HashMap<String, Hoge> ACTUAL_MAP = new HashMap<>();

    @BeforeClass
    public static void beforeTest() {
        ACTUAL = Hoge.of("hoge", 100L);

        ACTUAL_LIST.add(Hoge.of("hoge1", 1L));
        ACTUAL_LIST.add(Hoge.of("hoge2", 100L));
        ACTUAL_LIST.add(Hoge.of("hoge3", 25L));

        ACTUAL_MAP.put("hoge1", Hoge.of("hoge1", 1L));
        ACTUAL_MAP.put("hoge2", Hoge.of("hoge2", 100L));
        ACTUAL_MAP.put("hoge3", Hoge.of("hoge3", 25L));
        ACTUAL_MAP.put("hoge4", Hoge.of("hoge4", 50L));

    }

}
