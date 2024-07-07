package lectures.myoop

object AbstractDataTypes extends App{

val myDog = new Dog2()
val myCroc = new Crocodile()

println(myCroc eat myDog)
}

abstract class Animal2{
  val creatureType:String
  def eat:Unit
}

class Dog2 extends Animal2{
  override val creatureType: String = "Canine"
  override def eat: Unit = println("crunch crunch")
}

trait Carnivore{
  def eat(animal:Animal2):String
}

class Crocodile extends Animal2 with Carnivore{

  override val creatureType: String = "Croc"

  override def eat: Unit = println("nomnommmm")

  override def eat(animal: Animal2): String = s"i am a $creatureType and i am eating ${animal.creatureType}"
}


