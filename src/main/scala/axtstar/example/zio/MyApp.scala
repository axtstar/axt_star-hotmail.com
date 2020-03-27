package axtstar.example.zio

import java.io.IOException

import zio._
import zio.console._

object MyApp extends App {

  def run(args: List[String]): URIO[Console, Int] =
    //failure as 1, success as 0
    args match {
      case x::_ =>
        x match {
          case "0" =>
            //sbt "run 0"
            howOldAreYou.fold(_ => 1, _ => 0)
          case "1" =>
            //I'm not sure how to handle can
            basicOperation.fold(_ => 1, _ => 0)

        }
      case _ =>
        //sbt run
        helloWorld.fold(_ => 1, _ => 0)

    }
  val helloWorld: ZIO[Console, IOException, Unit] =
    for {
      _ <- putStrLn("Hello! What is your name?")
      name <- getStrLn
      _ <- putStrLn(s"Hello, $name, welcome to ZIO!")

    } yield ()

  val howOldAreYou: ZIO[Console, IOException, Unit] =
    for {
      _ <- putStrLn("How old are you?")
      age <- getStrLn
      //age is non int, the below method fails
      _ <- putStrLn(s"You are ${age.toInt} years old!")

    } yield ()

  val basicOperation: ZIO[Console, IOException, Unit] = {
    //this is effect, eager evaluation
    val s1 = ZIO.succeed(42).map(_ * 2)
    for {
      target <- s1
      _ <- putStrLn(s"result is $target")

    } yield ()


  }

}