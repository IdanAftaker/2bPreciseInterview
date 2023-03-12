package com.example.interview2bprecise.validators;

import com.google.common.annotations.VisibleForTesting;

public abstract class BaseValidator {

    @VisibleForTesting
    public static void validatePK(Long pk) throws Exception {
        if (pk < 0) {
            throw new Exception("Invalid Primary Key");
        }
    }
}
