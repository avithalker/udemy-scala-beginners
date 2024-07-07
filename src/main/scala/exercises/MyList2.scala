package exercises

object ListTest2 extends App{
  val myList2 = new IntList(3,new IntList(2,EmptyList))
  println(myList2.IsEmpty())
  println(myList2.head)
  println(myList2.tail.head)
  println(myList2.PrintElements())
  println(myList2.Add(4).PrintElements())
}

abstract class MyList2 {
  def head:Int
  def tail:MyList2
  def IsEmpty():Boolean
  def Add(number:Int):MyList2
  def PrintElements():String
}

object EmptyList extends MyList2{

  override def head: Int = throw new NoSuchElementException()
  override def tail: MyList2 = throw new NoSuchElementException()

  override def IsEmpty(): Boolean = true

  override def Add(number: Int): MyList2 = new IntList(number,EmptyList)

  override def PrintElements(): String = "i am here"
}
class IntList(val h: Int, val t: MyList2) extends MyList2{
  override def head:Int = h
  override def tail:MyList2 = t
  override def IsEmpty():Boolean = false
  override def Add(number:Int) = new IntList(number,this)

  override def PrintElements(): String = {
    if(tail.IsEmpty()) s"$head"
    else s"$head ${tail.PrintElements()}"
  }
}

