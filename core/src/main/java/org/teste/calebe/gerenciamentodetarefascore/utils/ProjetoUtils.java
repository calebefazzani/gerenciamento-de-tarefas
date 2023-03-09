package org.teste.calebe.gerenciamentodetarefascore.utils;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class ProjetoUtils {

    public static <T> T requireNonNull(T object, Supplier<? extends RuntimeException> exceptionSupplier) {
        try {
            return Objects.requireNonNull(object);
        } catch (NullPointerException e) {
            throw exceptionSupplier.get();
        }
    }

    public static String requireNonNullOrEmpty(String str, Supplier<? extends RuntimeException> exceptionSupplier) {
        String value = Optional.ofNullable(str).filter(e -> !e.isEmpty()).orElse(null);
        return requireNonNull(value, exceptionSupplier);
    }
}
