package assertj_practice.service;

import assertj_practice.model.CustomHoge;
import assertj_practice.model.Hoge;
import assertj_practice.model.InvalidHogeNameException;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.Assertions.tuple;

public class AssertJHogeServiceTest extends AbstractTest {

    @Test
    public void testAssertThat() {

        // メソッドチェーンが使えるから補完で出てくる！
        assertThat(ACTUAL).isEqualTo(Hoge.of("hoge", 100L));

        // 型にあったassertionがメソッド補完に出てくる
        assertThat(ACTUAL_LIST)
            .contains(Hoge.of("hoge1", 1L));

        assertThat(ACTUAL_LIST)
            .containsExactly(
                Hoge.of("hoge1", 1L),
                Hoge.of("hoge2", 100L),
                Hoge.of("hoge3", 25L));
    }

    @Test
    public void testAssertJMap() {
        assertThat(ACTUAL_MAP)

            .containsOnlyKeys("hoge1", "hoge2", "hoge3", "hoge4")

            .containsValues(
                Hoge.of("hoge1", 1L),
                Hoge.of("hoge2", 100L),
                Hoge.of("hoge3", 25L),
                Hoge.of("hoge4", 50L))

            .contains(
                entry("hoge1", Hoge.of("hoge1", 1L)),
                entry("hoge2", Hoge.of("hoge2", 100L)),
                entry("hoge3", Hoge.of("hoge3", 25L)),
                entry("hoge4", Hoge.of("hoge4", 50L)))

            .satisfies(map -> map.entrySet().stream()
                .allMatch(e -> e.getKey()
                    .equals(e.getValue().getName()))
            );
    }

    @Test
    public void testAssertJFeature() {
        List<Hoge> ACTUAL_INCLUDE_SOME_EXTENDS
            = new ArrayList<>(ACTUAL_LIST);
        ACTUAL_INCLUDE_SOME_EXTENDS.add(
            CustomHoge.of(
                "customHoge1",
                100000L,
                Hoge.of("hoge1", 1L),
                Hoge.of("hoge2", 100L),
                Hoge.of("hoge3", 25L)));

        // ACTUAL_INCLUDE_SOME_EXTENDSの持つ要素のうち、
        // 特定のinstanceのものだけをフィルタリング
        // 要素のフィールド変数で展開し平坦に
        // 展開した要素でAssertion！
        assertThat(ACTUAL_INCLUDE_SOME_EXTENDS)
            .filteredOn(hoge -> hoge instanceof CustomHoge)
            .flatExtracting("hoges")
            .containsExactly(
                Hoge.of("hoge1", 1L),
                Hoge.of("hoge2", 100L),
                Hoge.of("hoge3", 25L));
    }

    @Test
    public void testThrowException() {
        // exceptionの判定が出来る
        assertThatThrownBy(() -> CustomHoge.of("fuga", 100L, Hoge.of("", 100L)))

            .isExactlyInstanceOf(InvalidHogeNameException.class)
            .hasMessage("fuga is invalid name!!");
    }

    @Test
    public void testSafelyAssert() {

        // すべてのassertをまとめて実行し、結果を得られる
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(ACTUAL).as("collect name: %s", ACTUAL.getName())
            .isEqualTo(Hoge.of("hoge", 100L));
        softly.assertThat(ACTUAL).as("invalid name: %s", ACTUAL.getName())
            .isEqualTo(Hoge.of("fuga", 100L));                              // 名前がおかしい
        softly.assertThat(ACTUAL_LIST)
            .extracting("name", "value")
            .containsExactly(tuple("hoge1", 100L), tuple("hoge3", 25L));    // 要素が足りない

        softly.assertAll();
    }
}
