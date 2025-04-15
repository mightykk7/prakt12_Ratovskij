import kotlinx.coroutines.*
import java.util.*

suspend fun fetchData(index: Int): String {
    delay(800L)
    return "Данные от функции $index"
}
fun main() {
    println("Введите количество функций (n):")
    val input = readLine()
    if (input == null || input.isEmpty() || input.toIntOrNull() == null || input.toInt() <= 0) {
        println("Неверный ввод. Введите положительное число.")
        return
    }
    val n = input.toInt()
    println("Запуск $n корутин...")
    val results = Array(n) { "" }
    runBlocking {
        for (i in 1..n) {
            launch {
                val data = fetchData(i)
                results[i - 1] = data
            }
        }
    }
    println("Результаты выполнения:")
    for (result in results) {
        println(result)
    }
}
