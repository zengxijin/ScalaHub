package org.jackzeng.scala.start.langfeature

/** abstract class抽象类的方法可以部分实现,也可以部分不实现
  * 可以包含成员变量
  * Created by zengxj on 17-10-18
  */
abstract class Animal {

  var animalType: String

  def info(): Unit = {
    println("I am " + animalType)
  }

  def sing

  var foots: Int

}
