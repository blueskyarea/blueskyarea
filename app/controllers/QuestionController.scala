package controllers

import play.api.mvc._

import models.Questions
import play.api.db.DB
import play.api.Play.current

import scala.slick.session.Database

object QuestionController extends QuestionController {
}

class QuestionController extends Controller {

  lazy val database = Database.forDataSource(DB.getDataSource())

  def showQuestion() = Action { implicit request =>
    database withSession {
      val question = Questions.getByQuestionId(1)
      Ok(views.html.question.showQuestion("問題です！", question.get))
    }
  }
}
