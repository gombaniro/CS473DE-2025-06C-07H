fun main() {
    print("Enter your weight in pounds: ")
    val weight = readln().toDouble()

    println("""
        Select a planet:
        1. Venus
        2. Mars
        3. Jupiter
        4. Saturn
        5. Uranus
        6. Neptune
    """.trimIndent())

    print("Enter your choice: ")
    val choice = readln().toInt()

    val gravity = when (choice) {
        1 -> 0.78
        2 -> 0.39
        3 -> 2.65
        4 -> 1.17
        5 -> 1.05
        6 -> 1.23
        else -> {
            println("Invalid choice.")
            return
        }
    }

    val resultWeight = weight * gravity
    println("Your weight on the selected planet is: $resultWeight pounds")
}
