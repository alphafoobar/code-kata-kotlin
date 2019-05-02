package kata02

fun chop(key: Int, a: IntArray): Int {
    return chopper(key, a, 0, a.size)
}

fun chopper(key: Int, a: IntArray, start: Int, size: Int): Int {
    val remaining = size - start

    if (remaining == 0) {
        return -1
    }
    if (remaining == 1) {
        return foundIndex(key, a, start)
    }

    val mid = remaining / 2
    val point = start + mid
    if (a[point] == key) {
        return point
    }
    if (a[point] > key) {
        return chopper(key, a, start, point)
    }
    return chopper(key, a, point + 1, size)
}

fun foundIndex(key: Int, a: IntArray, i: Int): Int {
    if (a[i] == key) {
        return i
    }
    return -1
}
