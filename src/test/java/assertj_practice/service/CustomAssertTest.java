package assertj_practice.service;

import assertj_practice.model.Hoge;
import org.junit.Test;

import static assertj_practice.custom.MyAssertions.assertThat;

public class CustomAssertTest extends AbstractTest {

    @Test
    public void testCustomAssertions() {

        // クラスの持つフィールド変数を基にしてassertionのメソッドが作られる
        assertThat(ACTUAL)
            .hasName("hoge")
            .hasValue(100L);

        // Listもよしなに変換してくれる
        assertThat(CUSTOM_ACTUAL)
            .hasName("choge")
            .hasValue(10000L)
            .hasHoges(ACTUAL)
            .hasOnlyHoges(ACTUAL, Hoge.of("choge", 10000L))
            .doesNotHaveHoges(Hoge.of("fuga", 1000L));

        // 既存のassertThatとも共存できる
        assertThat("hoge1")
            .startsWith("hoge");
    }
}
