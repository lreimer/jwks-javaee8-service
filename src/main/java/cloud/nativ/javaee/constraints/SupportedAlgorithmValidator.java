/*
 *     _   ___ ___     _             _      _   _
 *    /_\ |_ _| _ \   /_\  _ _  __ _| |_  _| |_(_)__ ___
 *   / _ \ | ||   /  / _ \| ' \/ _` | | || |  _| / _(_-<
 *  /_/ \_\___|_|_\ /_/ \_\_||_\__,_|_|\_, |\__|_\__/__/
 *                                     |__/
 *
 *                                        (c) 2018 BMW AG
 */
package cloud.nativ.javaee.constraints;

import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

/**
 * Custom {@link ConstraintValidator} implementation to check {@link SupportedAlgorithm} strings.
 */
public class SupportedAlgorithmValidator implements ConstraintValidator<SupportedAlgorithm, String> {

    @SuppressWarnings("deprecation")
    private static final Set<String> RSA_ALGS = unmodifiableSet(new HashSet<>(asList(
            JWSAlgorithm.RS256.getName(),
            JWSAlgorithm.RS384.getName(),
            JWSAlgorithm.RS512.getName(),
            JWEAlgorithm.RSA1_5.getName(),
            JWEAlgorithm.RSA_OAEP.getName(),
            JWEAlgorithm.RSA_OAEP_256.getName()
    )));

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return RSA_ALGS.contains(value);
    }
}