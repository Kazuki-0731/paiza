// 4桁のうち、同じ数字が含まれているのか
fun main(args: Array<String>) {
    val inputList = readLine()!!.split(" ")
    val contains = mutableString(inputList[0])
    if (contains) {
      println("NG")
    } else {
      println("OK")
    }
}

fun mutableString(string: String): Boolean {
    var result = false
    for (i in 0..9) {
        if (string.chunked(1).filter { it.toInt() == i }.size >= 2){
            result = true
        }
    }
    return result
}