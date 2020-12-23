fun main() {
    readLine()!!
    val a = readLine()!!
        .split(" ")
        .map(String::toInt)
    val max = readLine()!!
        .split(" ")
        .mapIndexed { index, i -> a[index] * i.toInt() }
        .run { indexOf(this.maxOrNull()!!) + 1 }
    println(max)
}