package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.OperationProductDb;
import kg.megacom.kassaapp.models.OperationProducts;
import kg.megacom.kassaapp.services.OperationProductService;

import java.util.List;

public class OperationProductServiceImpl implements OperationProductService {


    @Override
    public boolean saveOperationProducts(int operationId, List<OperationProducts> operationProductsList) {
        boolean isSaveResult = OperationProductDb.INSTANCE.saveOperationProducts(operationId,operationProductsList);
        return isSaveResult;
    }
}
/*
  boolean isSaveResult = OperationProductDB.INSTANCE.saveOperationProduct(operationId, operationProductsList);
        return isSaveResult;
 */