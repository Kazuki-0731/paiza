// 各折り紙は 1 辺の長さが D cm 、すなわち縦 D cm × 横 D cm の正方形です。
// これらの折り紙を、左右に長く伸びた直線を基準に貼り付けていきます。
// ただし、各折り紙について、いずれか 1 辺がちょうど直線に重なるようにします。
// また、 1 枚目を貼り付けたあと、 2 枚目以降は以下のルールに従って順に貼り付けていきます。
// i + 1 枚目の折り紙が i 枚目の折り紙に d_{i + 1} cm 重なっている
// 例1
// 3枚 4cm
// 2枚目の折り紙が、1枚目の折り紙に、2cm重なっている
// 3枚目の折り紙が、2枚目の折り紙に、1cm重なっている
// 例2
// 4 10
// 3
// 4
// 5
// 1枚目の折り紙が、2枚目の折り紙に、3cm重なっている
// 2枚目の折り紙が、3枚目の折り紙に、4cm重なっている
// 3枚目の折り紙が、4枚目の折り紙に、5cm重なっている
// ・2 ≦ N ≦ 100
// ・2 ≦ D ≦ 10
// ・1 ≦ d_i ≦ D/2 (2 ≦ i ≦ N)
fun main(args: Array<String>) {
  val inputList = readLine()!!.split(" ").map(String::toInt)
  var N = inputList[0]
  var D = inputList[1]
  var one_side = D
  for (i in 1..(N - 1)) {
      var diff_side = readLine()!!.toInt()
      one_side += (D-diff_side)
  }
  println(one_side * D)
}
