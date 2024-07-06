package lectures.myoop

object NovelsManager extends  App {

  val author1= new Writer("Avi","Thalker",1991)
  val author2 = new Writer("Orit","Auerbach", 1992)
  val author3 = new Writer("Avi", "Thalker", 1991)


  val book1 = new Novel("Secrets",2024,author1)

  println(author1.FullName())
  println(book1.AuthorAge())
  println(book1.IsWrittenBy(author1))
  println(book1.IsWrittenBy(author2))
  println(book1.IsWrittenBy(author3))

  val book1Copy = book1.Copy(2029)
  println(book1Copy.AuthorAge())
  println(book1Copy.IsWrittenBy(author1))

}

class Writer(firstName:String,surname:String, val yearOfBirth:Int) {

  def FullName():String = s"$firstName $surname"
}

class Novel(name:String, yearOfRelease:Int, author: Writer) {

  def AuthorAge(): Int = yearOfRelease - author.yearOfBirth
  def IsWrittenBy(author: Writer): Boolean =  author == this.author
  def Copy(newYearOfRelease:Int): Novel = new Novel(this.name,newYearOfRelease,this.author)
}
