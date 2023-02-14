// 1 合あたり 540 kcalとして1日に食べるお米の量 n 合が与えられるので何 kcal摂取するのかを出力してください。
// 末尾に改行を入れ、余計な文字、空行を含んではいけません。
fun main(args: Array<String>) {
  val inputList = readLine()!!.split(" ").map(String::toInt)
  println(inputList[0] * 540)
}
