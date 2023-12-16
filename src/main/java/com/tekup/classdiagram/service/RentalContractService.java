package com.tekup.classdiagram.service;


import com.tekup.classdiagram.payload.request.CURentalContractRequest;

public interface RentalContractService {
    //C
    Object createRentalContract(CURentalContractRequest request);

    //R
    Object getAllRentalContracts();

    Object getRentalContractById(Long id);

    //U
    Object updateRentalContract(Long id, CURentalContractRequest request);

    //D
    Object deleteRentalContract(Long id);
}
