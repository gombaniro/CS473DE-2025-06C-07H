open class Book(var title: String, var author: String, var price: Double) {
    open fun read() {
        println("Reading Paper book")
    }
}

class EBook(title: String, author: String, price: Double, var filetype: String) : Book(title, author, price) {
    override fun read() {
        println("Read from Electronic Device")
    }
}

fun main() {
    val book = Book("1984", "George Orwell", 15.99)
    val ebook = EBook("Digital Fortress", "Dan Brown", 9.99, "epub")

    println("Book title: ${book.title}, Author: ${book.author}, Price: ${book.price}")
    book.read()

    println("EBook title: ${ebook.title}, Author: ${ebook.author}, Price: ${ebook.price}, Filetype: ${ebook.filetype}")
    ebook.read()
}
