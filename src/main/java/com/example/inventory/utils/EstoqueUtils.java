package com.example.inventory.utils;

import com.example.inventory.handler.exception.FabricanteException;
import com.example.inventory.handler.exception.PartnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

public class EstoqueUtils {

    private String partner;
    private String fabricante;

    public static void validated(String partner, String fabricante) {

        validatedPartner(partner);
        validatedFabricante(fabricante);
    }

    public String getPartner() {
        return partner;
    }

    public String getFabricante() {
        return fabricante;
    }

    private static final Logger logger = LoggerFactory.getLogger(EstoqueUtils.class);

    public static void validatedHeader(String partner) throws PartnerException {
        validatedPartner(partner);

    }

    public static Boolean validatedPartner(String partner) throws PartnerException {
        logger.info("m=validatedPartner - status=start ");
        if (!ObjectUtils.isEmpty(partner))
            if (partner.equals("Amazon") || partner.equals("Americanas") || partner.equals("Submarino")) {
                logger.info("m=validatedPartner - status=finish ");
                return true;
            } else {
                logger.warn("m=PartnerException - status=warn ");
                throw new PartnerException(String.format
                        ("O partner informado é inválido."));
            }

        return null;
    }

    public static Boolean validatedFabricante(String fabricante) throws FabricanteException {
        logger.info("m=validatedFabricante - status=start ");
        if (!ObjectUtils.isEmpty(fabricante))
            if (fabricante.equals("Motul") || fabricante.equals("Fran") || fabricante.equals("Bosh")
                    || fabricante.equals("Marele") || fabricante.equals("HP") || fabricante.equals("Apple")) {
                logger.info("m=validatedFabricante - status=finish ");
                return true;
            } else {
                logger.warn("m=FabricanteException - status=warn ");
                throw new FabricanteException(String.format
                        ("O fabricante informado é inválido."));

            }
            return null;
    }
}
