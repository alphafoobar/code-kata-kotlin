package kata02

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinarySearchTest {

    @Test
    @DisplayName("Easy tests")
    fun easyScenarios() {
        assertThat(chop(key = 3, a = intArrayOf())).isEqualTo(-1)
    }

    @Test
    @DisplayName("Tests of 1 items, when missing")
    fun singleItemMissing() {
        assertThat(chop(key = 3, a = intArrayOf(1))).isEqualTo(-1)
    }

    @Test
    @DisplayName("Tests of 1 items")
    fun singleItemFound() {
        assertThat(chop(key = 1, a = intArrayOf(1))).isEqualTo(0)
    }

    @Test
    @DisplayName("Tests of 3 items")
    fun smallSets() {
        assertThat(chop(key = 1, a = intArrayOf(1, 3, 5))).isEqualTo(0)
        assertThat(chop(key = 3, a = intArrayOf(1, 3, 5))).isEqualTo(1)
        assertThat(chop(key = 5, a = intArrayOf(1, 3, 5))).isEqualTo(2)
    }

    @Test
    @DisplayName("Tests of 3 that cannot be found return -1")
    fun missingOnArrayOf3() {
        assertThat(chop(key = 0, a = intArrayOf(1, 3, 5))).isEqualTo(-1)
        assertThat(chop(key = 2, a = intArrayOf(1, 3, 5))).isEqualTo(-1)
        assertThat(chop(key = 4, a = intArrayOf(1, 3, 5))).isEqualTo(-1)
        assertThat(chop(key = 6, a = intArrayOf(1, 3, 5))).isEqualTo(-1)
    }

    @Test
    @DisplayName("Tests of 4")
    fun mediumSets() {
        assertThat(chop(key = 1, a = intArrayOf(1, 3, 5, 7))).isEqualTo(0)
        assertThat(chop(key = 3, a = intArrayOf(1, 3, 5, 7))).isEqualTo(1)
        assertThat(chop(key = 5, a = intArrayOf(1, 3, 5, 7))).isEqualTo(2)
        assertThat(chop(key = 7, a = intArrayOf(1, 3, 5, 7))).isEqualTo(3)
    }

    @Test
    @DisplayName("Tests of 4 that cannot be found return -1")
    fun missingOnArrayOf4() {
        val anArrayOf4 = intArrayOf(1, 3, 5, 7)
        assertThat(chop(key = 0, a = anArrayOf4)).isEqualTo(-1)
        assertThat(chop(key = 2, a = anArrayOf4)).isEqualTo(-1)
        assertThat(chop(key = 4, a = anArrayOf4)).isEqualTo(-1)
        assertThat(chop(key = 6, a = anArrayOf4)).isEqualTo(-1)
        assertThat(chop(key = 8, a = anArrayOf4)).isEqualTo(-1)
    }
}
