// 自分の得意な言語で
// Let's チャレンジ！！
// 1 1 11
// 2 2 22
// 3 3 ==
// 4 4 ==
// 5 5 ==
// 6 6 ==
// 7 7 ==
// 8 8 ==
// 9 9 ==
// 10 -
// 11 1 11 ==
// 12 -
fun main(args: Array<String>) {

  val list = readLine()!!.split(" ").map(String::toInt)
  var month = list[0]
  var days = list[1]
  if (month == days) {
    if (month == 10 || month == 12){
      println("No")
    } else {
      println("Yes")
    }
  } else if (month == 1 && (days == 1 || days == 11)) {
      println("Yes")
  } else if (month == 2 && (days == 2 || days == 22)) {
      println("Yes")
  } else if (month == 11 && (days == 1 || days == 11)) {
      println("Yes")
  } else {
    println("No")
  }
}