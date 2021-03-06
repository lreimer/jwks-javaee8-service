package cloud.nativ.javaee.constraints;

import com.nimbusds.jose.jwk.KeyUse;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

/**
 * Custom {@link ConstraintValidator} implementation to check {@link SupportedKeyUse} strings.
 */
public class SupportedKeyUseValidator implements ConstraintValidator<SupportedKeyUse, String> {

    private static final Set<String> KEY_USAGES = unmodifiableSet(new HashSet<>(asList(
            KeyUse.ENCRYPTION.identifier(),
            KeyUse.SIGNATURE.identifier()
    )));

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return KEY_USAGES.contains(value);
    }
}
