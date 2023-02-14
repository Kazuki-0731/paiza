// 1 ≦ A, B, C ≦ 1,000
// A, B, C はすべて異なる
fun main(args: Array<String>) {
  val list = readLine()!!.split(" ").map(String::toInt)
  var output_a = list[0]
  var output_b = list[1]
  var output_c = list[2]

  if (output_a < output_b){
      // a < b
      if (output_a < output_c) {
          // a < b or c
          if (output_b < output_c) {
              // bが2番目
              println(output_b)
          } else {
              // cが2番目
              println(output_c)
          }
      } else {
          // c < a < b
          // aが2番目
          println(output_a)
      }
  } else {
      // b < a
      if (output_b < output_c) {
          // b < a or c
          if (output_a < output_c) {
              // aが2番目
              println(output_a)
          } else {
              // cが2番目
              println(output_c)
          }
      } else {
          // c < b < a
          // bが2番目
          println(output_b)
      }
  }
}