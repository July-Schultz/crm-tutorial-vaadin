package com.vaadin.tutorial.crm.ui.views.login;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");

        add(
                new H1("Vaadin CRM"),
                login,
                new Html("<div>" +
                        "<p>" +
                        "This is the finished application that you learn to build in the" +
                        "<a href='https://vaadin.com/learn/tutorials/modern-web-apps-with-spring-boot-and-vaadin' target='_blank'>" +
                        "Building Modern Web Apps with Spring Boot and Vaadin</a> tutorial series." +
                        "</p>" +
                        "<p>Log in with user: <b>user</b> and password: <b>password</b>." +
                        "</p>" +
                        "The database in this demo is reset every few hours." +
                        "</div>")
        );
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (!beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .getOrDefault("error", Collections.emptyList())
                .isEmpty()) {
            login.setError(true);
        }
    }
}