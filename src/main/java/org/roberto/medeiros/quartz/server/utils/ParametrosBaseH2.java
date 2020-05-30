package org.roberto.medeiros.quartz.server.utils;

import org.roberto.medeiros.quartz.server.model.Parametro;
import org.roberto.medeiros.quartz.server.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParametrosBaseH2 {

    @Autowired
    private ParametroRepository parametroRepository;

    public void carregarParametrosBase() throws Exception {

        List<Parametro> parametroList = parametroRepository.findAll();

        if(parametroList != null || !parametroList.isEmpty()){
            for(Parametro pr : parametroList){
                Config.getIntance().getProperties().setProperty(pr.getParametro(), pr.getValor());
            }
        }else{
            throw new Exception("Nenhum Parametro foi encontrado!");
        }
    }
}
