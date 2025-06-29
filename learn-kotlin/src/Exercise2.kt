fun removeDups(input: Array<String>): Array<String> {
    return input.toSet().toTypedArray()
}

fun main() {
    val original = arrayOf("horse", "dog", "cat", "horse", "dog")
    val result = removeDups(original)
    println(result.joinToString(prefix = "[", postfix = "]"))
}
