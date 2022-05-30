package com.example.application.views;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Calculatrice")
@Route(value = "calcul", layout = MainLayout.class)
@Tag("calculator-view")
@JsModule("./views/calculator-view.ts")
public class CalculatorView extends LitTemplate {
    @Id
    private Button chf0;
    @Id
    private Button chf1;
    @Id
    private Button chf2;
    @Id
    private Button chf3;
    @Id
    private Button chf4;
    @Id
    private Label ecran;
    @Id
    private HorizontalLayout extendedLayout;
    @Id
    private Checkbox extendedChk;
    @Id
    private Button inverse;

    public CalculatorView() {
        List<Button> chiffres = List.of(chf0,chf1,chf2,chf3,chf4);
        for (int i = 0; i < chiffres.size(); i++)
            prepare(chiffres,i);
        extendedChk.addValueChangeListener(this::onCheckChanged);
        inverse.addClickListener(this::onInverse);
    }

    private void onInverse(ClickEvent<Button> e) {
        Notification.show("Erreur !");
    }

    private void onCheckChanged(AbstractField.ComponentValueChangeEvent<Checkbox, Boolean> e) {
        extendedLayout.setVisible(e.getValue());
    }

    private void prepare(List<Button> chiffres, Integer i) {
        Button btn = chiffres.get(i);
        btn.setText(i.toString());
        btn.addClickListener(this::addChiffre);
    }

    private void addChiffre(ClickEvent<Button> e) {
        String number = ecran.getText();
        ecran.setText(number+e.getSource().getText());
    }

}
