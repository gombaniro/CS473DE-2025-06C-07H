//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print("Enter an amount, for example, 11.56: ")
    val amount = readln().toDouble()
    val cents = (amount * 100).toInt()

    val dollars = cents / 100
    var remaining = cents % 100
    val quarters = remaining / 25
    remaining %= 25
    val dimes = remaining / 10
    remaining %= 10
    val nickels = remaining / 5
    val pennies = remaining % 5

    println("Your amount $amount consists of")
    println(" $dollars dollars")
    println(" $quarters quarters")
    println(" $dimes dimes")
    println(" $nickels nickels")
    println(" $pennies pennies")


}