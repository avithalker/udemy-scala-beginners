package playground2

import scala.annotation.tailrec

object Recursion2 extends App{

  def factorial (n:Int): Int = {
    if(n <=1 ) 1
    else{
      println("")
      val result = n * factorial(n-1)
      result
    }
  }

  def concatenate (str:String,count:Int):String = {
    @tailrec
    def concatenateHelper(result:String,count:Int):String = {
      if(count <= 1) result +" "+ str
      else concatenateHelper(result +" "+ str, count - 1)
    }

    concatenateHelper("",count)
  }

  def IsPrime(num:Int):Boolean = {
    @tailrec
    def IsPrimeHelper(divider:Int, isPrimeResult:Boolean) : Boolean = {
      if(!isPrimeResult) return false
      if(divider <= 1) true
      else IsPrimeHelper(divider - 1, num % divider != 0 )
    }

    @tailrec
    def IsPrimeHelper2(divider: Int): Boolean = {
      if (divider <= 1) true
       else if(num % divider == 0)  false
      else IsPrimeHelper2(divider - 1)
    }

    IsPrimeHelper(num-1,true)
  }

  println(concatenate("Avi", 3))
  println(IsPrime(20))
}
