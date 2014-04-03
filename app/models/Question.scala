package models

import scala.slick.driver.PostgresDriver.simple._

import Database.threadLocalSession

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

class Questions extends Table[Question]("questions") with TimeTypeMapper {
  def id = column[Int]("id")

  def categoryId = column[Int]("category_id")

  def question = column[String]("question")

  def answer = column[String]("answer")

  def questionCount = column[Int]("question_count")

  def rightCount = column[Int]("right_count")

  def createdAt = column[DateTime]("created_at")

  def modifiedAt = column[DateTime]("modified_at")

  def * = id ~ categoryId ~ question ~ answer ~ questionCount ~ rightCount ~ createdAt ~ modifiedAt <> (Question.apply _, Question.unapply _)

  def getByQuestionId(questionId: Int): Option[Question] = {
    val query = for {
      ques <- Questions.filter(_.id === questionId)
    } yield ques
    query.firstOption
  }
}

object Questions extends Questions
