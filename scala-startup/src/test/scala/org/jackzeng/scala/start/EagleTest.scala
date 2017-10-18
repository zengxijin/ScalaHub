package org.jackzeng.scala.start

import org.jackzeng.scala.start.lang.Eagle

/**
  * Created by zengxj on 17-10-18
  */
object EagleTest {

  def main(args: Array[String]): Unit = {
    val eagle = new Eagle()
    eagle.info()

    var flyable = eagle
    flyable.fly
    println(flyable.canFly)

    var talkable = eagle
    println(talkable.canTalk)
    talkable.talk

  }

}
