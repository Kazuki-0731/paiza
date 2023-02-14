// [入力]
// TicTacToe
//
// [出力]
// +++++++++++
// +TicTacToe+
// +++++++++++
fun main(args: Array<String>) {
  val input = readLine()!!
  val string_size = input.length
  var decorate = ""
  for (i in 1..string_size+2) {
      decorate += "+"
  }
  println(decorate)
  println("+%s+".format(input))
  println(decorate)
}
