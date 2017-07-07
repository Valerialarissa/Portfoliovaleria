/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portfoliovaleria.controller;

import br.com.portfoliovaleria.model.business.Feedback;
import br.com.portfoliovaleria.model.dao.FeedbackDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author valerialarissa
 */
@Named("feedbackBean")
@RequestScoped
public class FeedbackController extends AbstractController {
  
    @Inject
    private FeedbackDAO feedbackDAO;

    @Inject
    private Feedback feedback;

    public String saveFeedback() {
       feedbackDAO.save(feedback);
        return "";
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

   
 
}
