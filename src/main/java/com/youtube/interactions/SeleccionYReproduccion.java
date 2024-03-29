package com.youtube.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.youtube.UI.ListadeCancionesUI.LBL_NOMBRECANCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionYReproduccion implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listaCanciones = LBL_NOMBRECANCION.resolveAllFor(actor);
        Random random= new Random();
        int index= random.nextInt(listaCanciones.size());
        WebElementFacade cancion = listaCanciones.get(index);
        cancion.click();
    }

    public static Performable clic(){
        return instrumented(SeleccionYReproduccion.class);
    }
}
