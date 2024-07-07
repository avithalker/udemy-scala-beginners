package lectures.myoop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotations2 extends App{

  val person1 = new Person("Avi", "us")
  person1.Print()
  val person2= person1 + "the rockstar"
  person2.Print()
  val person3= +person2
  person3.Print()
  println(person3 Learns "computer science")
  println(person3 LearnsScala)
  println(person3(5))

  class Person(val name:String,favoriteMovive:String,age:Int = 0){

    def Print(): Unit = {
      println(s"My name is $name and my favorite move is: $favoriteMovive. My age is: $age")
    }

    def +(nickName:String):Person = { new Person(s"${this.name} ($nickName)",this.favoriteMovive)}

    def unary_+ : Person = {
      new Person(this.name, this.favoriteMovive, this.age + 1)
    }
    def Learns(profession: String): String = s"$name learns $profession"
    def LearnsScala = this Learns "Scala"
    def apply(watchCount:Int) = s"$name watch \"$favoriteMovive\" $watchCount times."
  }
}
