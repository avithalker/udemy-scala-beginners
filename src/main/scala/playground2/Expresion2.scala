package playground2

object Expresion2 extends App{

  val x = 1+3 // expression
  var num =6
  println(x)

  val result = if(x==4) 4 else 0
  println(result)

  if(x==4)
      println(result)
      println("success")
  else
      println("failure")
      println("failure")

  val weirdValue = (num  = 98)
  println(weirdValue)

  val codeBlock = {
    val num1 = 8
    val num2 = 9

    if(num1 + num2 > 10) "max" else "min"
  }

println(codeBlock)
  println("done")

}
