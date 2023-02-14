package track

fun main(args: Array<String>) {
  // このコードは標準入力と標準出力を用いたサンプルコードです。
  // このコードは好きなように編集・削除していただいて構いません。
  // ---
  // This is a sample code to use stdin and stdout.
  // Edit and remove this code as you like.

  do {
    var str = readLine()
    // 0文字
    if (str.isNullOrEmpty()){
      break
    }
    // 20文字以下
    if(str.length <= 20){
      // 正規表現
      val regex = Regex("[a-zA-Z0-9]*")
      if(regex.containsMatchIn(str)){
        println("Hello ${str}!")
      } else {
        break
      }
    }
  } while (true)
}
