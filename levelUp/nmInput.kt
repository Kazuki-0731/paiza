// 自分の得意な言語で
// Let's チャレンジ！！
fun main() {
    val n = readLine()!!.toInt()
    val inputList = List(n) {
        readLine()!!
    }
    for (input in inputList) {
        val rows = input.split(" ")
        var str = ""
        for (i in 1..rows.size - 1) {
            str += rows[i] + " "
        }
        str = str.removeSuffix(" ")
        println(str)
    }
}
