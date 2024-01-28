package com.youtube.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.youtube.UI.PaginaInicialUI.TXT_BUSQUEDA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarCancionTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("despacito").into(TXT_BUSQUEDA).thenHit(Keys.ENTER)
        );
    }

    public static BuscarCancionTask on(){
        return instrumented(BuscarCancionTask.class);
    }
}
