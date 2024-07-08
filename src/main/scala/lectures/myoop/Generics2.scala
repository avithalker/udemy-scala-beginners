package lectures.myoop

import scala.language.postfixOps

object Generics2 extends App {
  val listOfInt:MyGenericList[Int] = new MyGenericListImp(1,new MyGenericListImp(2,EmptyGenericList))
  val listOfStrings: MyGenericList[String] = new MyGenericListImp("Avi", new MyGenericListImp("Thalekr", EmptyGenericList))
  val num:Int = 8
  println(listOfInt.PrintElements())
  println(listOfStrings.PrintElements())
  
  println(listOfInt.Filter(new IsEven()).PrintElements())
  println(listOfInt.Map(new incrementTransformer()).PrintElements())

}

abstract class MyGenericList[+A] {
  def head:A
  def tail:MyGenericList[A]
  def IsEmpty():Boolean
  def Add[B >:A](element:B):MyGenericList[B]
  def PrintElements():String
  def Filter(predicate: GenericPredicate[A]):MyGenericList[A]
  def Map[B](transformer:GenericTransformer[A,B]):MyGenericList[B]
  //def FlatMap[B](transformer: GenericTransformer[A,MyGenericList[B]]):MyGenericList[B]
}

object EmptyGenericList extends MyGenericList[Nothing]{

  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyGenericList[Nothing] = throw new NoSuchElementException()

  override def IsEmpty(): Boolean = true

  override def Add[B >:Nothing](element: B): MyGenericList[B] = new MyGenericListImp(element,EmptyGenericList)

  override def PrintElements(): String = "i am here"

  override def Filter(predicate: GenericPredicate[Nothing]): MyGenericList[Nothing] = EmptyGenericList

  override def Map[B](transformer: GenericTransformer[Nothing, B]): MyGenericList[B] = EmptyGenericList

  //override def FlatMap[B](transformer: GenericTransformer[Nothing, MyGenericList[B]]): MyGenericList[B] = EmptyGenericList 
}
class MyGenericListImp[+A](val h: A, val t: MyGenericList[A]) extends MyGenericList[A]{
  override def head:A = h
  override def tail:MyGenericList[A] = t
  override def IsEmpty():Boolean = false
  override def Add[B >:A](element:B) = new MyGenericListImp(element,this)

  override def PrintElements(): String = {
    if(tail.IsEmpty()) s"$head"
    else s"$head ${tail.PrintElements()}"
  }

  override def Filter(predicate: GenericPredicate[A]): MyGenericList[A] = {
    if(predicate.Test(head)) new MyGenericListImp[A](head,this.tail.Filter(predicate))
    else this.tail.Filter(predicate)
  }

  override def Map[B](transformer: GenericTransformer[A, B]): MyGenericList[B] = {
    new MyGenericListImp[B](transformer.TransformMe(this.head),tail.Map(transformer))
  }
}

trait GenericPredicate[-T]{
  def Test(value:T):Boolean
}

trait  GenericTransformer[-A,B]{
  def TransformMe(source:A):B
}

class IsEven  extends GenericPredicate[Int]{
  override def Test(value:Int): Boolean = value % 2 == 0
}

class IsShort extends GenericPredicate[String]{
  override def Test(value: String): Boolean = value.length < 4
}

class numberToString extends GenericTransformer[Int,String] {
  override def TransformMe(source: Int): String = source.toString()
}

class incrementTransformer extends GenericTransformer[Int,Int]{
  override def TransformMe(source: Int): Int = source+1
}
