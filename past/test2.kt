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
    // 10の位の桁
    private val tensNamesU = arrayOf(
            "",
            "Ten ",
            "Twenty ",
            "Thirty ",
            "Forty ",
            "Fifty ",
            "Sixty ",
            "Seventy ",
            "Eighty ",
            "Ninety "
    )
    private val tensNamesL = arrayOf(
            "",
            "ten ",
            "twenty ",
            "thirty ",
            "forty ",
            "fifty ",
            "sixty ",
            "seventy ",
            "eighty ",
            "ninety "
    )
    // 1桁の数値と13～19までの数
    private val numNamesU = arrayOf(
            "",
            "One ",
            "Two ",
            "Three ",
            "Four ",
            "Five ",
            "Six ",
            "Seven ",
            "Eight ",
            "Nine ",
            "Ten ",
            "Eleven ",
            "Twelve ",
            "Thirteen ",
            "Fourteen ",
            "Fifteen ",
            "Sixteen ",
            "Seventeen ",
            "Eighteen ",
            "Nineteen "
    )
    // 1桁の数値と13～19までの数
    private val numNamesL = arrayOf(
            "",
            "one ",
            "two ",
            "three ",
            "four ",
            "five ",
            "six ",
            "seven ",
            "eight ",
            "nine ",
            "ten ",
            "eleven ",
            "twelve ",
            "thirteen ",
            "fourteen ",
            "fifteen ",
            "sixteen ",
            "seventeen ",
            "eighteen ",
            "nineteen "
    )

    // 千より少ないのか判定(はじめの大文字)
    private fun convertLessThanOneThousandUpper(number: Int): String {
        var number = number
        var soFar: String
        if (number % 100 < 20) {
            soFar = numNamesU[number % 100]
            number /= 100
        } else {
            soFar = numNamesU[number % 10]
            number /= 10
            soFar = tensNamesU[number % 10] + soFar
            number /= 10
        }
        return if (number == 0) soFar else numNamesU[number] + "hundred " + soFar
    }
    // 千より少ないのか判定(小文字)
    private fun convertLessThanOneThousandLower(number: Int): String {
        var number = number
        var soFar: String
        if (number % 100 < 20) {
            soFar = numNamesL[number % 100]
            number /= 100
        } else {
            soFar = numNamesL[number % 10]
            number /= 10
            soFar = tensNamesL[number % 10] + soFar
            number /= 10
        }
        return if (number == 0) soFar else numNamesL[number] + "hundred " + soFar
    }

    // 変換関数
    fun convert(number: Long): String { // 0 to 999 999 999 999
        // zeroを返却
        if (number == 0L) {
            return "zero"
        }
        // 文字列に変換
        var snumber = number.toString()
        // 1千億
        val mask = "000000000000"
        val df = DecimalFormat(mask)
        // formatメソッドで
        snumber = df.format(number)
        // XXXnnnnnnnnn
        val billions: Int = Integer.parseInt(snumber.substring(0, 3))
        // nnnXXXnnnnnn
        val millions: Int = Integer.parseInt(snumber.substring(3, 6))
        // nnnnnnXXXnnn
        val hundredThousands: Int = Integer.parseInt(snumber.substring(6, 9))
        // nnnnnnnnnXXX
        val thousands: Int = Integer.parseInt(snumber.substring(9, 12))

        // billionの桁
        val tradBillions: String
        tradBillions = when (billions) {
            0 -> ""
            1 -> convertLessThanOneThousandUpper(billions) + " billion "
            else -> convertLessThanOneThousandUpper(billions) + " billion "
        }
        var result = tradBillions

        // millionの桁
        val tradMillions: String
        tradMillions = when (millions) {
            0 -> ""
            1 -> {
                if(result.isNullOrEmpty()){
                    convertLessThanOneThousandUpper(millions) + "million "
                } else {
                    convertLessThanOneThousandLower(millions) + "million "
                }
            }
            else -> {
                convertLessThanOneThousandLower(millions) + "million "
            }
        }
        result = result + tradMillions

        // 3桁
        val tradHundredThousands: String
        tradHundredThousands = when (hundredThousands) {
            0 -> ""
            1 -> "one thousand "
            else -> {
                convertLessThanOneThousandLower(hundredThousands) + "thousand "
            }
        }
        result = result + tradHundredThousands
        val tradThousand: String
        tradThousand = convertLessThanOneThousandLower(thousands)
        result = result + tradThousand
        return result
    }
}