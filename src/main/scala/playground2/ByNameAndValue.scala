package playground2

object ByNameAndValue extends App {

  def print(name: String, greetingMessage: => String): Unit = {
    println(name+", "+greetingMessage)
    println(name + ", " + greetingMessage)
  }

  def buildGreetingMessage():String ={
    "Hello! The time is: "+ java.time.LocalTime.now()
  }

  print("Avi",buildGreetingMessage())
}
