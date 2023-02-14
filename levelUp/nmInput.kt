// 自分の得意な言語で
// Let's チャレンジ！！
fun main() {
    val n = readLine()!!.toInt()
    val columns = List(n) {
        readLine()!!
    }
    for (column in columns) {
        val rows = column.split(" ")
        var str = ""
        for (i in 1..rows.size - 1) {
            str += rows[i] + " "
        }
        //文字列の末尾から指定した文字列を削除する
        str = str.removeSuffix(" ")
        println(str)
    }
}
