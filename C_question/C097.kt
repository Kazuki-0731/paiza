// 1 行目にはそれぞれ整数 N, X, Y がこの順で半角スペース区切りで与えられます。
// これらは応募者が N 人、X倍、Y倍を指す
fun main(args: Array<String>) {
  val inputList = readLine()!!.split(" ").map(String::toInt)
  var N = inputList[0]
  var X = inputList[1]
  var Y = inputList[2]
  for (i in 1..N) {
      if ((i % X == 0) && (i % Y == 0)) {
          println("AB")
      } else if((i % X == 0) && (i % Y != 0)){
          println("A")
      } else if((i % X != 0) && (i % Y == 0)) {
          println("B")
      } else {
          println("N")
      }
  }
}