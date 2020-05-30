package org.roberto.medeiros.quartz.server.controller;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.roberto.medeiros.quartz.server.model.Parametro;
import org.roberto.medeiros.quartz.server.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope(value = "session")
@Component(value = "parametrosList")
@ELBeanName(value = "parametrosList")
@Join(path = "/listaParametros", to = "/parametros-list.jsf")
public class ParametroListController {

    @Autowired
    private ParametroRepository parametroRepository;

    private List<Parametro> parametroList;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        parametroList = parametroRepository.findAll();
        System.out.println("Lista" + parametroList.toString());
    }

    public List<Parametro> getParametroList() {
        return parametroList;
    }
}
