package lectures.myoop

object OOBasics2  extends  App {

  val person = new Person("Avi", 15)
  val  person2 = new Person()
  println(person)
  println(person.x)
  println(person.x)
  println(person.greet("ron"))
}

class Person(name: String, val age: Int) {

  def this () = {
    this("avi",213)
  }

  val x:Int =2

  def greet(name:String):Unit = {
    println(s"Hello ${this.name}, your age is $age and the result is $x")
  }

}
