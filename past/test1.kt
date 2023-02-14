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
    // 正規表現
    val regex = Regex("[0-9]*")
    if(regex.containsMatchIn(str)){
      // 数値の判定
      val num = convert(str!!.toLong())
      println(num)
    } else {
      //仕様に反する入力を受け取った場合， -1−1を出力
      println(-1)
      break
    }
  } while (true)
}

fun convert(number: Long): String? { // 0 to 999 999 999 999
  if (number == 0L) {
    return "zero"
  }
  var snumber = number.toString()
  // pad with "0"
  val mask = "000000000000"
  val df = DecimalFormat(mask)
  snumber = df.format(number)
  // XXXnnnnnnnnn
  val billions: Int = Integer.parseInt(snumber.substring(0, 3))
  // nnnXXXnnnnnn
  val millions: Int = Integer.parseInt(snumber.substring(3, 6))
  // nnnnnnXXXnnn
  val hundredThousands: Int = Integer.parseInt(snumber.substring(6, 9))
  // nnnnnnnnnXXX
  val thousands: Int = Integer.parseInt(snumber.substring(9, 12))
  val tradBillions: String
  tradBillions = when (billions) {
    0 -> ""
    1 -> convertLessThanOneThousand(billions)
            .toString() + " billion "
    else -> convertLessThanOneThousand(billions)
            .toString() + " billion "
  }
  var result = tradBillions
  val tradMillions: String
  tradMillions = when (millions) {
    0 -> ""
    1 -> convertLessThanOneThousand(millions)
            .toString() + " million "
    else -> convertLessThanOneThousand(millions)
            .toString() + " million "
  }
  result = result + tradMillions
  val tradHundredThousands: String
  tradHundredThousands = when (hundredThousands) {
    0 -> ""
    1 -> "one thousand "
    else -> convertLessThanOneThousand(hundredThousands)
            .toString() + " thousand "
  }
  result = result + tradHundredThousands
  val tradThousand: String
  tradThousand = convertLessThanOneThousand(thousands)
  result = result + tradThousand
  // remove extra spaces!
  return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ")
}
