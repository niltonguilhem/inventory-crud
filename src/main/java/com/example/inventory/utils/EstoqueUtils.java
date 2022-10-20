package com.example.inventory.utils;

import org.springframework.util.ObjectUtils;

public class EstoqueUtils {
    public static void validatedHeader(String partner)throws Exception {
        validatedPartner(partner);

    }
    public static Boolean validatedPartner (String partner) throws Exception {
        if (!ObjectUtils.isEmpty(partner))
            if (partner.equals("Amazon")|| partner.equals("Americanas")|| partner.equals("Submarino")){
                return true;
            }
        throw new Exception("Partner inválido");
    }
}
