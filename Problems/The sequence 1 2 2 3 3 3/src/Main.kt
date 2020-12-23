// fastest solution O(n)
fun main() {
    val n = readLine()!!.toInt()
    var solution = ""
    var solutionCount = 0
    var i = 1
    while (i <= n && solutionCount < n) {
        var j = 1
        while (j <= i && solutionCount < n) {
            solutionCount++
            solution += "$i "
            j++
        }
        i++
    }
    println(solution.trim()) // remove last space
}