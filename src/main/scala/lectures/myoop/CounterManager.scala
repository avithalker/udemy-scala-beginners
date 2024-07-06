package lectures.myoop

import scala.annotation.tailrec

object CounterManager extends App {
  val counter = new Counter(50)
  println(counter.CurrentCount())
  println(counter.Inc().CurrentCount())
  println(counter.Inc(20).CurrentCount())

}

class Counter(initValue:Int) {
  def CurrentCount():Int = initValue
  def Inc():Counter = new Counter(this.initValue+1)
  def dec(): Counter = new Counter(this.initValue - 1)

  def Inc(value: Int): Counter = {
    if(value == 0) this
    else this.Inc().Inc(value-1)
  }

  def dec(value: Int): Counter = {
    if(value == 0) this
    else{
      val newCounter = this.dec()
      newCounter.dec(value-1)
    }
  }


}
