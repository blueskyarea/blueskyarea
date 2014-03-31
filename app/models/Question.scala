package models

import scala.slick.driver.PostgresDriver.simple._

import org.joda.time.DateTime

case class Question(
                     id: Int,
                     categoryId: Int,
                     question: String,
                     answer: String,
                     questionCount: Int,
                     rightCount: Int,
                     createdAt: DateTime,
                     modifiedAt: DateTime)

class Questions extends Table[Question]("questions") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def categoryId = column[Int]("category_id")

  def question = column[String]("question")

  def answer = column[String]("answer")

  def questionCount = column[Int]("question_count")

  def rightCount = column[Int]("right_count")

  def createdAt = column[DateTime]("created_at")

  def modifiedAt = column[DateTime]("modified_at")

  def * = id ~ categoryId ~ question ~ answer ~ questionCount ~ rightCount ~ createdAt <> (Question.apply _, Question.unapply _)

}
