package playground2

object DefaultArg extends App {

  def buildGreetingMessage(name:String = "Avi",message:String = "Welcome"):Unit ={
    println(s"${name.trim()}  ${message}")
  }

  buildGreetingMessage()
  buildGreetingMessage(message =  "goodbye")
  buildGreetingMessage("Ron      !")
}
