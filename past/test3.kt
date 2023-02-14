package track

import java.text.DecimalFormat

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
            val engNumerWord = EnglishNumberToWords()
            // 数値の判定
            val num = engNumerWord.convert(str!!.toLong())
            println(num)
        } else {
            //仕様に反する入力を受け取った場合， -1−1を出力
            println(-1)
            break
        }
    } while (true)
}

class EnglishNumberToWords {
    // 10の位の桁で
    private val tensNames = arrayOf(
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    )
    private val numNames = arrayOf(
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    )

    // 千より少ないのか判定
    private fun convertLessThanOneThousand(number: Int): String {
        var number = number
        var soFar: String
        if (number % 100 < 20) {
            soFar = numNames[number % 100]
            number /= 100
        } else {
            soFar = numNames[number % 10]
            number /= 10
            soFar = tensNames[number % 10] + soFar
            number /= 10
        }
        return if (number == 0) soFar else numNames[number] + " hundred" + soFar
    }

    // 変換関数
    fun convert(number: Long): String { // 0 to 999 999 999 999
        // zeroを返却
        if (number == 0L) {
            return "zero"
        }
        // 文字列に変換
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
            1 -> convertLessThanOneThousand(billions) + " billion "
            else -> convertLessThanOneThousand(billions) + " billion "
        }
        var result = tradBillions
        val tradMillions: String
        tradMillions = when (millions) {
            0 -> ""
            1 -> convertLessThanOneThousand(millions) + " million "
            else -> convertLessThanOneThousand(millions) + " million "
        }
        result = result + tradMillions
        val tradHundredThousands: String
        tradHundredThousands = when (hundredThousands) {
            0 -> ""
            1 -> "one thousand "
            else -> convertLessThanOneThousand(hundredThousands) + " thousand "
        }
        result = result + tradHundredThousands
        val tradThousand: String
        tradThousand = convertLessThanOneThousand(thousands)
        result = result + tradThousand
        // remove extra spaces!
//        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ")
        return result
    }

    /**
     * testing
     * @param args
     */
//    fun main(args: Array<String?>?) {
//        System.out.println("*** " + convert(0))
//        System.out.println("*** " + convert(1))
//        System.out.println("*** " + convert(16))
//        System.out.println("*** " + convert(100))
//        System.out.println("*** " + convert(118))
//        System.out.println("*** " + convert(200))
//        System.out.println("*** " + convert(219))
//        System.out.println("*** " + convert(800))
//        System.out.println("*** " + convert(801))
//        System.out.println("*** " + convert(1316))
//        System.out.println("*** " + convert(1000000))
//        System.out.println("*** " + convert(2000000))
//        System.out.println("*** " + convert(3000200))
//        System.out.println("*** " + convert(700000))
//        System.out.println("*** " + convert(9000000))
//        System.out.println("*** " + convert(9001000))
//        System.out.println("*** " + convert(123456789))
//        System.out.println("*** " + convert(2147483647))
//        System.out.println("*** " + convert(3000000010L))
//        /*
//     *** zero
//     *** one
//     *** sixteen
//     *** one hundred
//     *** one hundred eighteen
//     *** two hundred
//     *** two hundred nineteen
//     *** eight hundred
//     *** eight hundred one
//     *** one thousand three hundred sixteen
//     *** one million
//     *** two millions
//     *** three millions two hundred
//     *** seven hundred thousand
//     *** nine millions
//     *** nine millions one thousand
//     *** one hundred twenty three millions four hundred
//     **      fifty six thousand seven hundred eighty nine
//     *** two billion one hundred forty seven millions
//     **      four hundred eighty three thousand six hundred forty seven
//     *** three billion ten
//     **/
//    }
}