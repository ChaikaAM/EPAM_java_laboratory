package test.java.option;

import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class OptionalExample {
    Optional<String> myOptional;

    //With init of the class
    {
        myOptional = getOptional();
    }

    @Test
    public void get() {
        myOptional.ifPresent(System.out::println);

        myOptional.orElse("null... sorry");
        myOptional.orElseGet(() -> "null... sorry");
        //myOptional.orElseThrow(UnsupportedOperationException::new);
    }

    @Test
    public void ifPresent() {
        myOptional.ifPresent(System.out::println);

        if (myOptional.isPresent()) {
            System.out.println(myOptional.get());
        }
    }

    @Test
    public void filter() {
        final Optional<String> o1Filtered = myOptional.isPresent() && myOptional.get().equals("ololo") ?
                myOptional : Optional.empty();

        assertThat(o1Filtered, is(myOptional.filter("ololo"::equals)));
    }

    @Test
    public void map() {
        final Optional<String> o1Mapped = myOptional.isPresent() ? Optional.of(myOptional.get() + "ololo") : Optional.empty();

        assertThat(o1Mapped, is(myOptional.map(s -> s + "ololo")));
    }

    @Test
    public void orElse() {
        final String s = myOptional.isPresent() ? myOptional.get() : "ololo";

        assertThat(s, is(myOptional.orElse("ololo")));
    }

    @Test
    public void orElseGet() {
        final String s = myOptional.isPresent() ? myOptional.get() : ((Supplier<String>) () -> "ololo").get();

        assertThat(s, is(myOptional.orElseGet(() -> "ololo")));
    }

    @Test
    public void orElseThrow() {
        try {
            final String s;
            if (myOptional.isPresent()) s = myOptional.get();
            else throw new IllegalArgumentException();
            assertThat(s, is(myOptional.get()));
        } catch (IllegalArgumentException e) {
            assertFalse(myOptional.isPresent());
        }
    }

    private Optional<String> getOptional() {
        return ThreadLocalRandom.current().nextBoolean()
                ? Optional.empty()
                : Optional.of("ololo");
    }
}
