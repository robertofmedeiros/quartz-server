package org.roberto.medeiros.quartz.server.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.roberto.medeiros.quartz.server.model.Parametro;
import org.roberto.medeiros.quartz.server.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "parametroController")
@ELBeanName(value = "parametroController")
@Join(path = "/parametros", to = "/parametros-form.jsf")
public class ParametrosController {

    @Autowired
    private ParametroRepository parametroRepository;

    private Parametro parametro = new Parametro();

    public String save() {
        System.out.println("Parametro: " + parametro.toString());
        parametroRepository.save(parametro);
        parametro = new Parametro();
        return "/";
    }
    public Parametro getParametro() {
        return parametro;
    }
}
