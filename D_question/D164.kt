// 自分の得意な言語で
// Let's チャレンジ！！
fun main(args: Array<String>) {
  val list = readLine()!!.split(" ").map(String::toInt)
  var output = 0
    for (value in list) {
        if ((1 <= value) || (value <= 256)){
            if (value == 2) {
                println("OK")
            } else if (value == 4) {
                println("OK")
            } else if (value == 8) {
                println("OK")
            } else if (value == 16) {
                println("OK")
            } else if (value == 32) {
                println("OK")
            } else if (value == 64) {
                println("OK")
            } else if (value == 128) {
                println("OK")
            } else if (value == 256) {
                println("OK")
            } else {
                println("NG")
            }
        } else {
            println("NG")
        }
    }
}
