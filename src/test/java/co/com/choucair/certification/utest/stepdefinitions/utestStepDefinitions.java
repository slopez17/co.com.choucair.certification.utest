package co.com.choucair.certification.utest.stepdefinitions;

import co.com.choucair.certification.utest.model.UtestData;
import co.com.choucair.certification.utest.questions.Answer;
import co.com.choucair.certification.utest.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;


import java.util.List;

import static co.com.choucair.certification.utest.util.Constant.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;


public class utestStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("^than the user wants to sign up at utest$")
    public void thanTheUserWantsToSignUpAtUtest() {
        theActorCalled(NAME_ACTOR).wasAbleTo(
                OpenUp.theUtestPage(),
                FindTheRegisterForm.forNewUsers());
    }


    @When("^it enters its log information$")
    public void itEntersItsLogInformation(List<UtestData> utestData)throws Exception {
        theActorInTheSpotlight().attemptsTo(
                FilloutPersonalFields.withYourselfData(utestData.get(ZERO)),
                Check.whether(utestData.get(ZERO).getStrCity().equals("") || utestData.get(ZERO).getStrZipCode().equals("") || utestData.get(ZERO).getStrCountry().equals(""))
                        .andIfSo(FilloutLocationFields.withDefaultData())
                        .otherwise(FilloutLocationFields.withYourAddressData(utestData.get(ZERO))),
                FilloutDevicesFields.withYourDeviceData(utestData.get(ZERO)),
                AcceptTermsAndConditions.settingYourPassword(utestData.get(ZERO))
        );
    }
    @Then("^it can read$")
    public void itCanRead(List<UtestData> utestData)throws Exception {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(utestData.get(ZERO).getStrMessage())));

    }
}
