package com.youtube.stepDefinitions;

import com.youtube.questions.ValidarCancion;
import com.youtube.tasks.BuscarCancionTask;
import com.youtube.tasks.SeleccionCancionTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class YoutubeStepDefinition {

    private static EnvironmentVariables environmentVariables;

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario abre el navegador en la pagina de youtube")
    public void queElUsuarioAbreElNavegadorEnLaPaginaDeYoutube() {
        String baseUrl = environmentVariables.optionalProperty("environments.qa.base.url").get();
        theActorCalled("user").wasAbleTo(
                Open.url(baseUrl)
        );

    }
    @Cuando("el usuario ingresa el nombre de la cancion y presione enter")
    public void elUsuarioIngresaElNombreDeLaCancion() {
        theActorInTheSpotlight().attemptsTo(
                BuscarCancionTask.on()
        );

    }

    @Entonces("el usuario podra reproducir una cancion.")
    public void elUsuarioPodraReproducirUnaCancion() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionCancionTask.on()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        ValidarCancion.from(), Matchers.equalTo(true)
                )
        );

    }
}
