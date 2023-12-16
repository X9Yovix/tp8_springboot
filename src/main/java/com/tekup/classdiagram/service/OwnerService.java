package com.tekup.classdiagram.service;

import com.tekup.classdiagram.payload.request.CUOwnerRequest;

public interface OwnerService {
    //C
    Object createOwner(CUOwnerRequest request);

    //R
    Object getAllOwners();

    Object getOwnerById(Long id);

    //U
    Object updateOwner(Long id, CUOwnerRequest request);

    //D
    Object deleteOwner(Long id);
}
