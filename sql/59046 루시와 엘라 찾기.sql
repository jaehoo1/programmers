select ANIMAL_ID, NAME, SEX_UPON_INTAKE from ANIMAL_INS
    where NAME = "Lucy" or
        NAME = "Ella" or
        NAME = "Pickle" or
        NAME = "Rogan" or
        NAME = "Sabrina" or
        NAME = "Mitty"
order by ANIMAL_ID;
