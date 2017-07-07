/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portfoliovaleria.controller;

import br.com.portfoliovaleria.model.business.Viewer;
import br.com.portfoliovaleria.model.dao.ViewerDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author valerialarissa
 */
@Named("subscribeBean")
@RequestScoped
public class SubscribeController extends AbstractController {

    @Inject
    private ViewerDAO viewerDAO;

    @Inject
    private Viewer viewer;

    public String saveSubscriber() {
        viewerDAO.save(viewer);
        return "";
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

}