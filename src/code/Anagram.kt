package code

fun isAnagramFromCharsList(chars: CharArray, word: String) {

    val map = mutableMapOf<Char, Int>()
    for (c in chars) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    for (c in word) {
        map[c] = map.getOrDefault(c, 0) - 1

        if (map[c] == 0)
            map.remove(c)
    }

    if (map.isEmpty())
        println("anagram anu")
    else
        println("anagram alla")

}