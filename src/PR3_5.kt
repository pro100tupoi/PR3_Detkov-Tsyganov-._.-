fun main() {
    // Вводим массив слов
    println("Введите массив слов, разделенных запятыми:")
    val input = readLine() ?: ""
    val words = input.split(",").map { it.trim() }
    // Группируем слова по буквам
    val groupedWords = groupAnagrams(words)
    // Выводим группы
    println("Группы слов, состоящих из одинаковых букв:")
    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}
fun groupAnagrams(words: List<String>): List<List<String>> {
    // Используем карту для группировки слов
    val anagramMap = mutableMapOf<String, MutableList<String>>()
    for (word in words) {
        // Сортируем буквы в слове и используем их как ключ
        val sortedWord = word.toCharArray().sorted().joinToString("")
        anagramMap.computeIfAbsent(sortedWord) { mutableListOf() }.add(word)
    }
    // Возвращаем только значения карты как список списков
    return anagramMap.values.toList()
}
