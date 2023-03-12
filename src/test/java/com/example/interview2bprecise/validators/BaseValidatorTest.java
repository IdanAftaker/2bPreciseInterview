package com.example.interview2bprecise.validators;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class BaseValidatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testValidatePK() throws Exception {
        BaseValidator.validatePK(10L);
        Assert.assertThrows(Exception.class, () -> BaseValidator.validatePK(-1L));
    }
}