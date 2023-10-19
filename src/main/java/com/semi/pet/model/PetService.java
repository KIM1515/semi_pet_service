package com.semi.pet.model;


public class PetService {
    private static int petno;
    
    public static int getPetno() {
        return petno;
    }

    public static void setPetno(int petno) {
        PetService.petno = petno;
    }
}


   

    
