package assertj_practice.service;

import assertj_practice.model.Hoge;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestHogeServiceTest extends AbstractTest {

    @Test
    public void testAssertThat() {

        // is()がどこにあるか知らないといけない
        assertThat(ACTUAL, is(Hoge.of("hoge", 100L)));

        assertThat(ACTUAL_LIST, hasItem(Hoge.of("hoge1", 1L)));

        // これは通らない（理由もわからない）
//        assertThat(ACTUAL_LIST, is(contains(
//            Hoge.of("hoge1", 1L),
//            Hoge.of("hoge2", 100L),
//            Hoge.of("hoge3", 25L))
//        ));
    }
}
