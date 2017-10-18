package org.jackzeng.scala.start.lang

/**
  * Created by zengxj on 17-10-18
  */
/**
  * trait非常像抽象类abstract class,但是trait可以多重继承
  * 可以有成员变量
  */
trait Flyable {

  def fly

  var canFly: Boolean
}
