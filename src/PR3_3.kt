import java.util.*
fun main() {
    val alphabet = charArrayOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К',
        'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
        'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я'
    )
    val scanner = Scanner(System.`in`)
    println("Введите текст (русскими буквами):")
    val inputText = scanner.nextLine().toUpperCase()
    println("Введите ключевое слово:")
    val keyword = scanner.nextLine().toUpperCase()
    println("Выберите действие: 1 - Зашифровать, 2 - Дешифровать")
    val action = scanner.nextInt()
    val result = if (action == 1) {
        encrypt(inputText, keyword, alphabet)
    } else {
        decrypt(inputText, keyword, alphabet)
    }
    println("Результат: $result")
}
fun encrypt(text: String, keyword: String, alphabet: CharArray): String {
    return processText(text, keyword, alphabet, true)
}
fun decrypt(text: String, keyword: String, alphabet: CharArray): String {
    return processText(text, keyword, alphabet, false)
}
fun processText(text: String, keyword: String, alphabet: CharArray, isEncrypt: Boolean): String {
    val result = StringBuilder()
    val keywordIndices = keyword.map { alphabet.indexOf(it) + 1 } // Индексы ключевого слова
    var keywordIndex = 0
    for (char in text) {
        if (char in alphabet) {
            val charIndex = alphabet.indexOf(char) // Индекс текущего символа
            val shift = keywordIndices[keywordIndex % keywordIndices.size] // Сдвиг по ключевому слову
            // Если шифруем, сдвигаем вправо, если расшифровываем - влево
            val newIndex = if (isEncrypt) {
                (charIndex + shift) % alphabet.size
            } else {
                (charIndex - shift + alphabet.size) % alphabet.size
            }
            result.append(alphabet[newIndex]) // Добавляем зашифрованный/расшифрованный символ
            keywordIndex++ // Переходим к следующему символу ключевого слова
        } else {
            result.append(char) // Если символ не в алфавите, добавляем его без изменений
        }
    }
    return result.toString()
}
