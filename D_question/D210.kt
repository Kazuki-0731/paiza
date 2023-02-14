// 自分の得意な言語で
// Let's チャレンジ！！
fun main(args: Array<String>) {
    val input = readLine()
    val value = input!!.toInt()
    if(100 <= value && value <= 10000){
        println(value * 12)
    }
}