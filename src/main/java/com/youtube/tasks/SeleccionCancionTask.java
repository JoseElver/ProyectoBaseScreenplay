package com.youtube.tasks;

import com.youtube.interactions.SeleccionYReproduccion;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static com.youtube.UI.ListadeCancionesUI.LBL_NOMBRECANCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionCancionTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionYReproduccion.clic()
        );
    }

    public static SeleccionCancionTask on(){

        return instrumented(SeleccionCancionTask.class);
    }
}
