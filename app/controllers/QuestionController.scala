package controllers

import play.api.mvc._

object QuestionController extends QuestionController{
}

class QuestionController extends Controller {

  def showQuestion() = Action {
    Ok(views.html.question.showQuestion("問題です！"))
  }
}
