// 文字列から子音を除いて出力
fun main(args: Array<String>) {
  val input = readLine()!!.split(" ")[0]
  val inputList = input.split("").filter { it != "" }
  var output = ""
  val consonant = listOf("a", "i", "u", "e", "o", "A", "I", "U", "E", "O")
  for (i in 0..(inputList.size-1)) {
      if (!consonant.contains(inputList[i])) {
          output += inputList[i]
      }
  }
  println(output)
}