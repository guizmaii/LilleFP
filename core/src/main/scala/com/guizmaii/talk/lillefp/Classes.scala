package com.guizmaii.talk.lillefp

import scala.concurrent.Future

object Classes {

  class GpsPoint
  case class Person(name: String, age: Int, address: String)
  trait DB {
    def query(q: String, args: Any*): Unit
  }
  trait AsyncNIODB {
    def query(q: String, args: Any*): Future[Unit]
  }

}
