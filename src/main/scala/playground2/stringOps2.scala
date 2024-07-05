package playground2

object stringOps2 extends App {

  val str:String = "Hello, i am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Avi"))
  println(str.replace(" ","-"))

  val name="Avi"
  val age = 12
  val greeting = s"Hello, my name is $name and i am $age years old"
  println(greeting)

}
