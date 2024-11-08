import java.util.*
fun main() {
    val scanner = Scanner(System.`in`)
    // Запрашиваем количество строк и столбцов
    println("Введите количество строк:")
    val rows = scanner.nextInt()
    println("Введите количество столбцов:")
    val cols = scanner.nextInt()
    // Создаем двумерный массив
    val array = Array(rows) { IntArray(cols) }
    // Вводим трехзначные числа в массив
    println("Введите ${rows * cols} трехзначных чисел (числа могут повторяться):")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            array[i][j] = scanner.nextInt()
        }
    }
    // Выводим массив
    println("Ваш массив:")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("${array[i][j]} ")
        }
        println()
    }
    // Подсчитываем различные цифры
    val uniqueDigits = mutableSetOf<Char>()
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            // Преобразуем число в строку и добавляем цифры в множество
            val digits = array[i][j].toString()
            for (digit in digits) {
                uniqueDigits.add(digit)
            }
        }
    }
    // Выводим результат
    println("В массиве использовано ${uniqueDigits.size} различных цифр")
}