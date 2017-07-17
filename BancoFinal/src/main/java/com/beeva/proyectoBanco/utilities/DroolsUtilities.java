package com.beeva.proyectoBanco.utilities;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.beeva.proyectoBanco.models.Cuenta;

public class DroolsUtilities {

	public void calcularSospecha(Sospecha sospecha){

			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession ksession = kContainer.newKieSession("ksession-rule");

			@SuppressWarnings("unused")
			FactHandle factl= ksession.insert(sospecha);
			ksession.fireAllRules();
			
			System.err.println(sospecha.getResultado());
	
	}

}
