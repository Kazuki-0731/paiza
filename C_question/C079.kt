// ・1 行目に買ったカードの枚数 N とカードの種類数を示す整数 M が入力されます。
// ・続く N 行に開けたカードのカード番号 c_i (1 ≦ i ≦ N) が入力されます。
// ・最終行の末尾に改行が 1 つ入ります。
fun main(args: Array<String>) {
  val inputList = readLine()!!.split(" ").map(String::toInt)
  var N = inputList[0]
  val M: Array<Int?> = arrayOfNulls(inputList[1])
  var loopFlag = true
  var count = 1
  while(loopFlag && count <= N) {
      var inputNumber = readLine()!!.toInt()
      M[inputNumber-1] = inputNumber
      if (!M.contains(null)) {
          println(count)
          loopFlag = false
      }
      count++
  }
  if (M.contains(null)) {
      println("unlucky")
  }
}