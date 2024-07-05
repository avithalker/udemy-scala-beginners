package playground2

object Fanctions2 extends App {

  def Concat(a:String, b:Int):String = {
    a + " " + b
  }

  def emptyFunction():Int = {42}

  def concatMultiple(value:String, count:Int): String = {
    if(count == 1) value else value + concatMultiple(value, count - 1)
  }

  println(Concat("Avi", 32))
  println(emptyFunction())
  println(concatMultiple("Avi", 8))

  def greeting(name:String,age:Int) = {
    println("Hi, my name is" + name + " and i am " + age + " years old" )
  }

  def factorial(n:Int):Int = {
    if(n == 1) 1
    else n * factorial(n-1)
  }

  def fib(n:Int):Int = {
    if(n == 1 || n == 2) 1
    else fib(n-1) + fib(n-2)
  }

  def isPrime(n:Int) : Boolean = {
    def isPrimeRec (num:Int): Boolean ={
      if(num <=1) true
      else (n % num != 0) && isPrimeRec(num-1)
    }
    isPrimeRec(n-1)
  }

  greeting("Avi",32)
  println(factorial(4))
  println(fib(8))
  println(isPrime(37*17))

}
