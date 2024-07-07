package lectures.myoop

object InheritanceAndTraits2 extends App {

  val cat = new Cat()
  val dog = new Dog()
  val animal:Animal = new Dog()

  animal.eat

dog.eat 
  cat.crunch

}

class Animal{
  def eat = println("nomnom")
}

class Cat extends Animal{
  def crunch = {
    eat
    println("crunch crunch")
  }
}

class Dog extends Animal{
  override def eat: Unit = println("crunch crunch")
}
class PersonBase(name:String,age:Int)
class Adult(name:String,age:Int, idCard:String)extends  PersonBase(name,age)

