package controllers

import play.api.mvc._

import models.Questions
import play.api.db.DB
import play.api.Play.current

import scala.util.Random
import scala.slick.session.Database

object QuestionController extends QuestionController {
}

class QuestionController extends Controller {

  val database = Database.forDataSource(DB.getDataSource())

  def showQuestion() = Action { implicit request =>
    database withSession {
      val r = new Random
      val questionId = r.nextInt(4) + 1
      val question = Questions.getByQuestionId(1)
      Ok(views.html.question.showQuestion("問題です！", question.get))
    }
  }
}
