fun main(args: Array<String>) {
  var checkText : String? = " "

  var tagName : String = ""
  var inlineResult = false
  println("------------------------------")

  println("checkText : $checkText")

  //isEmpty()
  try{
    tagName = "isEmpty()"
    inlineResult = checkText!!.isEmpty()
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  //isNotEmpty()
  try{
    tagName = "isNotEmpty()"
    inlineResult = checkText!!.isNotEmpty()
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  // isNullOrEmpty()
  try{
    tagName = "isNullOrEmpty()"
    inlineResult = checkText.isNullOrEmpty()
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  //isBlank()
  try{
    tagName = "isBlank()"
    inlineResult = checkText!!.isBlank()
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  //isNotBlank()
  try{
    tagName = "isNotBlank()"
    inlineResult = checkText!!.isNotBlank()
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  // isNullOrBlank()
  try{
    tagName = "isNullOrBlank()"
    inlineResult = checkText.isNullOrBlank()
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  //orEmpty()
  try{
    tagName = "orEmpty()"
    var str = checkText.orEmpty()
    println("$tagName で $str.")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  // != null
  try{
    tagName = "null check"
    inlineResult = checkText != null
    println("$tagName で $inlineResult")
  } catch (e: Exception){
    println("$tagName Exception Error")
  } finally {
    inlineResult = false
  }

  println("------------------------------")
}
