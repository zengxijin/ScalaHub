package org.jackzeng.scala.start.langfeature

/**
  * Created by zengxj on 17-10-18
  */
class Eagle extends Animal with Flyable with Talkable {

  var animalType = "Eagle"

  override def sing: Unit = {
    println(animalType + " probably can sing")
  }

  override var foots: Int = 2

  override def fly: Unit = {
    println(animalType + " can fly")
  }

  override var canFly: Boolean = true

  override def talk: Unit = {
    println(animalType + " can't talk")
  }

  override var canTalk: Boolean = false
}
